package com.example.msafeign.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    public String itemId;
    public String itemName;
    public Integer price;

}
