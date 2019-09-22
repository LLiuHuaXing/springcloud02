package com.template.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.template.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @RequestMapping("/findAll2/{id}")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Student findAll2(@PathVariable("id") Long id){
        System.out.println("=============="+id);
        Student body = restTemplate.getForEntity("http://localhost:8010/student/findById/{id}", Student.class, id).getBody();
        System.out.println("==============  "+body);
        return body;
//        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Collection.class,id);
    }
}
