package org.dasarathi.sds.core;

import org.dasarathi.sds.core.grpc.server.ServerRunners;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ServiceCore implements CommandLineRunner {
    private static final Logger LOG = Logger.getLogger(ServiceCore.class.getName());

    public static void main(String[] serviceCoreArrays) {
        LOG.info("SPRING BOOT APPLICATION");
        SpringApplication.run(ServiceCore.class, serviceCoreArrays);
    }

    @Override
    public void run(String... runnerCLI) throws Exception {
        // Run To Generate SHA Public & Private Key File.
        // KeyPairRSA.generatePublicPrivateKeys();
        // Copy To KeyPairs/*.key Files To All Sub-Projects.
        ServerRunners.startRunning();
    }
}
