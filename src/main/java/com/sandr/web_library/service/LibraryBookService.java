package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.LibraryBook;

import java.util.List;

public interface LibraryBookService {

    void addNewBook(Integer libraryId, Integer bookId, Integer count);

    void updateCountBook(Integer libraryId, Integer bookId, Integer count);

    List<LibraryBook> getAllBooks(Integer libraryId);

    void deleteBookFromLibrary(Integer libraryId, Integer bookId);

    LibraryBook getLibraryBook(Integer libraryId, Integer bookId);
}
