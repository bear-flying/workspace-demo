package com.idsmanager.yhm_demo.service;


import com.idsmanager.yhm_demo.service.dto.user.MySettingDto;
import com.idsmanager.yhm_demo.service.dto.user.UserDto;
import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import com.idsmanager.yhm_demo.service.dto.user.UserPaginated;

import java.util.List;

public interface UserService {

    boolean isExistedUsername(String username);

    UserPaginated loadUserPaginated(UserPaginated paginated);

    String createUser(UserFormDto formDto);

    void archiveUserByGuid(String guid);

    void updateMySetting(MySettingDto formDto);

    String initialDefaultUser();

    UserPaginated getUserList(UserPaginated userPaginated);

    void saveUser(UserFormDto userFormDto);

    UserDto toUpdate(UserDto userDto);

    void updateUser(UserDto userDto);

    String resetPwd(UserDto userDto);

    void deleteUser(UserDto userDto);
}
