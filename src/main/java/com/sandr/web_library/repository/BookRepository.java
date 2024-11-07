package com.sandr.web_library.repository;

import com.sandr.web_library.domain.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b JOIN fetch b.genres WHERE b.id = :id")
    Book findBookWithGenresAndAuthorsById(@Param("id") Integer id);
}
