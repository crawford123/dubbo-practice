package com.example.dubbo.consumer;

import com.example.dubbo.provider.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-14 16:26
 * @Version
 */

public class Consumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHi("world");
        System.out.println("result: " + hello);
    }

}
