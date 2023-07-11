package com.techgaints.plugins.uam;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
/*@EnableConfigurationProperties({
		FileUploadConfig.class
})*/
@SpringBootApplication(/*exclude = {SecurityAutoConfiguration.class},*/ proxyBeanMethods = false)
public class UamApplication {


	public static void main(String[] args) {
		SpringApplication.run(UamApplication.class, args);
	}

	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
		return new OpenAPI()
						.info(new Info().title("UAM Applciation")
						.version(appVersion)
						.description(appDesciption));
	}

}
