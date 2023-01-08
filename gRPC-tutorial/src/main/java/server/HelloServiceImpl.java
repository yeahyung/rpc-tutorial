package server;

import io.grpc.stub.StreamObserver;
import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request from client, hello :\n" + request);

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        /*
         response 를 return 하지 않고, response observer 를 통해 하기 때문에
         client 쪽에서 blocking 또는 non-blocking call 가능
        */
        responseObserver.onNext(response);

        // onCompleted 를 하지 않으면, connection 은 종료되지 않고, client 는 계속 기다림
        responseObserver.onCompleted();
    }
}
