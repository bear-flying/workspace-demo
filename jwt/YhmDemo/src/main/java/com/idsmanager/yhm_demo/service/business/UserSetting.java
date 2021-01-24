
package com.idsmanager.yhm_demo.service.business;


import com.idsmanager.commons.utils.PasswordHandler;
import com.idsmanager.commons.utils.paginated.PaginatedLoader;
import com.idsmanager.commons.web.context.BeanProvider;
import com.idsmanager.yhm_demo.domain.security.Privilege;
import com.idsmanager.yhm_demo.domain.security.User;
import com.idsmanager.yhm_demo.domain.security.UserRepository;
import com.idsmanager.yhm_demo.service.dto.user.UserDto;
import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import com.idsmanager.yhm_demo.service.dto.user.UserPaginated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2015/12/21
 *
 * @author Shengzhao Li
 */
public class UserSetting {
    private static final Logger LOG = LoggerFactory.getLogger(UserSetting.class);

    private transient UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    private UserFormDto userFormDto;

    private UserDto userDto;

    private UserPaginated userPaginated;

    public UserSetting(UserFormDto userFormDto) {
        this.userFormDto = userFormDto;
    }
    public UserSetting(UserDto userDto) {
        this.userDto = userDto;
    }
    public UserSetting(UserPaginated userPaginated) {
        this.userPaginated = userPaginated;
    }



    public void saveUser() {/*public UserPaginated load() {

    }*/
    String username = userFormDto.getUsername();
    Set<Privilege> privileges = userFormDto.getPrivileges();
    String password = PasswordHandler.encryptPassword(userFormDto.getPassword(), username);
    final User user = new User(username, password);
        user.privileges().addAll(privileges);
        userRepository.saveUser(user);
}

    public UserDto toUpdate() {
    final User user = userRepository.findByGuid(userDto.getUuid());
    UserDto userDto = new UserDto();
        userDto.setUuid(user.uuid());
        userDto.setUsername(user.username());
        userDto.setPrivileges(user.privileges());
        return userDto;
}

    public void updateUser() {
    final User user = userRepository.findByGuid(userDto.getUuid());
        user.username(userDto.getUsername());
        user.privileges().removeAll(user.privileges());
        user.privileges().addAll(userDto.getPrivileges());
        userRepository.updateUser(user);
}
    public String resetPwd() {
    String newPassword = PasswordHandler.randomPassword();
    User user = userRepository.findByGuid(userDto.getUuid());
        user.setPassword(newPassword);
        userRepository.updateUserPassword(user);
        return newPassword;
}

    public void deleteUser() {
        final User user = userRepository.findByGuid(userDto.getUuid());
        userRepository.removeUser(user);
    }
}
