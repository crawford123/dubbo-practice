package com.example.dubbo.consumer;

import com.example.dubbo.provider.service.DemoService;
import com.example.dubbo.provider.service.impl.DemoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;


/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-20 9:33
 * @Version
 */

public class ConsumerApiConfiguration {

    public static void main(String[] args) {

        DemoService demoService = new DemoServiceImpl();
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setTimeout(100000);
//        registryConfig.setUsername("aaa");
//        registryConfig.setPassword("bbb");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        //引用远程服务
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        DemoService demoService1 = reference.get();
        System.out.println("demoService1: " + demoService1);
        String result = demoService1.sayHi("world!");
        System.out.println("result: " + result);

    }
}
