package com.example.orderservice.service;

import com.example.orderservice.client.InventoryClient;
import com.example.orderservice.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private InventoryClient inventoryClient;

    public ProductResponse checkProductStock(String code) {
        try {
            return inventoryClient.checkStock(code);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Hệ thống đang quá tải, yêu cầu của bạn đã được ghi nhận nhưng chưa thể hoàn tất kiểm tra kho. Vui lòng quay lại sau 1 phút."
            );
        }
    }
}