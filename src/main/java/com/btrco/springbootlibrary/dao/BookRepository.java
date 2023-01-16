package com.btrco.springbootlibrary.dao;

import com.btrco.springbootlibrary.entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
