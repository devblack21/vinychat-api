package com.devblack.vinychat.client.controller;


import com.devblack.vinychat.client.dto.MessageDTO;
import com.devblack.vinychat.client.mapper.MessageMapper;
import com.devblack.vinychat.core.processor.InitializerSenderMessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import static com.devblack.vinychat.core.constants.ApplicationContants.APPLICATION_JSON;
import static com.devblack.vinychat.core.routes.Routes.CONNECTION_ROUTE_MAPPING;
import static com.devblack.vinychat.core.routes.Routes.FIRST_CONNECTION;

@RestController
@CrossOrigin("*")
@RequestMapping(CONNECTION_ROUTE_MAPPING)
public class ConnectionController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private InitializerSenderMessageProcessor botProcessor;

    @PostMapping(value = FIRST_CONNECTION,
      consumes = APPLICATION_JSON,
      produces = APPLICATION_JSON)
    public void firstConnection(@RequestBody final MessageDTO requestBody) {
      botProcessor.sendAsync(MessageMapper.INSTANCE.mapFrom(requestBody));
    }

}
