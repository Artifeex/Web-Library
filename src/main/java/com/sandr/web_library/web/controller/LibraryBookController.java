package com.sandr.web_library.web.controller;

import com.sandr.web_library.service.LibraryBookService;
import com.sandr.web_library.web.dto.book.BookCountDto;
import com.sandr.web_library.web.mapper.book.BookCountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
@RequiredArgsConstructor
public class LibraryBookController {

    private final LibraryBookService libraryBookService;
    private final BookCountMapper bookCountMapper;

    @PostMapping("/{id}/books")
    public void addNewBookToLibrary(@PathVariable Integer id,
                                    @RequestParam Integer bookId,
                                    @RequestParam Integer count) {
        libraryBookService.addNewBook(id, bookId, count);
    }

    @PutMapping("/{id}/books")
    public void updateCountBookToLibrary(@PathVariable Integer id,
                                         @RequestParam Integer bookId,
                                         @RequestParam Integer count) {
        libraryBookService.updateCountBook(id, bookId, count);
    }

    @GetMapping("/{id}/books")
    public List<BookCountDto> getAllBooksInLibrary(@PathVariable Integer id) {
        return bookCountMapper.toDto(libraryBookService.getAllBooks(id));
    }

    @DeleteMapping("/{id}/books")
    public void deleteBookFromLibrary(@PathVariable Integer id, @RequestParam Integer bookId) {
        libraryBookService.deleteBookFromLibrary(id, bookId);
    }
}
