package org.dasarathi.sds.core.grpc.client;

import com.proto.grpc.service.UpdateUserData;
import com.proto.grpc.service.UserUpdateRequest;
import com.proto.grpc.service.UserUpdateResponse;
import com.proto.grpc.service.UserUpdateServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;

import org.dasarathi.sds.core.util.CORE;

public class UpdateUserClient {

    private static final Logger LOG = Logger.getLogger(UpdateUserClient.class.getName());
    private static UserUpdateServiceGrpc.UserUpdateServiceBlockingStub coreClientStub;
    private static ManagedChannel managedChannel;

    static {

        managedChannel = ManagedChannelBuilder
                .forAddress(CORE.GRPC_HOSTNAME, CORE.GRPC_PORT)
                .usePlaintext()
                .build();
        coreClientStub = UserUpdateServiceGrpc.newBlockingStub(managedChannel);
        LOG.info("Starting GRPC Client " + CORE.GRPC_HOSTNAME + " @ " + CORE.GRPC_PORT);

    }

    public static int executeSaveUpdateClient(int userID, String fileType, String encryptedContents) {
        LOG.info("Save OR Update User => execute GRPC Client ");
        LOG.info(fileType + " | " + userID + " | " + encryptedContents);

        UpdateUserData updateUserData = UpdateUserData.newBuilder()
                .setUserId(userID)
                .setFileType(fileType)
                .setUserContents(encryptedContents)
                .build();

        UserUpdateRequest updateRequest = UserUpdateRequest
                .newBuilder().
                setUserData(updateUserData)
                .build();

        UserUpdateResponse updateResponse = coreClientStub.updateDB(updateRequest);
        LOG.info(updateResponse.getResultContents());
        // LOG.info("ShutDown Managed Channel");
        // managedChannel.shutdown();
        return CORE.GRPC_CLIENT_UPDATE;
    }
}
