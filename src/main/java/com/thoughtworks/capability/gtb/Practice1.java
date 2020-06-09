package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {

  public static long getDaysBetweenNextLaborDay(LocalDate date) {

    LocalDate laborDay = LocalDate.of(date.getYear(), 5, 1);
    long days = 0;

    if (date.isAfter(laborDay)) {
      LocalDate nextLaborDay = date.plusYears(1);
      int dayOfYear = nextLaborDay.getDayOfYear();
      nextLaborDay = nextLaborDay.withDayOfYear(dayOfYear);
      days = ChronoUnit.DAYS.between(date, nextLaborDay);
    }else{
      days = ChronoUnit.DAYS.between(date, laborDay);
    }
    return days;
  }
  public static void main(String[] args){
    LocalDate now = LocalDate.of(2020,4,1);
    long daysBetweenNextLaborDay = getDaysBetweenNextLaborDay(now);
    System.out.println(daysBetweenNextLaborDay);
  }
}
