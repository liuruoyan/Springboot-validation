package com.cc.validation.web.rest;


import com.cc.validation.entity.Person;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Controller
@RequestMapping("/api")
@Validated
public class DemoResource {


    @PostMapping("/demo1")
    public ResponseEntity demo1(@RequestBody @Valid Person person) {
        System.out.println(person);

        return ResponseEntity.ok().build();
    }

//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        /**默认是普通模式，会返回所有的验证不通过信息集合*/
//        return new MethodValidationPostProcessor();
//    }

    // 基础类型验证
    // 一定要在类上加注解
    @PostMapping("/demo2")
    public ResponseEntity demo2(@NotEmpty(message = "uname must not be empty!") String uname,
                                @Range(min = 1, max = 99, message = "age must in [1,99]") Integer age) throws Exception {
        System.out.println("uname = " + uname);
        return ResponseEntity.ok().build();
    }







}
