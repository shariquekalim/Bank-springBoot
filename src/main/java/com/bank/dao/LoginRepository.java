package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{

}
