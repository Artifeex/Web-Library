package com.sandr.web_library.web.mapper;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.web.dto.author.AuthorDto;
import com.sandr.web_library.web.dto.genre.GenreDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends Mappable<Author, AuthorDto> {
}
