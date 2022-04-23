package com.springbootcourse.repositories;

import com.springbootcourse.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}