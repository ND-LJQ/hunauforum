package edu.hunau.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 日期工具类
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class DateUtil {


    /**
     * 得到现在sql日期
     *
     * @return {@link Date}
     */
    public Date getNowSqlDate(){
        java.util.Date date = new java.util.Date();
        long  time =  date.getTime();
        java.sql.Date nowSqlDate = new Date(time);
        return nowSqlDate;
    }
}
