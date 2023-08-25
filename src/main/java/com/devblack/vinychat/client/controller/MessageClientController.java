package com.devblack.vinychat.client.controller;

import com.devblack.vinychat.repository.adapter.MessageRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.devblack.vinychat.core.routes.Routes.MESSAGE_ROUTE_MAPPING;

@RestController
@CrossOrigin("*")
@RequestMapping(MESSAGE_ROUTE_MAPPING)
public class MessageClientController {


}
