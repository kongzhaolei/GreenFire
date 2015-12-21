package com.needle.greenfire.servlet;

import com.needle.greenfire.engine.TimerManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFLightDataTimerListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent event) {
		new TimerManager();
	}

	public void contextInitialized(ServletContextEvent event) {
	}
}
