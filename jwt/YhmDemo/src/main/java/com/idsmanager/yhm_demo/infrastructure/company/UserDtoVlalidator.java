package com.idsmanager.yhm_demo.infrastructure.company;


import com.idsmanager.yhm_demo.service.dto.user.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
class UserDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserDto userDto = (UserDto) o;

        if (userDto.getUsername().length()<6){
            errors.rejectValue("username",null,"用户名长度至少6位！");
        }
        if (userDto.getPrivileges() == null || userDto.getPrivileges().size() == 0) {
            errors.rejectValue("privileges", null, "至少选择一个权限！");
        }

    }
}
