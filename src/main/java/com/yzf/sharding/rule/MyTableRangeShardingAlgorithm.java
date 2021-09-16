/*
 * author: wangjian (jonath@163.com)
 * Copyright 2019
 */
package com.yzf.sharding.rule;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @Description tddo
 * @author yuanzf
 * @version 1.0
 * @date 2021/9/16 17:48
 * @className MyRangeShardingAlgorithm
 */
public class MyTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        long lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
        long upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();

        System.out.println("\r\n======MyTableRangeShardingAlgorithm.lowerEndpoint:"+lowerEndpoint +"  upperEndpoint:"+upperEndpoint);
        String logicTableName = rangeShardingValue.getLogicTableName();
        return Arrays.asList(logicTableName + "_1", logicTableName + "_2", logicTableName + "_0");
    }
}
