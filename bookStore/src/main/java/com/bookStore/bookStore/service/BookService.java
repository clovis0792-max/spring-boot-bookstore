package com.bookStore.bookStore.service;

import com.bookStore.bookStore.model.Book;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public void saveBook(Book b){
        repo.save(b);
    }
    public List<Book> getAllBook(){
        return repo.findAll();
    }

    public Book getBookById(int id){
        return repo.findById(id).get();
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
