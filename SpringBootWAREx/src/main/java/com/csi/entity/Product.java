package com.csi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @Size(min = 2, message = "Product Name should be atleast 2 character")
    private String productName;

    private double productPrice;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date productLaunchDate;


}
