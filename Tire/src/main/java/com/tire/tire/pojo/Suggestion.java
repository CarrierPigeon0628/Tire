package com.tire.tire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Suggestion {
    private Integer sugId;
    private String content;
}
