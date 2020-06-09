package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static boolean isWeekend(LocalDate date){

    DayOfWeek dayOfWeek = date.getDayOfWeek();
    return dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
//    Calendar cal = Calendar.getInstance();
//
//    ZoneId zoneId = ZoneId.systemDefault();
//    ZonedDateTime zdt = date.atStartOfDay(zoneId);
//    cal.setTime(Date.from(zdt.toInstant()));
//    return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
  }

  public static LocalDate getNextWorkDate(LocalDate date) {
    LocalDate tomorrow = date.plusDays(1);

    while (isWeekend(tomorrow)){
      tomorrow = tomorrow.plusDays(1);
    }
    return tomorrow;
  }

  public static void main(String[] args){
    LocalDate now = LocalDate.of(2020,6,12);
    System.out.println(getNextWorkDate(now));
  }
}
