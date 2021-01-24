
package com.idsmanager.yhm_demo.service.business;


import com.idsmanager.commons.utils.PasswordHandler;
import com.idsmanager.commons.web.context.BeanProvider;
import com.idsmanager.yhm_demo.domain.security.UserRepository;
import com.idsmanager.yhm_demo.domain.security.Privilege;
import com.idsmanager.yhm_demo.domain.security.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 2015/12/21
 * <p/>
 * <p/>
 * When the system firstly startup, checking and initialed default-user.
 *
 * @author Shengzhao Li
 */
public class DefaultUserInitializer {


    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserInitializer.class);

    private transient UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    public DefaultUserInitializer() {
    }

    public String initial() {

               long count = userRepository.countUsers();
       /*if (count > 0) {
            return "404";
        }*/

        //初始化时的账号
        String username = "JZYT";
        //初始化时的密码
        String password = PasswordHandler.encryptPassword("JZYT@JZYT", username);
        User user = new User(username, password);
        user.privileges().addAll(Privilege.availablePrivileges());

        userRepository.saveUser(user);
        LOG.info("System initialed default-user: {}", user);

        return user.username();
    }


}
