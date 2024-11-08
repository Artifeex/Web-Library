package com.sandr.web_library.web.controller;

import com.sandr.web_library.service.BorrowBookService;
import com.sandr.web_library.web.dto.borrow.book.BorrowBookDto;
import com.sandr.web_library.web.mapper.BorrowBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrow-book")
public class BorrowBookController {

    private final BorrowBookService borrowBookService;
    private final BorrowBookMapper borrowBookMapper;

    @PostMapping
    public BorrowBookDto borrowBook(@RequestParam Integer userId,
                                    @RequestParam Integer libraryId,
                                    @RequestParam Integer bookId,
                                    @RequestParam Integer count) {
        return borrowBookMapper.toDto(borrowBookService.borrowBook(userId, libraryId, bookId, count));
    }

    @PostMapping("/return-book")
    public void returnBook(@RequestParam Integer userId,
                           @RequestParam Integer libraryId,
                           @RequestParam Integer bookId,
                           @RequestParam Integer count) {
        borrowBookService.returnBook(userId, libraryId, bookId, count);
    }

    @GetMapping
    public List<BorrowBookDto> getBorrowedBooks() {
        borrowBookService
    }
}
