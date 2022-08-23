package com.example.msafeign.controller;

import com.example.msafeign.domain.Item;
import com.example.msafeign.domain.ResponseDto;
import com.example.msafeign.feign.MyFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyRestController {

    private final MyFeignClient myFeignClient;

    @GetMapping("/example/get-items")
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("0001", "장난감", 1000));
        items.add(new Item("0002", "우유", 2300));
        items.add(new Item("0003", "책", 21000));
        return items;
    }

    @PostMapping("/example/set-items")
    public ResponseDto<Item> setItems(@RequestBody List<Item> items) {
        log.info("setItems");
        List<Item> containMilk = items.stream()
                .filter(item -> item.getItemName().contains("우유"))
                .collect(Collectors.toList());

        ResponseDto<Item> response = ResponseDto.<Item>builder().data(containMilk).build();

        if (containMilk.isEmpty()) {
            response.setError("No Contain Milk");
        }

        return response;
    }

    @GetMapping("/example/call-feign-get-item")
    public List<Item> callFeignGetItem() {
        List<Item> items = myFeignClient.getItems();
        return items;
    }

    @PostMapping("/example/call-feign-set-item")
    public ResponseEntity<?> callFeignSetItem(@RequestBody List<Item> items) {
        ResponseEntity<?> response = myFeignClient.setItems(items);
        return response;
    }
}
