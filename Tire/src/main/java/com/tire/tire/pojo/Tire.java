package com.tire.tire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tire {
    private Integer tireId;
    private Double price;
    private Timestamp addTime;
    private String imgUrl;
}
