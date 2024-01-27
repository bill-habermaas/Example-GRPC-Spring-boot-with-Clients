package com.locutis.grpcspring.service;

import helloworld.RequestMessage;

public interface GrpcGreetingService {
    /**
     * Process the sayHello request
     * @param requestMessage request the process
     * @return Message generated for this request.
     */
    public String sayHello(RequestMessage requestMessage);
}