package com.example.dubbo.consumer;

import com.example.dubbo.provider.service.DemoService;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.ReferenceConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName MethodConfiguration
 * @Description 方法级设置
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-20 9:56
 * @Version
 */

public class MethodConfiguration {

    public static void main(String[] args) {
        // 方法级配置
        List<MethodConfig> methods = new ArrayList<>();
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("createXxx");
        methodConfig.setTimeout(10000);
        methodConfig.setRetries(0);
        methods.add(methodConfig);

        //引用远程服务
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
        //设置方法级配置
        referenceConfig.setMethods(methods);

    }
}
