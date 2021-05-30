package com.tinderclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tinderclone.entity.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Long>{
	@Query(value="SELECT * from userdata where username=?1 and nomorhandphone=?2",nativeQuery = true)
	UserData findByLogin(String username, String phone);
	
	
}
