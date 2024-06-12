package com.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    
    private int pid;
    
    private String ptitle;

    private String price;

    private String pimage;

    private String pdescription;
}
