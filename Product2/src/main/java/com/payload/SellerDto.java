package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {

    private int id;
    private String name;
    private String email;
    private Long phonenumber;
    private String address;
    private String password;
    private ProductDto product;
}
