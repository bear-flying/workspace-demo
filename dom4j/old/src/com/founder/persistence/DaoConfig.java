package com.founder.persistence;

import java.io.Reader;
import java.util.Properties;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

public class DaoConfig {

    private static final String RESOURCE = "com/founder/persistence/dao.xml";

    private static final DaoManager daoManager;

    static {
        try {
            daoManager = newDaoManager(null);
        } catch (Exception ex) {
            throw new RuntimeException("Description.  Cause: " + ex, ex);
        }
    }

    public static DaoManager getDaoManager() {
        return daoManager;
    }

    public static DaoManager newDaoManager(Properties props) {
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            return DaoManagerBuilder.buildDaoManager(reader, props);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not initialize DaoConfig.  Cause: " + ex, ex);
        }
    }
}
