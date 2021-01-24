package com.idsmanager.yhm_demo.domain.security;


import com.idsmanager.commons.domain.AbstractDomain;
import com.idsmanager.commons.utils.PasswordHandler;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统账号
 *
 * @author Shengzhao Li
 */

@Document(collection = "User_")
public class User extends AbstractDomain {


    private static final long serialVersionUID = -1958822224307828242L;


    //唯一
    private String username;
    //加密存储
    private String password;


    private Set<Privilege> privileges = new HashSet<>();


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User username(String username) {
        this.username = username;
        return this;
    }


    public User setPassword(String originalPass) {
        this.password = PasswordHandler.encryptPassword(originalPass, this.username);
        return this;
    }

    public String password() {
        return this.password;
    }

    public String username() {
        return this.username;
    }


    public Set<Privilege> privileges() {
        return privileges;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", uuid='" + uuid + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
