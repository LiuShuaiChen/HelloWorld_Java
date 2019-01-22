package com.LocalDateTimeDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * LocalDateTime时间工具类
 */
public class Demo01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        String str = "2019-01-11";
        DateTimeFormatter formatterStr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(str, formatterStr);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        dateTime.toInstant(ZoneOffset.of("+08:00")).toEpochMilli();
        dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(dateTime.format(formatter));

    }
}
