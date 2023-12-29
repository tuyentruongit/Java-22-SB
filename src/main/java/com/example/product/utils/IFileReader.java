package com.example.product.utils;

import com.example.product.model.Book;

import java.util.List;

public interface IFileReader {
    List<Book> readFile(String filePart);
}
