package sg.nus.iss.visa.ssf.workshop1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop1Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop1Application.class);
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info(" main method started...");

		SpringApplication app = new SpringApplication(Workshop1Application.class);

		// Reads args array and check for "port" parameter

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		// returns list of key-value pairs
		List opsValues = appArgs.getOptionValues("port");

		String portNumber = null;

		// if port number is not in argument
		if (opsValues == null || opsValues.get(0) == null) {

			// read port number from env variables
			portNumber = System.getenv("PORT");

			if (portNumber == null) {
				portNumber = DEFAULT_PORT;
			}
		} else {
			portNumber = (String) opsValues.get(0);
		}

		if (portNumber != null) {
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		}

		// SpringApplication.run(Workshop1Application.class, args);

		// launch spring boot app
		System.out.println("Server runnning on port:" + portNumber);
		app.run(args);
	}

}
