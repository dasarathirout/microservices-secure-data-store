package org.dasarathi.sds.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.logging.Logger;

@SpringBootApplication
@EnableFeignClients
public class ServiceOne {
    private static final Logger LOG = Logger.getLogger(ServiceOne.class.getName());

    public static void main(String[] serviceOneArrays) {
        SpringApplication.run(ServiceOne.class, serviceOneArrays);
    }

}
