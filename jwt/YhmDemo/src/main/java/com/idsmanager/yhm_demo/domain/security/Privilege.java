package com.idsmanager.yhm_demo.domain.security;

import java.util.Arrays;
import java.util.List;

public enum Privilege {


    ADMIN("管理员"),
    USER("用户");


    private String label;

    Privilege(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return name();
    }

    public static List<Privilege> availablePrivileges() {
        return Arrays.asList(
                ADMIN,
                USER
        );
    }

}
