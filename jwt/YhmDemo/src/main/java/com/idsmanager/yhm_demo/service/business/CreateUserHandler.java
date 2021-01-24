
package com.idsmanager.yhm_demo.service.business;


import com.idsmanager.commons.utils.PasswordHandler;
import com.idsmanager.commons.web.context.BeanProvider;
import com.idsmanager.yhm_demo.domain.security.UserRepository;
import com.idsmanager.yhm_demo.domain.security.User;
import com.idsmanager.yhm_demo.domain.security.SecurityUtils;
import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2015/12/19
 *
 * @author Shengzhao Li
 */
public class CreateUserHandler {


    private static final Logger LOG = LoggerFactory.getLogger(CreateUserHandler.class);

    private transient UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    private UserFormDto formDto;

    public CreateUserHandler(UserFormDto formDto) {
        this.formDto = formDto;
    }

    public String handle() {

        final String username = formDto.getUsername();
        final String pass = PasswordHandler.encryptPassword(formDto.getPassword(), username);
        User user = new User(username, pass);
        user.privileges().addAll(formDto.getPrivileges());


        userRepository.saveUser(user);
        LOG.debug("{}|Create User: {}", SecurityUtils.username(), user);

        return user.uuid();
    }
}
