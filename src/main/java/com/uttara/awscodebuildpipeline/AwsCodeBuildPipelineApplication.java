package com.uttara.awscodebuildpipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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

    public static void main(String[] args) {
        SpringApplication.run(AwsCodeBuildPipelineApplication.class, args);
    }

}
