package com.korepetycjespring.dependecyinjectionspring;

import org.springframework.stereotype.Service;

@Service
public class SmsService implements MessageService {

    @Override
    public void sendMessage(String receiver, String message) {
        System.out.println("Wyslam sms do " + receiver + " o tresci: " + message);
    }

}
