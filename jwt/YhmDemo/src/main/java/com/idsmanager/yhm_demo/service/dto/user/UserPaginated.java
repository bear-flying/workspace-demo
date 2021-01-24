
package com.idsmanager.yhm_demo.service.dto.user;


import com.idsmanager.commons.utils.paginated.DefaultPaginated;
import com.idsmanager.commons.web.WebUtils;

import java.util.Map;

/**
 * 2015/12/19
 *
 * @author Shengzhao Li
 */
public class UserPaginated extends DefaultPaginated<UserDto> {


    private String username;

    public UserPaginated() {
    }

    @Override
    public Map<String, Object> queryMap() {
        final Map<String, Object> map = super.queryMap();
        map.put("username", WebUtils.paramFilter(username));
        return map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
