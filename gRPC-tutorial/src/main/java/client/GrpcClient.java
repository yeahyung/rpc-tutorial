package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.baeldung.grpc.HelloServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        // Blocking Stub
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        org.baeldung.grpc.HelloResponse response =
                stub.hello(org.baeldung.grpc.HelloRequest.newBuilder()
                        .setFirstName("yea")
                        .setLastName("gRPC")
                        .build());

        System.out.println(response);

        channel.shutdown();
    }
}
