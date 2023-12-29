package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.product.model.Book;
import com.example.product.service.BookService;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping(path = {"", "/getAllBooks"})
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}