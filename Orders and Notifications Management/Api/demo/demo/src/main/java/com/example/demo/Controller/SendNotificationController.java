package com.example.demo.Controller;

import com.example.demo.Modules.Order;
import com.example.demo.bsi.EmailNotification;
import com.example.demo.bsi.SMSNotification;
import com.example.demo.bsi.channels;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Queue;
@RestController
public class SendNotificationController {
    private channels channel ;
    public SendNotificationController(){

    }


    public String SendSimpleMail(Queue<Order> queue){
        channel = new EmailNotification();
        String email = channel.sendSimple(queue);
        return email;
    }
    public String SendSimpleSMS(Queue<Order>queue){
        channel = new SMSNotification();
        String sms = channel.sendSimple(queue);
        return sms;
    }

    public String sendCompoundMail(Queue<List<Order>> queue) {
        channel = new EmailNotification();
        String email = channel.sendComp(queue);
        return email  ;
    }
    public String sendCompoundSMS(Queue<List<Order>> queue) {
        channel = new SMSNotification();
        String sms = channel.sendComp(queue);
        return sms ;
    }
}
