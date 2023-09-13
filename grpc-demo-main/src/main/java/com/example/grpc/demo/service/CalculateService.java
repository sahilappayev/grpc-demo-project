package com.example.grpc.demo.service;

import com.example.grpc.demo.model.RequestDto;
import com.example.grpc.demo.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {


    public ResponseDto calculate(RequestDto requestDto) {
        Integer sum = requestDto.getX() + requestDto.getY();

        return new ResponseDto(sum);
    }


}
