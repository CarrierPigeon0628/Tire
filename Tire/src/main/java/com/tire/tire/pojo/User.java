package com.tire.tire.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    private String userPassword;
    private String userName;
    private String userStatus;
}
