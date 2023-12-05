
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import com.ibm.icu.util.Calendar;

public class DateTimeUtilsRunner {
    public static void main(String[] args) {
        System.out.println("Java 7 and before:");
        Date date = new Date(1467262800000L);
        System.out.println("Converting Gregorian date to Persian:");
        Calendar persianCalendar = DateTimeUtils.fromDateToPersianCalendar(date);
        System.out.println(persianCalendar.get(Calendar.YEAR));
        System.out.println(persianCalendar.get(Calendar.MONTH));
        System.out.println(persianCalendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(DateTimeUtils.fromDateToPersianString(persianCalendar.getTime()));

        System.out.println("\nAdding 1 month and 5 days:");
        persianCalendar.add(Calendar.MONTH, 1); // add a month
        persianCalendar.add(Calendar.DAY_OF_MONTH, 5); // add 5 days
        System.out.println(persianCalendar.get(Calendar.YEAR));
        System.out.println(persianCalendar.get(Calendar.MONTH));
        System.out.println(persianCalendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(DateTimeUtils.fromDateToPersianString(persianCalendar.getTime()));

        System.out.println("\nConverting Persian date to Gregorian:");
        Date gregorianDate = DateTimeUtils.fromPersianDateToDate(1395, 3, 10, 9, 30, 0);
        System.out.println(gregorianDate);
        System.out.println(DateTimeUtils.fromDateToPersianString(gregorianDate)); // to Persian string
        System.out.println(DateTimeUtils.fromDateToPersianString(gregorianDate, "dd/MM/yy - H:mm:dd")); // to
//        Persian string with custom format
        System.out.println(DateTimeUtils.fromDateToPersianString(gregorianDate, "dd/MM/yy - H:mm:dd",
                DateTimeUtils.PERSIAN_EN_LOCALE)); // to Persian string with custom format and Latin characters
        System.out.println("\n" + "Java 8 onward:");
        ZonedDateTime gregorianZonedDateTime = DateTimeUtils.fromPersianDateToZonedDateTime(1395, 3, 10,
                9, 30, 0);
        System.out.println(gregorianZonedDateTime);
        LocalDateTime gregorianLocalDateTime = DateTimeUtils.fromPersianDateToLocalDateTime(1395, 3, 10, 9,
                30, 0);
        System.out.println(gregorianLocalDateTime);
    }
}