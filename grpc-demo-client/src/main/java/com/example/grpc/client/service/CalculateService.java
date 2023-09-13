package com.example.grpc.client.service;


import calculate.CalculateServiceV2Grpc;
import calculate.RequestMessage;
import calculate.ResponseMessage;
import com.example.grpc.client.client.CalculateClient;
import com.example.grpc.client.client.model.RequestDto;
import com.example.grpc.client.client.model.ResponseDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class CalculateService {

    private final CalculateClient calculateClient;


    //    public ResponseDto calculate(RequestDto requestDto){
//        return calculateClient.calculate(requestDto).getBody();
//    }


    @SneakyThrows
    public ResponseDto calculate(RequestDto requestDto) {

        log.info("calculate started");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        RequestMessage requestMessage = RequestMessage.newBuilder()
                .setX(requestDto.getX())
                .setY(requestDto.getY()).build();
        ResponseMessage responseMessage = ResponseMessage.newBuilder().build();
        ResponseDto responseDto = new ResponseDto();
        try {
            log.info("channel: {}", channel);
            responseMessage = CalculateServiceV2Grpc.newBlockingStub(channel).calculate(requestMessage);
            responseDto.setResult(responseMessage.getResult());
            log.info("responseMessage: {}", responseMessage);
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
        } finally {
            channel.shutdownNow().awaitTermination(3, TimeUnit.SECONDS);
        }

        log.info("calculate completed");
        return responseDto;
    }


}
