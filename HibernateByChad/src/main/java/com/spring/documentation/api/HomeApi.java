package com.spring.documentation.api;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.web.bind.annotation.*;

@RestController
@BasePathAwareController
public class HomeApi {

    /**
     *  Environment: read using env
     */
    private final Environment env;

    public HomeApi(Environment env) {
        this.env = env;
    }

    @ApiOperation(value = "Get Home Endpoint", notes = "Application Status Details")
    @GetMapping(value = "/home/env")
    public String getHome() {
        return env.getProperty("APPLICATION_STATUS");
    }

    /**
     * @Value: read with @Value annotation with Default value as well
     */

    @Value("${APPLICATION_STATUS:App is up}")
    private String appStatus;

    @ApiOperation(value = "Get Home Endpoint", notes = "Application Status Details")
    @GetMapping(value = "/home/value")
    public String getHomeV1() {
        return appStatus;
    }
}
