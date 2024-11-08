package com.sandr.web_library.repository;


import com.sandr.web_library.domain.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {


}
