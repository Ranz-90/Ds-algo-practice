package java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class DateAPIJava8Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate now = LocalDate.now();
		
		now.parse("2015-02-20");
		
		now.of(2015, 02, 20);
		
		/*
		 * This example obtains the current date and subtracts one month. Note how it
		 * accepts an enum as the time unit:
		 */

			LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
			/*
			 * In the following two code examples, we parse the date �2016-06-12� and get
			 * the day of the week and the day of the month respectively. Note the return
			 * values � the first is an object representing the DayOfWeek, while the second
			 * is an int representing the ordinal value of the month:
			 */

				DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();

				int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
				
				/*
				 * We can test if a date occurs in a leap year, for example the current date:
				 */

          boolean leapYear = LocalDate.now().isLeapYear();
					
		boolean notBefore = LocalDate.parse("2016-06-12")
							  .isBefore(LocalDate.parse("2016-06-11"));

		boolean isAfter = LocalDate.parse("2016-06-12")
							  .isAfter(LocalDate.parse("2016-06-11"));
							/*
							 * Finally, date boundaries can be obtained from a given date.
							 * 
							 * In the following two examples, we get the LocalDateTime that represents the
							 * beginning of the day (2016-06-12T00:00) of the given date and the LocalDate
							 * that represents the beginning of the month (2016-06-01) respectively:
							 */

	LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
	LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
							  .with(TemporalAdjusters.firstDayOfMonth());
	
/*	The factory method of can also be used to create a LocalTime. 
	This code creates LocalTime representing 6:30 a.m. using the factory method:*/

		LocalTime sixThirty = LocalTime.of(6, 30);
		/*
		 * Let's create a LocalTime by parsing a string and adding an hour to it by
		 * using the �plus� API. The result would be LocalTime representing 7:30 a.m.:
		 */

		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		
		/*
		 * The below code samples explain how to create an instance using the factory
		 * �of� and �parse� methods. The result would be a LocalDateTime instance
		 * representing February 20, 2015, 6:30 a.m.:
		 */

			LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
			LocalDateTime.parse("2015-02-20T06:30:00");
			
			ZoneId zoneId = ZoneId.of("Europe/Paris");
			/* And we can get a set of all zone ids: */

			Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
			
			/*The LocalDateTime can be converted to a specific zone:*/

			/* ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId); */
				/*
				 * The ZonedDateTime provides the parse method to get time-zone-specific
				 * date-time:
				 */

				ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
				
				/*
				 * Then we add two hours to the time by creating a ZoneOffset and setting for
				 * the localDateTime instance:
				 */

					ZoneOffset offset = ZoneOffset.of("+02:00");

					/*
					 * OffsetDateTime offSetByTwo = OffsetDateTime .of(localDateTime, offset);
					 */

	}

}
