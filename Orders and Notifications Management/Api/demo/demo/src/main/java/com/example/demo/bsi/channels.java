package com.example.demo.bsi;



import com.example.demo.Modules.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
@Service
public interface channels {
    String sendSimple(Queue<Order> queue);
    String sendComp( Queue<List<Order>> queue);
}
