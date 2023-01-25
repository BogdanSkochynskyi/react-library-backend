package com.btrco.springbootlibrary.service;

import com.btrco.springbootlibrary.dao.MessageRepository;
import com.btrco.springbootlibrary.dao.ReviewRepository;
import com.btrco.springbootlibrary.entitiy.Message;
import com.btrco.springbootlibrary.entitiy.Review;
import com.btrco.springbootlibrary.requestModels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;


@Service
@Transactional
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Message messageRequest, String userEmail) {
        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
        message.setUserEmail(userEmail);
        this.messageRepository.save(message);
    }

}
