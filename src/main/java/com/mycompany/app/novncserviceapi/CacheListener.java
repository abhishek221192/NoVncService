/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.novncserviceapi;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CacheListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Bean for store the configuration data.
        Map<String, Process> map = new HashMap<String, Process>();

        // Load file and read it.

        // Store the bean in application context.
        ServletContext context = sce.getServletContext();
        context.setAttribute("myconfig", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.removeAttribute("myconfig");
    }

}
