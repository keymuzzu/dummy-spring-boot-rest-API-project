package com.rest.restapi.service;

import java.util.List;

import com.rest.restapi.Entities.bookClass;
import com.rest.restapi.dao.bookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class bookService {
    @Autowired
    private bookRepo bookRepository;
    // private static List<bookClass> list = new ArrayList<>();

    // static{
    // list.add(new bookClass(2,"book1","auth1"));
    // list.add(new bookClass(2,"book2","auth2"));
    // list.add(new bookClass(3,"book3","auth3"));
    // }



    public List<bookClass> getAllBooks(){
            List<bookClass> list =(List<bookClass>)this.bookRepository.findAll();
        return list;
    }

    public bookClass getBookById(int id){
        bookClass book = null;
        try{
            
        book = this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public bookClass addBook(bookClass b){
     bookClass result=  this.bookRepository.save(b);
        return result;
    }

    public void delBook(int bid){
        this.bookRepository.deleteById(bid);
      //  list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
  
  
      //    bookClass book = null;
    //    for(bookClass b: list){
    //        if(bid == b.getId()){
    //          book =   b;
    //         list.remove(b);
    //        }
    //    }
    //    return book;
    }

    public void update(bookClass book,int bid){
        book.setId(bid);
        this.bookRepository.save(book);
        // list = list.stream().map(b -> {
        //     if(b.getId() == bid){
        //         b.setName(book.getName());
        //         b.setAuthor(book.getName());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
    }
}
