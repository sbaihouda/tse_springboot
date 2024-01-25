package tdRestAPI.td;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTdApplication {

	public static void main(String[] args) {
		SpringApplication.from(TdApplication::main).with(TestTdApplication.class).run(args);
	}

}
