package com.spring.mysql.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.dao.LogRepo;
import com.spring.mysql.model.LogModel;

@RestController
public class LogController {

	@Autowired
	LogRepo repo;
	
	@GetMapping(path = "/checkIn")
	public LogModel addLogIn(@RequestParam("name") String name) {
		LogModel log = new LogModel();
		log.setName(name);
		log.setLogType("IN");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		log.setDate(dateFormat.format(new Date()).toString());
		log.setTime(java.time.LocalTime.now().toString());
		log.setId(name+log.getTime());
		repo.save(log);
		return log;
	}
	
	@GetMapping(path = "/checkOut")
	public LogModel addLogOut(@RequestParam("name") String name) {
		LogModel log = new LogModel();
		log.setName(name);
		log.setLogType("OUT");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		log.setDate(dateFormat.format(new Date()).toString());
		log.setTime(java.time.LocalTime.now().toString());
		log.setId(name+log.getTime());
		repo.save(log);
		return log;
	}
	
	@GetMapping(path = "/getLog")
	public List<LogModel> getLogByDate(@RequestParam("date") String date) {
			return repo.findAllByDate(date);
	}
	
	@GetMapping(path = "/getAllLog")
	public List<LogModel> getAllLogs() {
			return repo.findAll();
	}
}
