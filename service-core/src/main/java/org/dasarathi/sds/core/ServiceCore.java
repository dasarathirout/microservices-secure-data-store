package org.dasarathi.sds.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ServiceCore {
	private static final Logger LOG = Logger.getLogger(ServiceCore.class.getName());

	public static void main(String[] serviceCoreArrays) {
		SpringApplication.run(ServiceCore.class, serviceCoreArrays);
	}

}
