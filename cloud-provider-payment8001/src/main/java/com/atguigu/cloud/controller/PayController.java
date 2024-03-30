package com.atguigu.cloud.controller;

import com.atguigu.cloud.entites.PayDTO;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Echo
 * @date 2024/3/10
 */
@RestController
@RequestMapping("/pay")
@RefreshScope
public class PayController {

    @Resource
    private PayService service;

    /**
     * 主键查询
     * @param key 主键
     * @return 实体类
     */
    @GetMapping("/get/{key}")
    public ResultData getByKey(@PathVariable("key") Integer key) {
        return ResultData.success(service.getByKey(key));
    }

    /**
     * 查询全部
     * @return list<实体类>
     */
    @GetMapping("/getAll")
    public ResultData getAll() {
        return ResultData.success(service.getAll());
    }

    /**
     * 新增
     * @param dto 传输对象
     * @return 受影响的行数
     */
    @PostMapping("/add")
    public ResultData add(@RequestBody PayDTO dto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(dto, pay);
        int count = service.add(pay);
        return ResultData.success("成功插入记录，返回值：" + count);
    }

    /**
     * 修改
     * @param dto 传输对象
     * @return 受影响的行数
     */
    @PutMapping("/update")
    public ResultData update(@RequestBody PayDTO dto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(dto, pay);
        int count = service.update(pay);
        return ResultData.success("成功修改记录，返回值：" + count);
    }

    /**
     * 逻辑删除
     * @param id 主键
     * @return 受影响的行数
     */
    @DeleteMapping("/del/{id}")
    public ResultData del(@PathVariable("id") Integer id) {
        int count = service.delete(id);
        return ResultData.success("成功删除记录，返回值：" + count);
    }

    @Value("${yhy.info}")
    private String yhyInfo1;

    @GetMapping("/getConsulConfigInfo")
    public ResultData getConculConfigInfo(@Value("${yhy.info}") String yhyInfo2) {
        return ResultData.success("成员变量:" + yhyInfo1 + "方法入参:" + yhyInfo2);
    }
}
