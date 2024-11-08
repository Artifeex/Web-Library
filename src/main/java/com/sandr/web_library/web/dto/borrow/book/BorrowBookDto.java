package com.sandr.web_library.web.dto.borrow.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBookDto {

    private Integer id;
    private Integer bookId;
    private Integer libraryId;

    private String username;

    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    private Integer count;
}
