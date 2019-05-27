package com.cc.validation.web.rest;


import com.cc.validation.entity.EntrustQueue;
import com.cc.validation.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotEmpty;

@Controller
@RequestMapping("/api")
@Validated
public class DemoResource {


    // 基础类型验证
    // 一定要在类上加注解
    @PostMapping("/demo1")
    public ResponseEntity demo1(@NotEmpty(message = "uname must not be empty!") String uname) throws Exception {
        System.out.println("uname = " + uname);

        return ResponseEntity.ok().build();
    }



    @PostMapping("/demo2")
    public ResponseEntity demo2(Person person){
        System.out.println(person);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/demo3")
    public ResponseEntity addEntrust2(@RequestBody @Validated EntrustQueue entrustQueue) {
        System.out.println(entrustQueue);
        return  ResponseEntity.ok().build();
    }

}
