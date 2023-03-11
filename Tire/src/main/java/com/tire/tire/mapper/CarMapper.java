package com.tire.tire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tire.tire.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
}
