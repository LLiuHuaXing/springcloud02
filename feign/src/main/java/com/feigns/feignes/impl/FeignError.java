package com.feigns.feignes.impl;

import com.feigns.entity.Student;
import com.feigns.feignes.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器正在维修中........";
    }
}
