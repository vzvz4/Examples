package org.owpk;
import org.owpk.grpc.Greeting;

import io.grpc.stub.StreamObserver;
import org.owpk.grpc.GreetingServiceGrpc;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

   public void greeting(final Greeting.HelloRequest request,
         StreamObserver<Greeting.HelloResponse> responseObserver) {
      System.out.println(request);
      Greeting.HelloResponse response = Greeting.HelloResponse.newBuilder()
         .setGreeting("Hello from server, " + request.getName())
         .build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
   } 
}

