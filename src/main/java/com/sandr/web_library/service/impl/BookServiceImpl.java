package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.repository.BookRepository;
import com.sandr.web_library.service.AuthorService;
import com.sandr.web_library.service.BookService;
import com.sandr.web_library.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;

    @Override
    @Transactional
    public void update(Book book) {
        Book bookFromDB = getById(book.getId());
        bookRepository.save(bookFromDB);
    }

    @Override
    @Transactional
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id " + id + " not found"));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    //Как правильно добавлять сущности?
    @Override
    @Transactional
    public void addGenre(Integer bookId, Integer genreId) {
        Genre genre = genreService.getById(genreId); // проверка того, существует ли такая книга и жанр
        Book book = getById(bookId);
        book.addGenre(genre);
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void addAuthor(Integer bookId, Integer authorId) {
        Author author = authorService.getById(authorId);
        Book book = getById(bookId);
        book.addAuthor(author);
        bookRepository.save(book);
    }

    @Override
    public Book getBookWithGenreAndAuthorById(Integer id) {
        return bookRepository.findBookWithGenresAndAuthorsById(id);
    }
}
