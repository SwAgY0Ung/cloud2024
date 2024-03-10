package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.TPay;
import com.atguigu.cloud.mapper.TPayMapper;
import com.atguigu.cloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Echo
 * @date 2024/3/10
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private TPayMapper mapper;


    @Override
    public String getByKey(String key) {
        TPay tPay = mapper.selectByPrimaryKey(key);
        TPay entity = new TPay();
        entity.setId(1);
        List<TPay> select = mapper.selectByExample(entity);
        return null;
    }
}
