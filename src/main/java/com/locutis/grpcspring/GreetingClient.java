package com.locutis.grpcspring;

import helloworld.GreetingServiceGrpc;
import helloworld.RequestMessage;
import helloworld.ResponseMessage;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
//import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

//@Slf4j
public class GreetingClient {

    public static void main(String[] args) throws Exception {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
        RequestMessage request = RequestMessage.newBuilder().setName("Bill-java").build();
        ResponseMessage response;
        try {
            response = GreetingServiceGrpc.newBlockingStub(channel).sayHello(request);
            System.out.println(response.toString());
        } catch (StatusRuntimeException ex) {
            System.out.println(ex.toString());
            return;
        } finally {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
