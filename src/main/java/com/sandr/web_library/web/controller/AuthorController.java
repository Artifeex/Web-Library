package com.sandr.web_library.web.controller;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.domain.exception.BadDto;
import com.sandr.web_library.service.AuthorService;
import com.sandr.web_library.service.GenreService;
import com.sandr.web_library.web.dto.author.AuthorDto;
import com.sandr.web_library.web.dto.genre.GenreDto;
import com.sandr.web_library.web.dto.validation.OnUpdate;
import com.sandr.web_library.web.mapper.AuthorMapper;
import com.sandr.web_library.web.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    public AuthorDto createAuthor(@RequestBody @Validated AuthorDto authorDto) {
        Author createdAuthor = authorService.create(authorMapper.toEntity(authorDto));
        return authorMapper.toDto(createdAuthor);
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Integer id) {
        return authorMapper.toDto(authorService.getById(id));
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable Integer id,
                                 @RequestBody @Validated(OnUpdate.class) AuthorDto authorD) {
        if(!id.equals(authorD.getId())) {
            throw new BadDto("Id in URL does not match field in dto");
        }
        authorService.update(authorMapper.toEntity(authorD));
        return authorD;
    }

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return authorMapper.toDto(authorService.getAll());
    }

    @DeleteMapping
    public void deleteAuthorById(@RequestParam Integer id) {
        authorService.delete(id);
    }
}
