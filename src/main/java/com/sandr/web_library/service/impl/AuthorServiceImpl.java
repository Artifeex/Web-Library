package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.repository.AuthorRepository;
import com.sandr.web_library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void update(Author author) {
        Author genreFromDB = getById(author.getId());
        genreFromDB.setName(author.getName());
        authorRepository.save(genreFromDB);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author with id " + id + " not found"));
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
