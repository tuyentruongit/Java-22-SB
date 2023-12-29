package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product.dao.BookDAO;
import com.example.product.model.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Book getBookById(String id) {
        return bookDAO.findById(id);
    }
}
