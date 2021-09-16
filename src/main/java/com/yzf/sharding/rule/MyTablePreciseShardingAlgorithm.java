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
public class MyTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static final int TABLE_MOD_NUM = 3;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName();
        Long cidValue = preciseShardingValue.getValue();
        BigInteger cidBigInteger = BigInteger.valueOf(cidValue);
        // (userId%3)
        BigInteger target = cidBigInteger.mod(BigInteger.valueOf(TABLE_MOD_NUM));
        System.out.println("\r\n======MyTablePreciseShardingAlgorithm.key: " + target);
        String result = tableName + "_" + target;
        if (collection.contains(result)) {
            return result;
        }

        throw new UnsupportedOperationException("route " + target + " is not supported,please check your config.");
    }
}
