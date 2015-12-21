package com.needle.greenfire.engine;

import java.util.TimerTask;
import org.apache.log4j.Logger;

public class NFDFLightDataTimerTask extends TimerTask {
	private static Logger log = Logger.getLogger(NFDFLightDataTimerTask.class);

	public void run() {
		try {
			RunTestCase.executeTestCase();
		} catch (Exception e) {
			log.info("");
		}
	}
}
