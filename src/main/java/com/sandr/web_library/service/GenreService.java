package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.domain.entity.Library;

import java.util.List;


public interface GenreService {

    Genre create(Genre library);

    Genre getById(Integer id);

    void update(Genre library);

    void delete(Integer id);

    List<Genre> getAll();

    List<Genre> getAllById(List<Integer> ids);
}
