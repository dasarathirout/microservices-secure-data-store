package org.dasarathi.sds.core.grpc.server;

import com.proto.grpc.service.UpdateUserData;
import com.proto.grpc.service.UserUpdateRequest;
import com.proto.grpc.service.UserUpdateResponse;
import com.proto.grpc.service.UserUpdateServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.dasarathi.sds.core.data.MemoryDB;
import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.core.util.UserFileWriter;
import org.dasarathi.sds.core.util.UserParser;

import java.util.logging.Logger;

public class UpdateUserServiceProvider extends UserUpdateServiceGrpc.UserUpdateServiceImplBase {
    private static final Logger LOG = Logger.getLogger(UpdateUserServiceProvider.class.getName());

    @Override
    public void updateDB(UserUpdateRequest request, StreamObserver<UserUpdateResponse> responseObserver) {
        LOG.info("grpc.server.updateDB()");
        UpdateUserData userData = request.getUserData();
        int userID = userData.getUserId();
        String fileType = userData.getFileType();
        String rawUserData = userData.getUserContents();
        User parsedUser = UserParser.parse(userID, fileType, rawUserData);
        MemoryDB.addContents(parsedUser);
        UserFileWriter.writeSaveUpdate(userID, fileType, rawUserData);
        UserUpdateResponse userUpdateResponse = UserUpdateResponse
                .newBuilder()
                .setResultContents(parsedUser.toString())
                .build();
        responseObserver.onNext(userUpdateResponse);
        responseObserver.onCompleted();
    }
}
