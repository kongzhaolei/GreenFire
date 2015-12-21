package com.needle.greenfire.engine;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerManager {
	private static final long PERIOD_DAY = 86400000L;

	public TimerManager() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(11, 21);
		calendar.set(12, 0);
		calendar.set(13, 0);

		Date date = calendar.getTime();

		if (date.before(new Date())) {
			date = addDay(date, 1);
		}
		Timer timer = new Timer();

		NFDFLightDataTimerTask task = new NFDFLightDataTimerTask();

		timer.schedule(task, date, PERIOD_DAY);
	}

	private Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(5, num);
		return startDT.getTime();
	}
}
