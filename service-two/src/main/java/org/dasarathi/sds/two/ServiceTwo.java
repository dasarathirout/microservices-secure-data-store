package org.dasarathi.sds.two;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.logging.Logger;

@SpringBootApplication
@EnableFeignClients
public class ServiceTwo implements CommandLineRunner {
    private static final Logger LOG = Logger.getLogger(ServiceTwo.class.getName());

    public static void main(String[] serviceTwoArrays) {
        SpringApplication.run(ServiceTwo.class, serviceTwoArrays);
    }

    @Override
    public void run(String... runnerCLI) throws Exception {
        LOG.info("SERVICE TWO CLI");
    }

}
