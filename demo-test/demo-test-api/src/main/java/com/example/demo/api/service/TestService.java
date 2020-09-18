package com.example.demo.api.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Copyright © 2020 广州智数信息技术有限公司. All rights reserved.
 *
 * @ClassName
 * @Description
 * @Auther FengZhi
 * @Email 2045532295@qq.com
 * @Create 2020-08-20 16:00
 * @Version
 */

@Path("/api")
@Consumes({MediaType.APPLICATION_JSON+";charset=UTF-8",MediaType.APPLICATION_FORM_URLENCODED+";charset=UTF-8",MediaType.TEXT_PLAIN})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8})
public interface TestService {

    /**
     * 测试接口
     */
    @POST
    @Path("/test")
    Map<String, Object> test(Map<String, Object> dataMap);


}
