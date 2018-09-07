package org.spring.retry;

import org.spring.retry.example.RetryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * The Class AppConfig.
 */
@Configuration
@EnableRetry
public class AppConfig {
	
    /**
     * Retry service impl.
     *
     * @return the retry service impl
     */
    @Bean
    public RetryServiceImpl retryServiceImpl() {
        return new RetryServiceImpl();
    }

}
