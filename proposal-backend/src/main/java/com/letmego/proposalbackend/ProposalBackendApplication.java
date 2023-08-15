package com.letmego.proposalbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableOpenApi // 변경된 어노테이션
@EnableSwagger2 // Enable Swagger
@EnableJpaAuditing
public class ProposalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProposalBackendApplication.class, args);
	}

}



