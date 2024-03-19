package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @author Echo
 * @date 2024/3/10
 */
public interface PayService {

    Pay getByKey(Integer key);

    List<Pay> getAll();

    int add(Pay pay);

    int update(Pay pay);

    int delete(Integer id);
}
