package com.sandr.web_library.web.mapper.book;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.web.dto.book.BookDto;
import com.sandr.web_library.web.mapper.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends Mappable<Book, BookDto> {
}
