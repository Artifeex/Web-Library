package com.sandr.web_library.web.mapper;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.domain.entity.Genre;
import com.sandr.web_library.web.dto.book.BookDto;
import com.sandr.web_library.web.dto.genre.GenreDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends Mappable<Book, BookDto> {
}
