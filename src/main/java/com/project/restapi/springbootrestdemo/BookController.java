package com.project.restapi.springbootrestdemo;

import java.util.List;

import com.project.restapi.springbootrestdemo.model.Book;
import com.project.restapi.springbootrestdemo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    List<Book> bookList;

    @GetMapping(value = "/books")
    public List<Book> allBooks() 
    {
        bookList = bookService.getAllBooks();
        return bookList;
    }

    @GetMapping(value = "/books/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) 
    {
        return bookService.getBooksByGenre(genre);
    }

    @PostMapping(value = "/books")
    public void createBook(@RequestBody Book book) 
    {      
        bookService.createBook(book);
    }

    @PutMapping(value = "/books/{id}")
    public void updateBook(@PathVariable("id") String id, @RequestBody Book book) 
    {      
        bookService.updateBook(id, book);
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteBook(@PathVariable("id") String id) 
    {      
        bookService.deleteBook(id);
    }
}