package com.needle.greenfire.utils;

import org.apache.log4j.Logger;

public class Logs {
	private static Logger log = Logger.getLogger(Logs.class.getName());

	public static void info(String message) {
		log.info("[" + Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss")
				+ "] [Info] " + message);
	}

	public static void warn(String message) {
		log.warn("[" + Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss")
				+ "] [Warn] " + message);
	}

	public static void error(String message) {
		log.error("[" + Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss")
				+ "] [Error] " + message);
	}

	public static void fatal(String message) {
		log.fatal("[" + Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss")
				+ "] [Fatal] " + message);
	}

	public static void debug(String message) {
		log.debug("[" + Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss")
				+ "] [Debug] " + message);
	}
}
