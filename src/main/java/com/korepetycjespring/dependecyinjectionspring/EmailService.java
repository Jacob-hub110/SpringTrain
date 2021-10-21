package com.korepetycjespring.dependecyinjectionspring;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String receiver, String message) {
        System.out.println("Wyslam mail do " + receiver + " o tresci: " + message);
    }

}
