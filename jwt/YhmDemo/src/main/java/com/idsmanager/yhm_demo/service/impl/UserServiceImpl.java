package com.idsmanager.yhm_demo.service.impl;


import com.idsmanager.commons.utils.paginated.PaginatedLoader;
import com.idsmanager.yhm_demo.domain.security.*;
import com.idsmanager.yhm_demo.service.UserService;
import com.idsmanager.yhm_demo.service.business.CreateUserHandler;
import com.idsmanager.yhm_demo.service.business.DefaultUserInitializer;
import com.idsmanager.yhm_demo.service.business.MySettingDtoUpdater;
import com.idsmanager.yhm_demo.service.business.UserSetting;
import com.idsmanager.yhm_demo.service.dto.user.MySettingDto;
import com.idsmanager.yhm_demo.service.dto.user.UserDto;
import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import com.idsmanager.yhm_demo.service.dto.user.UserPaginated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.rmi.server.LoaderHandler;

import java.util.List;
import java.util.Map;

@Service( "userService")
public class UserServiceImpl implements UserService, UserDetailsService {


    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isExistedUsername(String username) {
        final User user = userRepository.findByUsername(username);
        return user != null;
    }


    @Override
    public UserPaginated loadUserPaginated(UserPaginated paginated) {
        final Map<String, Object> map = paginated.queryMap();
        return paginated.load(new PaginatedLoader<UserDto>() {
            @Override
            public List<UserDto> loadList() {
                final List<User> list = userRepository.findUserPaginated(map);
                return UserDto.toDtos(list);
            }

            @Override
            public long loadTotalSize() {
                return userRepository.totalUserPaginated(map);
            }
        });
    }

    @Override
    public String createUser(UserFormDto formDto) {
        CreateUserHandler handler = new CreateUserHandler(formDto);
        return handler.handle();
    }

    @Override
    public void archiveUserByGuid(String guid) {
        final User user = userRepository.findByGuid(guid);
        LOG.debug("{}|Delete User: {}", SecurityUtils.username(), user);
        userRepository.removeUser(user);
    }

    @Override
    public void updateMySetting(MySettingDto formDto) {
        MySettingDtoUpdater updater = new MySettingDtoUpdater(formDto);
        updater.update();
    }


    @Override
    public String initialDefaultUser() {
        DefaultUserInitializer initializer = new DefaultUserInitializer();
        return initializer.initial();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found by username: " + username);
        }
        return new IdsUserDetails(user);
    }


    @Override
    public UserPaginated getUserList(UserPaginated userPaginated) {
        Map<String, Object> map = userPaginated.queryMap();
        return userPaginated.load(new PaginatedLoader<UserDto>() {
            @Override
            public List<UserDto> loadList() {
                List<User> users = userRepository.findUserPaginated(map);
                return UserDto.toDtos(users);
            }

            @Override
            public long loadTotalSize() {
                return userRepository.totalUserPaginated(map);
            }
        });
    }
    @Override
    public void saveUser(UserFormDto userFormDto){
        UserSetting userSetting = new UserSetting(userFormDto);
        userSetting.saveUser();
    }

    @Override
    public UserDto toUpdate(UserDto userDto) {
        UserSetting userSetting = new UserSetting(userDto);
        return userSetting.toUpdate();
    }

    @Override
    public void updateUser(UserDto userDto) {
        UserSetting userSetting = new UserSetting(userDto);
        userSetting.updateUser();
    }

    @Override
    public String resetPwd(UserDto userDto) {
        UserSetting userSetting = new UserSetting(userDto);
        return userSetting.resetPwd();
    }

    @Override
    public void deleteUser(UserDto userDto) {
        UserSetting userSetting = new UserSetting(userDto);
        userSetting.deleteUser();
    }
}
