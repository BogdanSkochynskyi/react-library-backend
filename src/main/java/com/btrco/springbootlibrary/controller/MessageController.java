package com.btrco.springbootlibrary.controller;

import com.btrco.springbootlibrary.entitiy.Message;
import com.btrco.springbootlibrary.requestModels.ReviewRequest;
import com.btrco.springbootlibrary.service.MessageService;
import com.btrco.springbootlibrary.service.ReviewService;
import com.btrco.springbootlibrary.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/secure/add/message")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody Message messageRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        messageService.postMessage(messageRequest, userEmail);
    }
}
