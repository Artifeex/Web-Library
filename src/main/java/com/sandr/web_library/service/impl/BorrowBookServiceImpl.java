package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.BorrowedBook;
import com.sandr.web_library.domain.entity.LibraryBook;
import com.sandr.web_library.domain.entity.User;
import com.sandr.web_library.domain.exception.NotEnoughBooksInLibraryException;
import com.sandr.web_library.repository.BorrowedBookRepository;
import com.sandr.web_library.service.BorrowBookService;
import com.sandr.web_library.service.LibraryBookService;
import com.sandr.web_library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BorrowBookServiceImpl implements BorrowBookService {

    private final LibraryBookService libraryBookService;
    private final BorrowedBookRepository borrowedBookRepository;
    private final UserService userService;

    private static final Integer DAYS_TO_RETURN = 7;

    @Transactional
    @Override
    public BorrowedBook borrowBook(Integer userId, Integer libraryId, Integer bookId, Integer count) {
        LibraryBook libraryBook = libraryBookService.getLibraryBook(libraryId, bookId);
        if(count > libraryBook.getCount()) {
            throw new NotEnoughBooksInLibraryException("Not enough books with id " + bookId
                    + " in library with id " + libraryId);
        }
        User user = userService.getById(userId);
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBorrowDate(LocalDateTime.now());
        borrowedBook.setReturnDate(LocalDateTime.now().plusDays(DAYS_TO_RETURN));
        borrowedBook.setLibraryBook(libraryBook);
        borrowedBook.setUser(user);
        borrowedBook.setCount(count);
        borrowedBookRepository.save(borrowedBook);
        libraryBookService.updateCountBook(libraryId, bookId, libraryBook.getCount() - count);
        return borrowedBook;
    }

    @Transactional
    @Override
    public void returnBook(Integer borrowBookId, Integer count) {

    }
}
