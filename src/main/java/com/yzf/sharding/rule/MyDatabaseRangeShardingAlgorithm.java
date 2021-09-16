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
 * @author yuanzf
 * @version 1.0
 * @Description tddo
 * @date 2021/9/16 17:48
 * @className MyRangeShardingAlgorithm
 */
public class MyDatabaseRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    private static final String DATABASE_PREFIX = "DS_";

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        long lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
        long upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();

        System.out.println("\r\n======MyDatabaseRangeShardingAlgorithm.lowerEndpoint:" + lowerEndpoint + "  upperEndpoint:" + upperEndpoint);

        return Arrays.asList(DATABASE_PREFIX + "0", DATABASE_PREFIX + "1");
    }
}
