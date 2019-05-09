package org.cth.service;

import org.cth.model.CrmUser;
import org.cth.repository.CrmUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TestService {
    private Logger log = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private CrmUserRepository crmUserRepo;

    public void testMethod() {
        log.info(">>>hello...");
    }

    public CrmUser saveUser() {
        log.info(">>>saveUser...");
        CrmUser cu = new CrmUser();
        cu.setAge(11);
        cu.setUserName("cth");
        return crmUserRepo.save(cu);
    }

    public CrmUser findByAge() {
        return crmUserRepo.findByAge(11);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    //@Transactional javax.transaction(jpa包)的也可以用
    public void testTransaction() {
        CrmUser user = new CrmUser();
        user.setUserName("mjj");
        CrmUser res = crmUserRepo.save(user);
        if (res.getId() > 0) {
            throw new RuntimeException("testTransaction 抛异常了");
        }
    }

    public void testNoTransaction() {
        CrmUser user = new CrmUser();
        user.setUserName("mjj1");
        CrmUser res = crmUserRepo.save(user);
        if (res.getId() > 0) {
            throw new RuntimeException("testNoTransaction 抛异常了");
        }
    }

    public String testTransaction(String key) {
        testTransaction(); //类内部调用失效
        return key;
    }
}
