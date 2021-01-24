package com.idsmanager.yhm_demo.web.context;

import com.idsmanager.commons.web.context.ExtContextLoaderListener;
import com.idsmanager.yhm_demo.infrastructure.JzytConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 2017/1/4
 *
 * @author Shengzhao Li
 */
public class JzytContextLoaderListener extends ExtContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

        final ServletContext servletContext = event.getServletContext();
        //set version
        servletContext.setAttribute("currVersion", JzytConstants.VERSION);
        //log
        servletContext.log("JZYT Context Initialled, Version: " + JzytConstants.VERSION);

    }
}
