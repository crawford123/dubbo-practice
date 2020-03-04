package com.example.dubbo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.example.dubbo.provider.service.DemoService;
import com.example.dubbo.provider.service.impl.DemoServiceImpl;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-20 9:19
 * @Version
 */

public class ProviderApiConfiguration {


    public static void main(String[] args) {

        //服务实现
        DemoService demoService = new DemoServiceImpl();

        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");

        //连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setTimeout(100000);
//        registryConfig.setUsername("aaa");
//        registryConfig.setPassword("bbb");

        //服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);

        //注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端
        //服务提供者暴露服务配置
        ServiceConfig<DemoService> serviceServiceConfig = new ServiceConfig<>();
        serviceServiceConfig.setApplication(applicationConfig);
        serviceServiceConfig.setRegistry(registryConfig);
        serviceServiceConfig.setProtocol(protocolConfig);
        serviceServiceConfig.setInterface(DemoService.class);
        serviceServiceConfig.setRef(demoService);
        serviceServiceConfig.setVersion("1.0.0");

        //暴露及注册服务
        serviceServiceConfig.export();
    }

}
