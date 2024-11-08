package com.sandr.web_library.web.controller;

import com.sandr.web_library.domain.entity.Book;
import com.sandr.web_library.domain.exception.BadDto;
import com.sandr.web_library.service.BookService;
import com.sandr.web_library.web.dto.book.BookDto;
import com.sandr.web_library.web.dto.validation.OnUpdate;
import com.sandr.web_library.web.mapper.book.BookDetailsMapper;
import com.sandr.web_library.web.mapper.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    private final BookDetailsMapper bookDetailsMapper;

    @PostMapping
    public BookDto createBook(@RequestBody @Validated BookDto book) {
        Book createdBook = bookService.create(bookMapper.toEntity(book));
        return bookMapper.toDto(createdBook);
    }

    //toDto при получении списка авторов по-идее открывает еще одну транзакцию?
    //Мы ведь вышли с service уровня, тогда нужно инициализировать поле с авторами внутри сервиса?
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Integer id) {
        return bookDetailsMapper.toDto(bookService.getBookWithGenreAndAuthorById(id));
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) BookDto bookDto) {
        if (!id.equals(bookDto.getId())) {
            throw new BadDto("Id in URL does not match field in dto");
        }
        bookService.update(bookMapper.toEntity(bookDto));
        return bookDto;
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookMapper.toDto(bookService.getAll());
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam Integer id) {
        bookService.delete(id);
    }

    @PostMapping("/{bookId}/genres")
    public void addGenre(@PathVariable Integer bookId,
                         @RequestParam Integer genreId) {
        bookService.addGenre(bookId, genreId);
    }

    @PostMapping("/{bookId}/authors")
    public void addAuthor(@PathVariable Integer bookId,
                          @RequestParam Integer authorId) {
        bookService.addAuthor(bookId, authorId);
    }
}
