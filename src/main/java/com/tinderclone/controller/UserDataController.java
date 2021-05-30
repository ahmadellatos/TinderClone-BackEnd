package com.tinderclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinderclone.entity.UserData;
import com.tinderclone.repository.UserDataRepository;

@RestController
@RequestMapping("/")
public class UserDataController {

	@Autowired
	UserDataRepository userDataRepo;
	
	@GetMapping("/user")
	public List<UserData> lstUser() {
		return userDataRepo.findAll();
	}
	
	@GetMapping("/login/")
	public UserData loginUser(@RequestParam("username")String username, @RequestParam("nomorhandphone") String phone) {
		return userDataRepo.findByLogin(username, phone);
	}
	
	@PostMapping("/register/")
	public String addUser(@RequestBody UserData user) {
		
		userDataRepo.save(user);
		
		return "Registrasi Berhasil";
	}
}
