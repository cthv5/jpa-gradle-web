package org.cth.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {
    @GetMapping("testGet")
    public void testGet() {
        log.info(">>>testGet start...");
        testservice.testMethod();
    }

    @GetMapping("testGet1")
    public Map<String, String> testGet1() {
        Map<String, String> map = new HashMap<>();
        testservice.testMethod();
        map.put("code", "1");
        return map;
    }

    @GetMapping("testGet2")
    public String testGet2() {
        testservice.testMethod();
        return "1";
    }

    @GetMapping("testGet3/{key}")
    public String testGet3(@PathVariable("key") String key) {
        testservice.testMethod();
        return key;
    }

    @GetMapping("testGet4")
    public String testGet4(String key) {
        testservice.testMethod();
        return key;
    }

    @GetMapping("testGet5")
    public String testGet5(HttpServletRequest req) {
        testservice.testMethod();
        return req.getParameter("key");
    }

    @PostMapping("testPost")
    public void testPost() {

    }
}
