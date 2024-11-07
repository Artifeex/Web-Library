package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.domain.exception.ResourceNotFoundException;
import com.sandr.web_library.repository.LibraryRepository;
import com.sandr.web_library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Transactional
    public Library create(Library library) {
        return libraryRepository.save(library);
    }

    public Library getById(Integer id) {
        return libraryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library with id " + id + " not found"));
    }

    @Transactional
    public void update(Library library) {
        Library libraryFromDb = getById(library.getId());
        libraryFromDb.setName(library.getName());
        libraryFromDb.setAddress(library.getAddress());
        libraryRepository.save(libraryFromDb);
    }

    @Override
    public void delete(Integer id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public List<Library> getAll() {
        return libraryRepository.findAll();
    }
}
