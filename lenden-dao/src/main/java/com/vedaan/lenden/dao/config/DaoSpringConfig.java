/**
 * 
 */
package com.vedaan.lenden.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.vedaan.lenden.repo.util.JPAUtils;

/**
 * @author mayank
 *
 */
@Configuration
@ComponentScan("com.vedaan.lenden")
@Import(JPAUtils.class)
public class DaoSpringConfig {

}
