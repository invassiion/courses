package com.example.courses.student.routes;

import com.example.courses.base.config.BaseRoutes;

public class StudentRoutes {
    private static final String ROOT = BaseRoutes.API + "/student";
    public static final String REGISTRATION = BaseRoutes.NOT_SECURED + "/v1/registration";
    public static final String UPDATE = ROOT;
    public static final String BY_ID = ROOT + "/{id}";
    public static final String SEARCH = ROOT;
    public static final String INIT = BaseRoutes.NOT_SECURED + "/init";
}