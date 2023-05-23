package com.uttara.awscodebuildpipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class AwsCodeBuildPipelineApplication {

    @Autowired
    private OrderDao orderDao;

    @GetMapping

    public List<Order> fetchOrders() {
        return orderDao.getOrders();
    }
    @GetMapping("/{orderName}")
    public  List<Order> findOrderByName(@PathVariable String orderName) {
        return orderDao.getOrders().stream().filter(order -> order.getName().equals(orderName)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        SpringApplication.run(AwsCodeBuildPipelineApplication.class, args);
    }

}
