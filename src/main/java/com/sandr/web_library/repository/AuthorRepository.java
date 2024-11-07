package com.sandr.web_library.repository;

import com.sandr.web_library.domain.entity.Author;
import com.sandr.web_library.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
