package com.mikey.eas.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/25 11:30
 * @Version 1.0
 */
public class DateFormat {

    private static final SimpleDateFormat formatterDetail = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat formatterSimple = new SimpleDateFormat("yyyy-MM-dd");


    public static String getNowTimeDetail(){
        return formatterDetail.format(new Date());
    }

    public static String foratterTimeDetail(Date date){
        return formatterDetail.format(date);
    }

    public static String getNowTimeSimple(){
        return formatterDetail.format(new Date());
    }

    public static String foratterTimeSimple(Date date){
        return formatterDetail.format(date);
    }
}
