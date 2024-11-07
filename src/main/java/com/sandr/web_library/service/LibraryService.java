package com.sandr.web_library.service;

import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.domain.exception.ResourceNotFoundException;
import com.sandr.web_library.repository.LibraryRepository;

import java.util.List;

public interface LibraryService {

    Library create(Library library);

    Library getById(Integer id);

    void update(Library library);

    void delete(Integer id);

    List<Library> getAll();

}
