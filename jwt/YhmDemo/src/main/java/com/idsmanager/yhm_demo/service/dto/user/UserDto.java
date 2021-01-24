package com.idsmanager.yhm_demo.service.dto.user;

import com.idsmanager.yhm_demo.domain.security.Privilege;
import com.idsmanager.yhm_demo.domain.security.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2016/9/26
 *
 * @author Shengzhao Li
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7435372467897829631L;


    private String uuid;
    private String createTime;

    protected String username;
    protected Set<Privilege> privileges;


    public UserDto() {
    }

    public UserDto(User user) {
        this.uuid = user.uuid();
        this.createTime = user.createTimeAsText();

        this.username = user.username();
        this.privileges = user.privileges();
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public static List<UserDto> toDtos(List<User> list) {
        List<UserDto> dtos = new ArrayList<>(list.size());
        dtos.addAll(list.stream().map(UserDto::new).collect(Collectors.toList()));
        return dtos;
    }
}
