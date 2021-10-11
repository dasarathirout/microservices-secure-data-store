package org.dasarathi.sds.two;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ServiceTwo {
    private static final Logger LOG = Logger.getLogger(ServiceTwo.class.getName());

    public static void main(String[] serviceTwoArrays) {
        SpringApplication.run(ServiceTwo.class, serviceTwoArrays);
    }

}
