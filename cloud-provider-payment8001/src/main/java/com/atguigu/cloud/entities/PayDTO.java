package com.atguigu.cloud.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Echo
 * @date 2024/3/17
 */
@Data
public class PayDTO implements Serializable {
    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 用户账号ID
     */
    private String orderNo;

    /**
     * 交易金额
     */
    private BigDecimal amount;
}
