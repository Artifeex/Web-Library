package com.sandr.web_library.repository;

import com.sandr.web_library.domain.entity.LibraryBook;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Integer> {

    @Query(value = """
            SELECT EXISTS(
                SELECT 1
                FROM library_book lb
                WHERE lb.book_id = :bookId AND lb.library_id = :libraryId
            )
            """, nativeQuery = true)
    boolean existsByLibraryIdAndBookId(Integer libraryId, Integer bookId);

    @Query(value = """
            SELECT lb 
            FROM LibraryBook lb
            WHERE lb.book.id = :bookId AND lb.library.id = :libraryId
            """)
    Optional<LibraryBook> findByLibraryIdAndBookId(Integer libraryId, Integer bookId);

    @EntityGraph(attributePaths = "book")
    @Query(value = """
            SELECT lb 
            FROM LibraryBook lb 
            WHERE lb.library.id = :libraryId
            """)
    List<LibraryBook> findAllBooksByLibraryId(Integer libraryId);

    @Modifying
    @Query(value = """
            DELETE FROM library_book
            WHERE library_id=:libraryId and book_id=:bookId
            """, nativeQuery = true)
    void deleteLibraryBookById(Integer libraryId, Integer bookId);
}
