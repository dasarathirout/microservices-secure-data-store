package org.dasarathi.sds.core.grpc.server;

import com.proto.grpc.service.UpdateUserData;
import com.proto.grpc.service.UserUpdateRequest;
import com.proto.grpc.service.UserUpdateResponse;
import com.proto.grpc.service.UserUpdateServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.dasarathi.sds.core.util.UserParser;

import java.util.logging.Logger;

public class ServerUpdateUser extends UserUpdateServiceGrpc.UserUpdateServiceImplBase {
    private static final Logger LOG = Logger.getLogger(ServerUpdateUser.class.getName());
    @Override
    public void updateDB(UserUpdateRequest request, StreamObserver<UserUpdateResponse> responseObserver) {
        LOG.info("grpc.server.updateDB()");
        UpdateUserData userData = request.getUserData();
        int userID = userData.getUserId();
        String fileType = userData.getFileType();
        String rawUserData = userData.getUserContents();
        UserParser.parse(userID,fileType,rawUserData);

    }
}
