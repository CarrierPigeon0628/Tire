package com.tire.tire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Evaluation {
    private Integer evaId;
    private String content;
    private Integer state;
}
