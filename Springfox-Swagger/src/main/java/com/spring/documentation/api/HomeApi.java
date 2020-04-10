package com.spring.documentation.api;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeApi {

    @ApiOperation(value = "Get Home Endpoint", notes = "Tells application status")
    @GetMapping
    public String getHomeV1() {
        return "{status: App is up & running!}";
    }
}
