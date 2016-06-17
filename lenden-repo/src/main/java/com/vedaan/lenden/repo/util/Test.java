/**
 * 
 */
package com.vedaan.lenden.repo.util;

/**
 * @author mayank
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vedaan.lenden.repo.repository.RoleRepository;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAUtils.class);
		RoleRepository repo = ctx.getBean(RoleRepository.class);
		System.out.println(repo.findAll());

	}

}
