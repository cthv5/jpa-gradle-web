package org.cth.controller;

import org.cth.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    protected Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected TestService testservice;
}
