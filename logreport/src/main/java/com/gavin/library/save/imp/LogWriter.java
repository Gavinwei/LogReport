package com.gavin.library.save.imp;

import com.gavin.library.LogReport;
import com.gavin.library.save.ISave;
import com.gavin.library.util.LogUtil;

/**
 * 用于写入Log到本地
 *  2016/7/9.
 */
public class LogWriter {
    private static LogWriter mLogWriter;
    private static ISave mSave;

    private LogWriter() {
    }


    public static LogWriter getInstance() {
        if (mLogWriter == null) {
            synchronized (LogReport.class) {
                if (mLogWriter == null) {
                    mLogWriter = new LogWriter();
                }
            }
        }
        return mLogWriter;
    }


    public LogWriter init(ISave save) {
        mSave = save;
        return this;
    }

    public static void writeLog(String tag, String content) {
        LogUtil.d(tag, content);
        mSave.writeLog(tag, content);
    }
}