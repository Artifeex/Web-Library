package com.sandr.web_library.web.controller;

import com.sandr.web_library.domain.entity.Library;
import com.sandr.web_library.domain.exception.BadDto;
import com.sandr.web_library.service.LibraryService;
import com.sandr.web_library.web.dto.library.LibraryDto;
import com.sandr.web_library.web.dto.validation.OnUpdate;
import com.sandr.web_library.web.mapper.LibraryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;
    private final LibraryMapper libraryMapper;

    @PostMapping
    public LibraryDto createLibrary(@Validated() @RequestBody LibraryDto dto) {
        Library library = libraryMapper.toEntity(dto);
        return libraryMapper.toDto(libraryService.create(library));
    }

    @GetMapping("/{id}")
    public LibraryDto getLibraryById(@PathVariable Integer id) {
        Library library = libraryService.getById(id);
        return libraryMapper.toDto(library);
    }

    @PutMapping("/{id}")
    public LibraryDto updateLibrary(@PathVariable Integer id, @Validated(OnUpdate.class) @RequestBody LibraryDto dto) {
        if(!id.equals(dto.getId())) {
            throw new BadDto("Id in URL does not match field in dto");
        }
        Library library = libraryMapper.toEntity(dto);
        libraryService.update(library);
        return libraryMapper.toDto(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibraryById(@PathVariable Integer id) {
        libraryService.delete(id);
    }

    @GetMapping
    public List<LibraryDto> getLibraries() {
        return libraryService.getAll()
                .stream()
                .map(libraryMapper::toDto)
                .toList();
    }


}
