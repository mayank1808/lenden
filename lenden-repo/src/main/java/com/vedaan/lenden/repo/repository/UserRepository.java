/**
 * 
 */
package com.vedaan.lenden.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEO, Integer> {

	@Query(value = "SELECT userEO from UserEO userEO WHERE userEO.emailId=?1 AND userEO.password=?2")
	public UserEO checkUser(String emailId, String password);

}
