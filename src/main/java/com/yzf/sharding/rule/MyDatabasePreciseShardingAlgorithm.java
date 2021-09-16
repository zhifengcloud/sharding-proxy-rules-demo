/*
 * author: wangjian (jonath@163.com)
 * Copyright 2019
 */
package com.yzf.sharding.rule;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author yuanzf
 * @version 1.0
 * @Description tddo
 * @date 2021/9/16 17:48
 * @className MyPreciseShardingAlgorithm
 */
public class MyDatabasePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static final int DATABASE_MOD_NUM = 2;
    private static final String DATABASE_PREFIX = "DS_";

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName();
        Long cidValue = preciseShardingValue.getValue();
        BigInteger cidBigInteger = BigInteger.valueOf(cidValue);
        // (userId%3)
        BigInteger target = cidBigInteger.mod(BigInteger.valueOf(DATABASE_MOD_NUM));

        String result = DATABASE_PREFIX +  target;
        System.out.println("\r\n======MyDatabasePreciseShardingAlgorithm.key: " + result);
        return result;
    }
}
