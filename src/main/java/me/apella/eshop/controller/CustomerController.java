package me.apella.eshop.controller;

import me.apella.eshop.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;
}
