package com.bookStore.bookStore.service;

import com.bookStore.bookStore.model.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListsService {
    @Autowired
    private MyBookRepo mybookrepo;

    public void saveMyBooks(MyBookList mybook){
mybookrepo.save(mybook);

    }
    public List<MyBookList> getAllMyBooks(){
        return mybookrepo.findAll();
    }
    public void deleteById(int id){
        mybookrepo.deleteById(id);
    }

}
