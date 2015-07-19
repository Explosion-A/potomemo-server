package com.tt.potomemo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wukq
 * @explanation
 */
public class DateUtil2
{
	private static Logger logger = LoggerFactory.getLogger(DateUtil2.class);

    public static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String FULL_FORMAT_SSS = "yyyy-MM-dd HH:mm:ss,SSS";

    public static final String FULL_FORMAT_START = "yyyy-MM-dd 00:00:00";

    public static final String FULL_FORMAT_END = "yyyy-MM-dd 23:59:59";

    public static final String DAY_FORMAT = "yyyy-MM-dd";

    /**
     * 计算出离当前日期datas天的日期,若datas小于0表示当前日期之前datas天，若datas大于0表当前日期之后datas天
     * 
     * @param 要计算的天数
     * @return 得到日期
     */
    public static Date getDate(int datas)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DATE, datas);
        String begin = new java.sql.Date(calendar.getTime().getTime())
            .toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        try
        {
            beginDate = sdf.parse(begin);
        }
        catch (ParseException e)
        {
        	logger.error("",e);
        }
        return beginDate;
    }

    /**
     * date:传进来的时间 len:需要改变的天数，正负均可
     */
    public static String monthMove(String date, int len)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.MONTH, len);
            return sdf.format(cal.getTime());
        }
        catch (Exception e)
        {
        	logger.error("",e);
            return date;
        }
    }

    /**
     * date:传进来的时间 len:需要改变的分数，正负均可
     */
    public static String moveMinute(String date, int len)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.MINUTE, len);
            return sdf.format(cal.getTime());
        }
        catch (Exception e)
        {
        	logger.error("",e);
            return date;
        }
    }
    /**
     * date:传进来的时间 len:需要改变的分数，正负均可
     */
    public static Date moveHour(String date, int len)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.HOUR, len);
            return cal.getTime();
        }
        catch (Exception e)
        {
        	logger.error("",e);
            return null;
        }
    }

    /**
     * 
     * @param date
     * @param len
     * @return
     */
    public static String move(String date, int type, int len,
        String fromFormat, String toFormat)
    {

        SimpleDateFormat fromSdf = null;
        SimpleDateFormat toSdf = null;
        if (fromFormat != null)
        {
            fromSdf = new SimpleDateFormat(fromFormat);
        }
        else
        {
            fromSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        if (toFormat != null)
        {
            toSdf = new SimpleDateFormat(toFormat);
        }
        else
        {
            toSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fromSdf.parse(date));
            cal.add(type, len);
            return toSdf.format(cal.getTime());
        }
        catch (Exception e)
        {
        	logger.error("",e);            
            return date;
        }
    }

    /**
     * date:传进来的时间 len:需要改变的天数，正负均可
     */
    public static String getDay(String date, int len)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        }
        catch (Exception e)
        {
        	logger.error("",e);
            return date;
        }
    }

    public static String formatDate(String time, String fromFormat,String toFormat) throws ParseException
    {

        String dateTime = time;

        SimpleDateFormat oldFormat = new SimpleDateFormat(fromFormat);
        SimpleDateFormat newFormat = new SimpleDateFormat(toFormat);

        String dataStr = null;

        dataStr = newFormat.format(oldFormat.parse(dateTime));

        return dataStr;
    }

    public static String getCurrentDate(String formatStr)
    {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(new Date());
    }

    /**
     * 获取当前时间,格式:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static String formatDate(Date date, String formatStr)
    {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }
    
    public static String formatDate(Date date,int day,String formatStr)
    {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(day!=0){
			calendar.add(Calendar.DAY_OF_YEAR, day);
		}
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(calendar.getTime());
    }
    
    public static String getDateByMonth(Date date, int month)
    {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(month!=0){
			calendar.add(Calendar.MONTH, month);
		}
		Date da = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(da);
    }

    /**
     * 取得当前的日期时间
     * 
     * @param str 字符串
     * @param format 格式
     * @return 取得当前的日期时间 如果格式不对则返回null
     */
    public static java.util.Date toDateFromStr(String str, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat();
        try
        {
            sdf.applyPattern(format);
            return sdf.parse(str);
        }
        catch (ParseException e)
        {
        	logger.error("",e);
            return null;
        }
    }

    public static boolean isDate(String date)
    {
        boolean flag = false;
        String pa = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";

        if (date != null)
        {
            flag = date.matches(pa);
        }

        return flag;
    }

    /**
     * 比较d2与d1之差
     * @param d1 格式为yyyy-MM-dd HH:mm:ss
     * @param d2 格式为yyyy-MM-dd HH:mm:ss
     * @return d2-d1的毫秒数
     */
    public static long compare(String d1, String d2)
    {
        long diff = 0;
        Date date1 = toDateFromStr(d1, FULL_FORMAT);
        Date date2 = toDateFromStr(d2, FULL_FORMAT);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        diff = c2.getTimeInMillis() - c1.getTimeInMillis();
        return diff;
    }

    public static int dayDiff(String d1, String d2) {
    	Date date1 = toDateFromStr(d1+" 00:00:00",FULL_FORMAT);
        Date date2 = toDateFromStr(d2+" 00:00:00",FULL_FORMAT);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        
        long msdiff = c2.getTimeInMillis() - c1.getTimeInMillis();
        int daydiff = (int) (msdiff / (24 * 60 * 60 * 1000));
        return Math.abs(daydiff);
    }

    public static int monthsBetween(String pFormerStr, String pLatterStr) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = myFormatter.parse(pFormerStr);
			date2 = myFormatter.parse(pLatterStr);
		} catch (ParseException e) {
			logger.error("",e);
		}

		Calendar myCal1 = Calendar.getInstance();
		Calendar myCal2 = Calendar.getInstance();
		myCal1.setTime(date1);
		myCal2.setTime(date2);

		int year1 = myCal1.get(Calendar.YEAR);
		int year2 = myCal2.get(Calendar.YEAR);

		int month1 = myCal1.get(Calendar.MONTH);
		int month2 = myCal2.get(Calendar.MONTH);

		return ((year2 - year1) * 12 - (month1 - month2));
	}
    
    
    public static List getMonthList(String ym1,String ym2){
    	List list = new ArrayList();
    	int mc = monthsBetween(ym1,ym2)+1;
    	for(int i=0;i<mc;i++){   		
    		Calendar cal = parseDateTime(ym1);
    		cal.add(Calendar.MONTH, i);
    		list.add(getStringDate(cal.getTime(),"yyyy-MM"));
    	}
    	return list;
    } 
    
    public static Calendar parseDateTime(String baseDate)
    {
        Calendar cal = null;
        cal = new GregorianCalendar();
        java.util.Date date= toDateFromStr(baseDate,"yyyy-MM");    
        cal.setTime(date);       
        return cal;
    }

    
    public static String getStringDate(Date date, String pattern) {		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(pattern);
			if (date == null)
				date = new Date();
			String strDate = sdf.format(date);
			sdf = null;
			return strDate;
		} catch (Exception e) {
			logger.error("",e);
			return null;
		}
	} 


    
    
    public static String getYmLastDay(String ym){
    	
    	int year = Integer.parseInt(ym.substring(0, 4));
    	int month = Integer.parseInt(ym.substring(5,7));
    	
    	java.util.Calendar calendar= new java.util.GregorianCalendar();
    	calendar.set(year, month-1, 1);
    	int lastDay = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

    	return String.valueOf(lastDay);
    	
    }

    /**
     * 
    * 方法用途和描述: 字符串转为时间
    * @param date  时间字符串
    * @param pattern 时间格式
    * @return
    * @author chenliang 新增日期：2012-5-14
    * @author 你的姓名 修改日期：2012-5-14
    * @since gdgroup
     */
    public static Date parseDate(String date,String pattern){
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	Date pd = null;
		try {
			if(date!=null && !"".equals(date)){
				pd = sdf.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return pd;
    }
    
    public static Date getBeginAtDate(Date date){
    	java.sql.Date dateSql= new java.sql.Date(date.getTime());
    	String dateString =dateSql.toString();
		String beginAtDateString=dateString+" 00:00:00";
		//String str2 = dateString+" 23:59:59";
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate=null;
		try {
			startDate = formatDate.parse(beginAtDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startDate;
    }
    
    public static Date getEndAtDate(Date date){
    	java.sql.Date dateSql= new java.sql.Date(date.getTime());
    	String dateString =dateSql.toString();
		String endAtDateString=dateString+" 23:59:59";
		//String str2 = dateString+" 23:59:59";
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate=null;
		try {
			endDate = formatDate.parse(endAtDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endDate;
    }
    
    public static void main(String[] args)
    {
    	
    	System.out.println(getYmLastDay("2011-02"));
    	System.out.println(formatDate(new Date(),-1,"yyyy-MM-dd"));
    	System.out.println(formatDate(new Date(),0,FULL_FORMAT_END));
    	System.out.println(dayDiff("2015-03-01","2015-03-12"));
    	System.out.println(toDateFromStr("2015-03-13", DAY_FORMAT));
    	System.out.println(formatDate(toDateFromStr("2015-03-12", DAY_FORMAT),-2,DAY_FORMAT));
    	System.out.println(formatDate(new Date(),0,FULL_FORMAT_END));
    }

}
