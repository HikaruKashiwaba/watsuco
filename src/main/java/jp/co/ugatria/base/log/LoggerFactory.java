package jp.co.ugatria.base.log;

import org.slf4j.Logger;

public final class LoggerFactory {

	private LoggerFactory() {}

    public static Logger  make() {
        Throwable t = new Throwable();
        StackTraceElement caller = t.getStackTrace()[1];
        return  org.slf4j.LoggerFactory.getLogger(caller.getClassName());
    }
}
