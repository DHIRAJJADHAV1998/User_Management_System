package com.example.crud.crud.repository;

import com.example.crud.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfo extends JpaRepository<User,Long> {
}
