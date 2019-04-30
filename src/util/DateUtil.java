package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date date = parseStringToDate("2018-01-01");
		System.out.println(formatDate(calendar.getTime()));
	}
	public static String formatDate(Date date) {
		String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return result;
	}
	public static String formatDate(long time) {
		Date date = new Date(time);
		return formatDate(date);
	}
	public static Date parseStringToDate(String str) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		return date;
	}
}
