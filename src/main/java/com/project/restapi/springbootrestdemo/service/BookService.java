
package com.project.restapi.springbootrestdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.project.restapi.springbootrestdemo.model.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService implements IBook {

    @Override
    public List<Book> getAllBooks() {
        return bookRepo;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepo.stream().filter(b -> genre.equalsIgnoreCase(b.getGenre())).collect(Collectors.toList());
    }

    @Override
    public void createBook(Book book) {  
        bookRepo.add(book);
    }
    
	@Override
	public void updateBook(String id, Book newBook) {
        Book oldBook = bookRepo.stream().filter(b -> id.equalsIgnoreCase(b.getId())).findAny().get();
        int index = bookRepo.indexOf(oldBook);
        bookRepo.set(index, newBook);
    }
    
    @Override
    public void deleteBook(String id) {
        Book book = bookRepo.stream().filter(b -> id.equalsIgnoreCase(b.getId())).findAny().get();
        bookRepo.remove(book);
    }

    private static List<Book> bookRepo = new ArrayList<Book>();
    static {
        bookRepo.add(new Book("1", "Alchemist", "Paulo Coelho", "Novel"));
        bookRepo.add(new Book("2", "Hamlet", "William Shakespeare", "Novel"));
        bookRepo.add(new Book("3", "Emotional Intelligence", "Daniel Goleman", "Self-help"));
        bookRepo.add(new Book("4", "The Old Man and the Sea", "Ernest Hemingway", "Novel"));
    }
}