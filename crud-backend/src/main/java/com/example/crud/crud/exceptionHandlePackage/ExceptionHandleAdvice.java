package com.example.crud.crud.exceptionHandlePackage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandleAdvice {

    @ResponseBody
   @ExceptionHandler(PersonExceptionHandle.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(PersonExceptionHandle exceptions){
        Map<String,String>errors=new HashMap<>();
        errors.put("error message",exceptions.getMessage());
        return errors;
    }
}
