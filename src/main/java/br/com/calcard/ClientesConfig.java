package br.com.calcard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deliveredtechnologies.rulebook.RuleBook;
import com.deliveredtechnologies.rulebook.runner.RuleBookRunner;

@Configuration
public class ClientesConfig {
	@SuppressWarnings("rawtypes")
	@Bean
	public RuleBook ruleBook() {
		return new RuleBookRunner("com.deliveredtechnologies.rulebook.spring");
	}
}
