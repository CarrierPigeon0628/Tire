package com.tire.tire.service.impl;

import com.tire.tire.mapper.TireMapper;
import com.tire.tire.pojo.Tire;
import com.tire.tire.pojo.User;
import com.tire.tire.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TireServiceImpl implements TireService {

    @Autowired
    TireMapper tireMapper;

    @Override
    public Map<String, Object> getTireTest() {
        List<Tire> tireList = tireMapper.selectList(null);
        Map<String, Object> response = new HashMap<>();
        if (tireList == null) {
            response.put("code", 0);
        }
        else {
            response.put("code", 1);
            response.put("tire_list", tireList);
        }
        return response;
    }
}
