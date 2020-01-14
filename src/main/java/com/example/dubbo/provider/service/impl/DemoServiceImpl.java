package com.example.dubbo.provider.service.impl;

import com.example.dubbo.provider.service.DemoService;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName DemoServiceImpl
 * @Description DemoServiceImpl
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-01-14 15:26
 * @Version
 */

public class DemoServiceImpl implements DemoService {


    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
