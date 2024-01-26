package com.locutis.grpcspring;

import helloworld.GreetingServiceGrpc;
import helloworld.RequestMessage;
import helloworld.ResponseMessage;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void sayHello(RequestMessage req, StreamObserver<ResponseMessage> responseObserver) {
        ResponseMessage reply = ResponseMessage.newBuilder()
                .setMessage("Hello "+req.getName()+" from java server").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
