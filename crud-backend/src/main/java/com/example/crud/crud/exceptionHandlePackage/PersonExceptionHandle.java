package com.example.crud.crud.exceptionHandlePackage;
public class PersonExceptionHandle extends RuntimeException{
public PersonExceptionHandle(long id){
    super("user can not find with id "+id);
}
}
