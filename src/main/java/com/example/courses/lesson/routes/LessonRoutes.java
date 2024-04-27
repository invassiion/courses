package com.example.courses.lesson.routes;

import com.example.courses.base.config.BaseRoutes;

public class LessonRoutes {
    private static final String ROOT = BaseRoutes.API + "/lesson";
    public static final String CREATE = ROOT;
    public static final String UPDATE = ROOT + "/{id}";
    public static final String BY_ID = ROOT + "/{id}";
    public static final String SEARCH = ROOT;
    public static final String DELETE = ROOT + "/{id}";
}
