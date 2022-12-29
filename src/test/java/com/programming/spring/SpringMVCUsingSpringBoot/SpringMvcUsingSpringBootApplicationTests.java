package com.programming.spring.SpringMVCUsingSpringBoot;

import com.programming.spring.SpringMVCUsingSpringBoot.service.OutputService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMvcUsingSpringBootApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private OutputService outputService;

	@Test
	public void invokeAspects() throws InterruptedException{
		for (int i =1; i<=5;i++){
			outputService.generateOutput();
			Thread.sleep(1000);
		}
	}

}
