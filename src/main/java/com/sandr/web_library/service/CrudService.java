package com.sandr.web_library.service;

import com.sandr.web_library.domain.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudService<T, ID> {

    JpaRepository<T, ID> getRepository();

    default T create(T library) {
        return getRepository().save(library);
    }

    default T getById(ID id) {
        return getRepository()
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Entity with id " + id + " not found")
                );
    }

    void update(T library);

    default void delete(ID id) {
        getRepository().deleteById(id);
    }

    default List<T> getAll() {
        return getRepository().findAll();
    }

}
