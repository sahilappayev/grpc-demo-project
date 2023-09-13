package com.example.grpc.demo.grpc;

import calculate.CalculateServiceV2Grpc;
import calculate.RequestMessage;
import calculate.ResponseMessage;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class CalculateServiceV2 extends CalculateServiceV2Grpc.CalculateServiceV2ImplBase {

    @Override
    public void calculate(RequestMessage req, StreamObserver<ResponseMessage> responseObserver) {
        ResponseMessage reply = ResponseMessage.newBuilder().setResult(req.getX() + req.getY()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
