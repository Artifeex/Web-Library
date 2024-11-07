package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.domain.entity.Genre;

import java.util.List;


public interface AuthorService {

    Author create(Author author);

    Author getById(Integer id);

    void update(Author author);

    void delete(Integer id);

    List<Author> getAll();
}
