
package com.idsmanager.yhm_demo.service.dto.user;


import com.idsmanager.yhm_demo.domain.security.Privilege;
import com.idsmanager.yhm_demo.domain.security.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 2015/12/19
 *
 * @author Shengzhao Li
 */
public class UserFormDto extends UserDto {
    private static final long serialVersionUID = -8251954993624473451L;
    private String password;

    private String rePassword;


    private String existedUsername;


    public UserFormDto() {
    }

    public UserFormDto(User user) {
        super(user);
        this.existedUsername = user.username();
    }

    public List<Privilege> getAllPrivileges() {
        return Privilege.availablePrivileges();
    }

    public String getExistedUsername() {
        return existedUsername;
    }

    public void setExistedUsername(String existedUsername) {
        this.existedUsername = existedUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }


}
