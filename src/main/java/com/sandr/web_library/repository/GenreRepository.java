package com.sandr.web_library.repository;

import com.sandr.web_library.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {


}
