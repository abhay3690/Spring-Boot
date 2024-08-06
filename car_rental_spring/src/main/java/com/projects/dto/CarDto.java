package com.projects.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Data
public class CarDto {

    private Long id;

    private String brand;

    private String color;

    private String name ;

    private String type;

    private String transmission;

    private String description;

    private Long price;
    
    private Date year;

    private MultipartFile image;

    private byte[] returnedImage;

}
