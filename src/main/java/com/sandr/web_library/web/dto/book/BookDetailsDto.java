package com.sandr.web_library.web.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandr.web_library.web.dto.author.AuthorDto;
import com.sandr.web_library.web.dto.genre.GenreDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsDto extends BookDto {

    private List<AuthorDto> authors;

    private List<GenreDto> genres;
}
