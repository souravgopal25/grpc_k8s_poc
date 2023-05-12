package com.example.grpcclient.service;


import com.example.AdditionServiceGrpc;
import com.example.Operands;
import com.example.Result;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculatorService {
    @GrpcClient("add-service")
    AdditionServiceGrpc.AdditionServiceBlockingStub syncClient;

    public Map<Descriptors.FieldDescriptor, Object> getSum(float x, float y) {
        Operands request = Operands.newBuilder().setOperand1(x).setOperand2(y).build();
        Result response = syncClient.getSum(request);
        return response.getAllFields();
    }

}
