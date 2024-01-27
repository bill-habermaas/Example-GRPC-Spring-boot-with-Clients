package com.locutis.grpcspring.service.impl;

import com.locutis.grpcspring.service.GrpcGreetingService;
import helloworld.RequestMessage;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GrpcGreetingServiceImpl implements GrpcGreetingService {

    @Override
    public String sayHello(RequestMessage request) {
        return String.format("Hello from GrpcGreetingService %s!", request.getName().trim());
    }
}