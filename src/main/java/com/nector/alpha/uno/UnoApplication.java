package com.nector.alpha.uno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nector.*")
public class UnoApplication {
	private static final Logger LOG = LogManager.getLogger(UnoApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(UnoApplication.class, args);

		SpringApplication application = new SpringApplication(UnoApplication.class);

		application.setBannerMode(Banner.Mode.OFF);
		application.setLogStartupInfo(true);

		// application.addInitializers(new UnoApplicationContextInitializer());
		application.run(args);

		LOG.info("----- Server started successfully --------");
	}

}
