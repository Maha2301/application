package com.spring.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mysql.model.LogModel;

public interface LogRepo extends JpaRepository<LogModel, String>{

	List<LogModel> findAllByDate(String date);

}
