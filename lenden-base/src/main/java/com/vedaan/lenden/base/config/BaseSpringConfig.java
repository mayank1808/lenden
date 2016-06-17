/**
 * 
 */
package com.vedaan.lenden.base.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.vedaan.lenden.dao.config.DaoSpringConfig;

/**
 * @author mayank
 *
 */
@Configuration
@ComponentScan("com.vedaan.lenden")
@Import(DaoSpringConfig.class)
public class BaseSpringConfig {

}
