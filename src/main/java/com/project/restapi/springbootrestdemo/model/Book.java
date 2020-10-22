package com.project.restapi.springbootrestdemo.model;

import lombok.Value;

@Value
public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
}