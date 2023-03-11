package com.tire.tire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tire.tire.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
