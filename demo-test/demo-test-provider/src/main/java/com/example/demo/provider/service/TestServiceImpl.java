package com.example.demo.provider.service;

import com.example.demo.api.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-08-20 16:30
 * @Version
 */


@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public Map<String, Object> test(Map<String, Object> dataMap) {
        return null;
    }
}
