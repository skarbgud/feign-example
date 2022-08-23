package com.example.msafeign.feign;

import com.example.msafeign.domain.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "my-client", url="localhost:8080")
public interface MyFeignClient {

    @GetMapping(value = "/example/get-items", produces = "application/json")
    List<Item> getItems();

    @PostMapping(value = "/example/set-items", produces = "application/json")
    ResponseEntity<?> setItems(List<Item> items);
}
