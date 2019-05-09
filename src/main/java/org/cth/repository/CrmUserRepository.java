package org.cth.repository;

import org.cth.model.CrmUser;
import org.springframework.data.repository.CrudRepository;

public interface CrmUserRepository extends CrudRepository<CrmUser, Long> {
    CrmUser findByAge(int age);
}
