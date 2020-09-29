package com.project.restapi.springbootrestdemo.model;

import lombok.Value;

@Value
public class Member {
    private String id;
    private String name;
    private String address;    
}