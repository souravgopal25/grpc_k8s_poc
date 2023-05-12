package com.example.additionservice.service;

import com.example.AdditionServiceGrpc;
import com.example.Operands;
import com.example.Result;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AdditionServiceImpl extends AdditionServiceGrpc.AdditionServiceImplBase {
    @Override
    public void getSum(Operands request, StreamObserver<Result> responseObserver) {
        float sum = request.getOperand1() + request.getOperand2();
        Result response = Result.newBuilder().setResult(sum).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
