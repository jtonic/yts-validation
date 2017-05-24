package ro.jtonic.isr.yts.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

@SpringBootApplication
public class YtsValidationExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtsValidationExamplesApplication.class, args);
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
		postProcessor.setValidator(localValidatorFactoryBean());
		return postProcessor;
	}

	@Bean
	public Validator localValidatorFactoryBean() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.getValidationPropertyMap().put("hibernate.validator.fail_fast", "true");
		return localValidatorFactoryBean;
	}
}
