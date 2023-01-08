package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8081)
                .addService(new HelloServiceImpl())
                .build();

        System.out.println("Starting the server...");

        server.start();
        server.awaitTermination();
    }
}
