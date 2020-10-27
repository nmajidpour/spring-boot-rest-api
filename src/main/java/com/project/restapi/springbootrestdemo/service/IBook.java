package com.project.restapi.springbootrestdemo.service;

import java.util.List;

import com.project.restapi.springbootrestdemo.model.Book;

public interface IBook {
    public abstract List<Book> getAllBooks();  
    public abstract List<Book> getBooksByGenre(String genre); 
    public abstract void createBook(Book book); 
    public abstract void updateBook(String id, Book book); 
}
