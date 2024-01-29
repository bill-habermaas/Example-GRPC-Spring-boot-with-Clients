package com.locutis.grpcspring.controllers;

import com.google.protobuf.Descriptors;
import com.locutis.grpcspring.service.GrpcGreetingService;
import helloworld.RequestMessage;
import helloworld.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/greeting",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RestGreetingController {

    private final GrpcGreetingService grpcGreetingService;

    @Autowired
    public RestGreetingController(GrpcGreetingService grpcGreetingService) {
        this.grpcGreetingService = grpcGreetingService;
    }

    /**
     * Post Hello Rest API
     * @param request RequestMessage indicating who to say hello to.
     * @return HelloReply with the hello message.
     */
    @PostMapping(value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> sayHello(@RequestBody RequestMessage request) {

        return new ResponseEntity<>(
                ResponseMessage.newBuilder()
                        .setMessage(grpcGreetingService.sayHello(request))
                        .build(),
                HttpStatus.OK);
    }
}
