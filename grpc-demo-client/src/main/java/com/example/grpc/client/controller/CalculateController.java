package com.example.grpc.client.controller;


import com.example.grpc.client.client.model.RequestDto;
import com.example.grpc.client.client.model.ResponseDto;
import com.example.grpc.client.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calculate")
public class CalculateController {

    private final CalculateService calculateService;

    @PostMapping
    public ResponseEntity<ResponseDto> calculate(@RequestBody RequestDto requestDto){
        return ResponseEntity.ok(calculateService.calculate(requestDto));
    }

}
