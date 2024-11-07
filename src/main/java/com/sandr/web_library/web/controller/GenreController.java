package com.sandr.web_library.web.controller;

import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.domain.exception.BadDto;
import com.sandr.web_library.service.GenreService;
import com.sandr.web_library.web.dto.genre.GenreDto;
import com.sandr.web_library.web.dto.validation.OnUpdate;
import com.sandr.web_library.web.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @PostMapping
    public GenreDto createGenre(@RequestBody @Validated GenreDto genre) {
        Genre createdGenre = genreService.create(genreMapper.toEntity(genre));
        return genreMapper.toDto(createdGenre);
    }

    @GetMapping("/{id}")
    public GenreDto getGenreById(@PathVariable Integer id) {
        return genreMapper.toDto(genreService.getById(id));
    }

    @PutMapping("/{id}")
    public GenreDto updateGenre(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) GenreDto genreDto) {
        if(!id.equals(genreDto.getId())) {
            throw new BadDto("Id in URL does not match field in dto");
        }
        genreService.update(genreMapper.toEntity(genreDto));
        return genreDto;
    }

    @GetMapping
    public List<GenreDto> getGenres() {
        return genreMapper.toDto(genreService.getAll());
    }

    @DeleteMapping
    public void deleteGenreById(@RequestParam Integer id) {
        genreService.delete(id);
    }

}
