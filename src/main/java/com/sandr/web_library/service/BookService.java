package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.domain.entity.Genre;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book getById(Integer id);

    Book getBookWithGenreAndAuthorById(Integer id);

    void update(Book book);

    void delete(Integer id);

    List<Book> getAll();

    void addGenre(Integer bookId, Integer genreId);

    void addAuthor(Integer bookId, Integer authorId);
}
