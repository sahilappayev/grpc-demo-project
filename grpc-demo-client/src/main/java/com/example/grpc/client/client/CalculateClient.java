package com.example.grpc.client.client;

import com.example.grpc.client.client.model.RequestDto;
import com.example.grpc.client.client.model.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "${feign.client.calculate.url}", name = "calculate-service")
public interface CalculateClient {


    @PostMapping
    public ResponseEntity<ResponseDto> calculate(@RequestBody RequestDto requestDto);



}
