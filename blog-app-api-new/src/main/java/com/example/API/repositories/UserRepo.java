package com.example.API.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.entities.*;
public interface UserRepo extends JpaRepository<User,Integer>{

}
