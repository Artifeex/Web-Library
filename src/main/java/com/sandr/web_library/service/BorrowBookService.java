package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.BorrowedBook;

public interface BorrowBookService {

    BorrowedBook borrowBook(Integer userId, Integer libraryId, Integer bookId, Integer count);

    void returnBook(Integer borrowBookId, Integer count);
}
