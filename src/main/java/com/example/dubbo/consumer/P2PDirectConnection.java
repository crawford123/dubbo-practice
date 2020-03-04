package com.example.dubbo.consumer;

import com.example.dubbo.provider.service.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-20 10:02
 * @Version
 */

public class P2PDirectConnection {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("p2p-direct-connection");
        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
        // 如果点对点直连，可以用reference.setUrl()指定目标地址，设置url后将绕过注册中心
        //其中，协议对应provider.setProtocol()的值，端口对应provider.setPort()的值，
        //路径对应service.setPath()的值，如果未设置path，缺省path为接口名
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setInterface(DemoService.class);
        referenceConfig.setUrl("dubbo://127.0.0.1:20880/com.example.dubbo.provider.service.DemoService");
        DemoService demoService = referenceConfig.get();
        System.out.println("demoService: " + demoService);
        String result = demoService.sayHi("world");
        System.out.println("result: " + result);

    }
}
