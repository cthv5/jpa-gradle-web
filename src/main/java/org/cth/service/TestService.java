package org.cth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private Logger log = LoggerFactory.getLogger(TestService.class);

    public void testMethod() {
        log.info(">>>hello...");
    }
}
