package org.spring.retry.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RetryServiceImpl implements RetryService {

	@Autowired
	CheckNumber checkNumber;
	
	@Override	
	public String callRetry(Integer number) {
		checkNumber.checkMaxNumber(number);
		return "teste";
	}

}
