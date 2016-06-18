/**
 * 
 */
package com.vedaan.lenden.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedaan.lenden.repo.entities.UserEO;

/**
 * @author mayank
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEO, Integer> {

}
