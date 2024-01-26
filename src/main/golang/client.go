package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	pb "helloworld/helloworld/helloworld"
	"log"
)

func main() {
	opts := grpc.WithInsecure()
	cc, err := grpc.Dial("localhost:6565", opts)
	if err != nil {
		log.Fatal(err)
	}
	defer cc.Close()

	client := pb.NewGreetingServiceClient(cc)
	request := &pb.RequestMessage{Name: "Bill from Go"}
	resp, err := client.SayHello(context.Background(), request)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Printf("Receive response => %s\n", resp.Message)
}
