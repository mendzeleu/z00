package org.leme.z00.jasperscriptlib;

//import net.sf.jasperreports.engine.util.FormatFactory;
import net.sf.jasperreports.engine.util.DefaultFormatFactory;

import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by mendzl on 9/30/2016.
 */
public class DinamicPrintFormatFactory extends DefaultFormatFactory {

    @Override
    public DateFormat createDateFormat(String pattern, Locale locale, TimeZone tz) {
        DateFormat df = super.createDateFormat("YYYY-MM-DD HH:mm:ss", locale, tz);
        //df.
        return df; //DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.GERMAN);
    }
}
