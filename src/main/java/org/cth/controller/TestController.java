package org.cth.controller;

import com.alibaba.fastjson.JSON;
import org.cth.model.CrmUser;
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
        CrmUser res = testservice.saveUser();
        log.info(JSON.toJSONString(res));
    }

    @GetMapping("testGet1")
    public Map<String, String> testGet1() {
        Map<String, String> map = new HashMap<>();
        testservice.testMethod();
        CrmUser cu = testservice.findByAge();
        map.put("code", "1");
        map.put("name", cu.getUserName());
        return map;
    }

    @GetMapping("testGet2")
    public String testGet2() {
        testservice.testMethod();
        testservice.testTransaction();
        return "1";
    }

    @GetMapping("testGet3/{key}")
    public String testGet3(@PathVariable("key") String key) {
        testservice.testMethod();
        testservice.testNoTransaction();
        return key;
    }

    @GetMapping("testGet4")
    public String testGet4(String key) {
        testservice.testMethod();
        try {
            testservice.testTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    @GetMapping("testGet5")
    public String testGet5(HttpServletRequest req) {
        testservice.testMethod();
        String res = testservice.testTransaction("234");
        return req.getParameter("key") + res;
    }

    @PostMapping("testPost")
    public void testPost() {

    }
}
