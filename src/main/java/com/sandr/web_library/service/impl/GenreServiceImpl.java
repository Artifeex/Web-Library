package com.sandr.web_library.service.impl;

import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.repository.GenreRepository;
import com.sandr.web_library.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public void update(Genre genre) {
        Genre genreFromDB = getById(genre.getId());
        genreFromDB.setName(genre.getName());
        genreRepository.save(genreFromDB);
    }

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getById(Integer id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre with id " + id + " not found"));
    }

    @Override
    public void delete(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getAllById(List<Integer> ids) {
        return genreRepository.findAllById(ids);
    }
}
