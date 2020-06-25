package com.zerobank.utilities;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtility {

    /**
     *
     * @param fromDate
     * @param toDate
     * @param datesString --> actual dates from page ex:   List<String> datesString =BrowserUtils.getElementsText(accountActivity.allDates)
     * @param dateFormatinput --> like as "yyyy-MM-dd"
     */
    public void verify_dates_between_to(String fromDate, String toDate, List<String> datesString , String dateFormatinput ){
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatinput);

        try {
            Date fromD = dateFormat.parse(fromDate);
            Date afterD = dateFormat.parse(toDate);
            BrowserUtils.waitFor(1);

            List<Date> actualDates = new ArrayList<>();
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
            for (Date actualDate : actualDates) {
                boolean isBetween =
                        (actualDate.after(fromD) || actualDate.equals(fromD)) &&
                                (actualDate.before(afterD) || actualDate.equals(afterD));
                Assert.assertTrue("Date range is not as expected", isBetween);
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format, correct format should be: yyyy-MM-dd");
        }
}
}
