package org.cth.model;

import javax.persistence.*;

@Entity
@Table(name = "t_crm_user")
@org.hibernate.annotations.Table(appliesTo="t_crm_user", comment = "这个表的注释")
public class CrmUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

//    @Column(columnDefinition = "varchar2(255) comment '注释说明'")  //这个对mysql有用
    @Column(columnDefinition = "varchar2(255)")
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
