package com.spring.documentation.api;

import io.swagger.annotations.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.web.bind.annotation.*;

@RestController
@BasePathAwareController
public class HomeApi {

    /**
     * Versioning with URI
     * Versioning with Custom Header
     *
     * We can create 2 different build with 2 different branches v1 and v2
     * Then deploy to cloud as appv1 and appv2
     * Using LoadBalancer we can route the load by filtering the path containing v1 to appv1 and v2 to appv2
     */

    @ApiOperation(value = "Get Home Endpoint", notes = "Application Version Details")
    @GetMapping(value = "/home")
    public String getHome() {
        return "Rest Api";
    }

    @ApiOperation(value = "Get Home Endpoint", notes = "Application Version Details")
    @GetMapping(value = "/home", headers = "Accept-version=v1")
    public String getHomeV1() {
        return "Rest Api V1";
    }

    @ApiOperation(value = "Get Home Endpoint", notes = "Application Version Details")
    @GetMapping(value = "/home", headers = "Accept-version=v2")
    public String getHomeV2() {
        return "Rest Api V2";
    }
}
