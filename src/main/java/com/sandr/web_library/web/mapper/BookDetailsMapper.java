package com.sandr.web_library.web.mapper;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.web.dto.book.BookDetailsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDetailsMapper extends Mappable<Book, BookDetailsDto> {
}
