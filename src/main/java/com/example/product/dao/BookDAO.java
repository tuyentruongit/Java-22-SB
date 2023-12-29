package com.example.product.dao;

import org.springframework.stereotype.Repository;
import com.example.product.database.BookDB;
import com.example.product.model.Book;

import java.util.List;

@Repository
public class BookDAO {
    public List<Book> findAll() { // select * from books
        return BookDB.bookList;
    }

    public Book findById(String id) { // select * from books where id = ?
        for (Book book : BookDB.bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
