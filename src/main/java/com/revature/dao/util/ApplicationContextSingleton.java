package com.revature.dao.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextSingleton 
{
    private static ApplicationContext INSTANCE = null;

    private ApplicationContextSingleton() {

    }

    public static ApplicationContext getInstance() {
        if (INSTANCE == null) {
            String[] contexts = new String[] {"beans.xml"};
            INSTANCE = new ClassPathXmlApplicationContext(contexts);
        }
        return INSTANCE;
    }
}
