package com.example.product.utils;

import com.example.product.model.Book;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CSVFileReader implements IFileReader {

    public List<Book> readFile(String filePath) {
        try{
            List<Book> b =  new ArrayList<>();
           try (Reader reader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                for (CSVRecord csvRecord : csvParser) {
                    Book book  =  new Book();
                    book.setId(csvRecord.get(0));
                    book.setTitle(csvRecord.get(1));
                    book.setAuthor(csvRecord.get(2));
                    int y = Integer.parseInt(csvRecord.get(3));
                    book.setYear(y);
                    b.add(book);
                }
                return b;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }


}
