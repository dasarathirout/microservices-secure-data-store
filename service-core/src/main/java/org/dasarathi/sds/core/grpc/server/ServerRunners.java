package org.dasarathi.sds.core.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.dasarathi.sds.core.util.CORE;

import java.io.IOException;
import java.util.logging.Logger;

public class ServerRunners {
    private static final Logger LOG = Logger.getLogger(ServerRunners.class.getName());

    public static void startRunning() {
        LOG.info("Starting User GRPC Server - localhost@50505");
        Server server = null;

        // START GRPC
        try {
            server = ServerBuilder.forPort(CORE.GRPC_PORT)
                    .addService(new UpdateUserServiceProvider())
                    .build();
            server.start();

        } catch (Exception ex) {
            LOG.severe("Failed Starting User GRPC Server - localhost@50505 : " + ex.getMessage());
        }

        // STOP
        try {
            Server finalServer = server;
            if (finalServer != null) {
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    finalServer.shutdown();
                }));
                finalServer.awaitTermination();
            }
        } catch (Exception ex) {
            LOG.severe("GRPC Await Termination Failed : " + ex.getMessage());
        }
    }
}
