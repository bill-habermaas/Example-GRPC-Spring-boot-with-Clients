package com.locutis.grpcspring.controllers;

import com.locutis.grpcspring.service.GrpcGreetingService;
import helloworld.GreetingServiceGrpc;
import helloworld.RequestMessage;
import helloworld.ResponseMessage;
import io.grpc.stub.StreamObserver;
//import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

//@Slf4j
@GRpcService
public class GrpcGreetingController extends GreetingServiceGrpc.GreetingServiceImplBase {

    private final GrpcGreetingService grpcGreetingService;

    @Autowired
    public GrpcGreetingController(GrpcGreetingService grpcGreetingService) {
        this.grpcGreetingService = grpcGreetingService;
    }

    @Override
    public void sayHello(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {

        ResponseMessage reply = ResponseMessage.newBuilder()
                .setMessage(this.grpcGreetingService.sayHello(request))
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }



}
