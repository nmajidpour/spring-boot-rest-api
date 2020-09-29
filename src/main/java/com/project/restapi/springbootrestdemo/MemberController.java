package com.project.restapi.springbootrestdemo;

import java.util.ArrayList;
import java.util.List;

import com.project.restapi.springbootrestdemo.model.Member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    List<Member> members = new ArrayList<Member>();

    @GetMapping(value = "/members")
    public List<Member> allMembers() 
    {
        members.add(new Member("ab1", "John Doe", "Glen Rd"));
        members.add(new Member("cd2", "Andrew Smith", "Sherwood Ave"));

        return members;
    }

    @GetMapping(value = "/members/{id}")
    public Member getMemberById(@PathVariable String id)
    {
        return members.stream().filter(m -> id.equals(m.getId())).findAny().orElse(null);
    }    
}