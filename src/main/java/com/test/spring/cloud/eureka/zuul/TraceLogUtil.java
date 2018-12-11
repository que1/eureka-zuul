package com.test.spring.cloud.eureka.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**   
 * ProjectName: xlcloud-aq-springboot
 * ClassName:   TraceLogUtils   
 * Copyright:    
 * Company:     xunlei
 * @author:     wanglukun
 * @version:    1.0   
 * @since:      jdk 1.7
 * Create at:   2018年1月11日
 * Description:  
 * 
 * 
 * Modification History:   
 * Date       Author      Version      Description   
 * -------------------------------------------------------------
 *        
 *
 */
public class TraceLogUtil {
    
    private static Logger traceLogger = null;
    
    static {
        traceLogger =  LoggerFactory.getLogger("traceLogger");
    }    
    
    /**
     * 打印traceLog
     */
    public static void traceLog(String msg) {
        traceLogger.info(msg);
    }

    /**
     * 打印traceLog
     */
    public static void traceLog(String msg, Exception e) {
        traceLogger.info(msg + "\n" + getExceptionTrace(e));
    }

    private static String getExceptionTrace(Exception e) {
        String print = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter wrt = new PrintWriter(bout);
        e.printStackTrace(wrt);
        wrt.close();
        print = bout.toString();
        return print;
    }
    
    public static void errorLog(String msg) {
        traceLogger.error(msg);
    }
    
    public static void debugLog(String msg) {
        traceLogger.debug(msg);
    }

}
