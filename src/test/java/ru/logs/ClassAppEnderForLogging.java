package ru.logs;

import java.awt.Toolkit;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class ClassAppEnderForLogging extends AppenderSkeleton {

	public void close() {
	}

	public boolean requiresLayout() {
		return false;
	}

	@Override
	public void append(LoggingEvent event) {
		Toolkit.getDefaultToolkit().beep();
		System.out.println(event.getMessage());

	}

}
