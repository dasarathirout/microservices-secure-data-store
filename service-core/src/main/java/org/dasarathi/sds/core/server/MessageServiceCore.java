package org.dasarathi.sds.core.server;

import com.proto.core.greet.GreetRequest;
import com.proto.core.greet.GreetResponse;
import com.proto.core.greet.GreetServiceGrpc;
import com.proto.core.greet.Greeting;
import io.grpc.stub.StreamObserver;

public class MessageServiceCore extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest greetRequest, StreamObserver<GreetResponse> greetResponseObserver) {

        // Extract The Field Values
        Greeting greeting = greetRequest.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();

        // Create The Response
        String greetResult = "Hi," + firstName + " " + lastName + " WelCome To GRPC Service !";

        // Send The Response
        GreetResponse greetResponse = GreetResponse
                .newBuilder()
                .setResult(greetResult)
                .build();
        greetResponseObserver.onNext(greetResponse);

        // Complete The Response
        greetResponseObserver.onCompleted();
    }
}
