package com.rest.restapi.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullname;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private bookClass book;
    public bookClass getBook() {
        return book;
    }
    public void setBook(bookClass book) {
        this.book = book;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Author() {
    }
    public Author(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

}
