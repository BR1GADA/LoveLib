package org.peachSpring.app.repositories;

import org.peachSpring.app.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);
}
