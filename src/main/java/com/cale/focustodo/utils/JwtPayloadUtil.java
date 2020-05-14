package com.cale.focustodo.utils;

import com.cale.focustodo.service.JwtUtilService;

public class JwtPayloadUtil {

    private JwtUtilService jwtUtil;

    public JwtPayloadUtil(JwtUtilService jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String getUsername(String authorizationHeader){
        return jwtUtil.extractUsername(authorizationHeader.substring(7));
    }


}
