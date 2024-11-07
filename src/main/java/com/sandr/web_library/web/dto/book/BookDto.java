package com.sandr.web_library.web.dto.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandr.web_library.web.dto.author.AuthorDto;
import com.sandr.web_library.web.dto.genre.GenreDto;
import com.sandr.web_library.web.dto.validation.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

import static com.sandr.web_library.web.dto.validation.ValidationConstants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @NotNull(groups = OnUpdate.class, message = "Id must be not null")
    private Integer id;
    @NotNull
    @NotEmpty
    @Length(max = MAX_BOOK_NAME_LENGTH,
            message = "Title length must be smaller than " + MAX_BOOK_NAME_LENGTH + " characters")
    private String title;

    @Min(value = MIN_BOOK_YEAR, message = "Year must be greater then zero")
    @Max(value = MAX_BOOK_YEAR, message = "Year must be smaller then " + MAX_BOOK_YEAR)
    private Integer year;

    @Length(max = MAX_LENGTH_GENRE_NAME,
            message = "Title length must be smaller than " + MAX_LENGTH_GENRE_NAME + " characters")
    private String description;

}
