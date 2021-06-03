package org.owpk;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.owpk.grpc.Greeting;
import org.owpk.grpc.GreetingServiceGrpc;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080").usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc
                .newBlockingStub(channel);

        Greeting.HelloRequest request = Greeting.HelloRequest
                .newBuilder().setName("SomeName").build();

        Greeting.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();
    }
}
