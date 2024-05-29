package com.rikkeiacademy.cal_api_product.controller;

import com.rikkeiacademy.cal_api_product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    private String api_url = "http://localhost:8080/api/v1/product";

    @GetMapping
    public String home(Model model){
        Object[] result = restTemplate.getForObject(api_url,Object[].class);
        List<Product> list = Arrays.stream(result).map(data -> modelMapper.map(data, Product.class)).toList();
        model.addAttribute("list",list);
        return "home";
    }
}
