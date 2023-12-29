package com.example.product.database;

import com.example.product.model.Book;
import com.example.product.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Qualifier("CSVFileReader")
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {

        BookDB.bookList = fileReader.readFile("book.csv");
        System.out.println("Số lượng sách trong database: " + BookDB.bookList.size());

        for(Book book : BookDB.bookList) {
            System.out.println(book);
        }
    }
}
