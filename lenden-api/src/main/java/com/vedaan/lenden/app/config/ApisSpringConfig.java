/**
 * 
 */
package com.vedaan.lenden.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.vedaan.lenden.base.config.BaseSpringConfig;

/**
 * @author mayank
 *
 */
@Configuration
@ComponentScan("com.vedaan.lenden")
@Import(BaseSpringConfig.class)
public class ApisSpringConfig {

}
