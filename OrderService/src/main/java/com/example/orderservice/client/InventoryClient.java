package com.example.orderservice.client;

import com.example.orderservice.dto.ProductResponse;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class InventoryClient {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public InventoryClient(DiscoveryClient discoveryClient,
                           RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    public ProductResponse checkStock(String code) {

        List<org.springframework.cloud.client.ServiceInstance> instances =
                discoveryClient.getInstances("PRODUCT-SERVICE");

        if (instances.isEmpty()) {
            throw new RuntimeException(
                    "PRODUCT-SERVICE không khả dụng"
            );
        }

        org.springframework.cloud.client.ServiceInstance instance =
                instances.get(0);

        String url = instance.getUri()
                + "/api/v1/products/" + code;

        return restTemplate.getForObject(
                url,
                ProductResponse.class
        );
    }
}