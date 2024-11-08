package com.sandr.web_library.web.mapper;

import com.sandr.web_library.domain.entity.BorrowedBook;
import com.sandr.web_library.web.dto.borrow.book.BorrowBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowBookMapper {

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "libraryBook.book.id", target = "bookId")
    @Mapping(source = "libraryBook.library.id", target = "libraryId")
    BorrowBookDto toDto(BorrowedBook borrowedBook);
}
