package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Echo
 * @date 2024/3/10
 */
@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper mapper;


    @Override
    public Pay getByKey(Integer key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Pay> getAll() {
        try {
            TimeUnit.SECONDS.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mapper.selectAll();
    }

    @Override
    public int add(Pay pay) {
        return mapper.insertSelective(pay);
    }

    @Override
    public int update(Pay pay) {
        return mapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
