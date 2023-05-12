package com.example.grpcclient.controller;

import com.example.grpcclient.service.CalculatorService;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CalcController {
    final CalculatorService calculatorService;

    @GetMapping("/calc/sum")
    public Map<Descriptors.FieldDescriptor, Object> getSum(@RequestParam(name = "x") String x, @RequestParam(name = "y") String y) {
        return calculatorService.getSum(Float.parseFloat(x), Float.parseFloat(y));
    }
}
