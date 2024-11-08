package com.sandr.web_library.web.mapper.book;

import com.sandr.web_library.domain.entity.LibraryBook;
import com.sandr.web_library.web.dto.book.BookCountDto;
import com.sandr.web_library.web.mapper.Mappable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookCountMapper {

    @Mapping(source = "book.title", target = "title")
    @Mapping(source = "book.description", target = "description")
    @Mapping(source = "book.year", target = "year")
    BookCountDto toDto(LibraryBook libraryBook);

    List<BookCountDto> toDto(List<LibraryBook> libraryBook);
}
