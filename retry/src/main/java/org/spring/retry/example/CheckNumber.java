package org.spring.retry.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

/**
 * The Class CheckNumber.
 */
@Component
public class CheckNumber {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CheckNumber.class);

	/**
	 * Check max number.
	 *
	 * @param number the number
	 */
	@Retryable(include = NumberFormatException.class, 
			maxAttempts = 2, 
			backoff = @Backoff(delay = 2000))
	public void checkMaxNumber(final Integer number) {
		if (number == null || number > 10) {
			throw new NumberFormatException("The number must be from zero to nine!");
		}
	}

	/**
	 * Recover.
	 *
	 * @param ex the ex
	 * @param number the number
	 * @throws Exception 
	 */
	@Recover
	public void recover(NumberFormatException ex, final Integer number) {
		logger.info("this is the problem {}", ex.getMessage());
		throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "this is the problem: "+ ex.getMessage());
	}
}
