/*
 * author: wangjian (jonath@163.com)
 * Copyright 2019
 */
package com.yzf.sharding.spiextention;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yuanzf
 * @version 1.0
 * @Description 自定义生成器
 * @date 2021/9/16 17:55
 * @className MyKeyGenerateAlgorithm
 */
public class MyKeyGenerateAlgorithm implements ShardingKeyGenerator {

    private  AtomicLong atomicLong = new AtomicLong(10);

    private Properties properties = new Properties();

    @Override
    public Comparable<?> generateKey() {

//        String mykeyOffset = properties.getProperty("mykey-offset","100");
        LocalDateTime ldt = LocalDateTime.now();
        String timeStamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(ldt);

        return Long.parseLong(timeStamp + "" + atomicLong.incrementAndGet());
    }

    // 扩展算法的类型
    @Override
    public String getType() {
        return "MYKEY";
    }

    @Override
    public Properties getProperties() {
        return this.properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

//    public static void main(String[] args) {
//        LocalDateTime ldt = LocalDateTime.now();
//        String timeStamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(ldt);
//
//       long value=  Long.parseLong(timeStamp + "" + atomicLong.incrementAndGet());
//        System.out.println(value);
//    }

    //insert INTO order_info(order_name,product_id,buy_num) values('iPhone 13', 77889,1);

    //select * from order_info;

}
