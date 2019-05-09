package org.cth.model;

import javax.persistence.*;

@Entity
@Table(name = "t_crm_user")
public class CrmUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String userName;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
