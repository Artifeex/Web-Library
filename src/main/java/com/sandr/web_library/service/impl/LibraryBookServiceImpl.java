package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.domain.entity.LibraryBook;
import com.sandr.web_library.domain.exception.ResourceAlreadyExists;
import com.sandr.web_library.domain.exception.ResourceNotFoundException;
import com.sandr.web_library.repository.LibraryBookRepository;
import com.sandr.web_library.service.BookService;
import com.sandr.web_library.service.LibraryBookService;
import com.sandr.web_library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LibraryBookServiceImpl implements LibraryBookService {

    private final LibraryBookRepository libraryBookRepository;
    private final LibraryService libraryService;
    private final BookService bookService;

    @Transactional
    @Override
    public void addNewBook(Integer libraryId, Integer bookId, Integer count) {
        Optional<LibraryBook> libraryBook = libraryBookRepository
                .findByLibraryIdAndBookId(libraryId, bookId);
        if (libraryBook.isPresent()) {
            throw new ResourceAlreadyExists("Book with id " + bookId +
                    " already exists in library with id " + libraryId);
        } else {
            Library library = libraryService.getById(libraryId);
            Book book = bookService.getById(bookId);
            LibraryBook newLibraryBook = new LibraryBook();
            newLibraryBook.setLibrary(library);
            newLibraryBook.setBook(book);
            newLibraryBook.setCount(count);
            libraryBookRepository.save(newLibraryBook);
        }

    }

    @Transactional
    @Override
    public void updateCountBook(Integer libraryId, Integer bookId, Integer count) {
        libraryBookRepository.findByLibraryIdAndBookId(libraryId, bookId).ifPresentOrElse(
                libraryBook -> {
                    libraryBook.setCount(count);
                    libraryBookRepository.save(libraryBook);
                },
                () -> {
                    throw new ResourceNotFoundException("Not found book with id " + bookId
                            + " in library with id " + libraryId + "or vice versa");
                }
        );

    }

    @Override
    public List<LibraryBook> getAllBooks(Integer libraryId) {
        return libraryBookRepository.findAllBooksByLibraryId(libraryId);
    }

    @Transactional
    @Override
    public void deleteBookFromLibrary(Integer libraryId, Integer bookId) {
        libraryBookRepository.deleteLibraryBookById(libraryId, bookId);
    }

    @Override
    public LibraryBook getLibraryBook(Integer libraryId, Integer bookId) {
        return libraryBookRepository.findByLibraryIdAndBookId(libraryId, bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found book with id " + bookId
                        + " in library with id " + libraryId + "or vice versa"));
    }
}
