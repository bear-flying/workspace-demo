package com.idsmanager.yhm_demo.domain.security;

import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {


    private static SecurityHolder securityHolder;

    public void setSecurityHolder(SecurityHolder securityHolder) {
        SecurityUtils.securityHolder = securityHolder;
    }

    public static UserDetails userDetails() {
        return securityHolder.userDetails();
    }

    public static String username() {
        return securityHolder != null ? securityHolder.username() : null;
    }

    public static String currentUserGuid() {
        final UserDetails userDetails = userDetails();
        if (userDetails instanceof IdsUserDetails) {
            return ((IdsUserDetails) userDetails).user().uuid();
        }
        return null;
    }
/*
    public static String currentClientId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Object principal = authentication.getPrincipal();

        if (authentication instanceof OAuth2Authentication &&
                (principal instanceof String || principal instanceof org.springframework.security.core.userdetails.User)) {
            final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
            return oAuth2Authentication.getName();
        }
        return null;
    }*/
}	
