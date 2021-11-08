package com.korepetycjespring.dependecyinjectionspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SmsService implements MessageService {

    @Override
    public void sendMessage(String receiver, String message) {
        System.out.println("Wyslam sms do " + receiver + " o tresci: " + message);
    }

}
