package org.leme.z00.jasperscriptlib;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseVariable;
import net.sf.jasperreports.engine.fill.*;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by mendzl on 9/28/2016.
 */
public class ResourceBundleScriptlet extends JRAbstractScriptlet{

    public final static String TERM_SET_PARAMETER = "TermSet";
    public final static String KEY_FIELD = "key";
    public final static String VALUE_FIELD = "value";
    public final static String TERM_TABLE = "terms";

    public ResourceBundleScriptlet() {
        System.out.println("#ResourceBundleScriptlet Constructor");
    }

    @Override
    public void setData(Map<String, JRFillParameter> parsm, Map<String, JRFillField> fldsm, Map<String, JRFillVariable> varsm, JRFillGroup[] grps) {
        super.setData(parsm, fldsm, varsm, grps);
        System.out.println("#setData");
        TimeZone tz = TimeZone.getTimeZone("America/New_York");
        JRFillParameter parameterT = this.parametersMap.get(JRParameter.REPORT_TIME_ZONE);
        System.out.println(parameterT.getValue());
        parameterT.setValue(tz);
        this.parametersMap.put(JRParameter.REPORT_TIME_ZONE, parameterT);
    }

    public String getTerm(String trm){
        System.out.println("#getTerm");
        return "ryryry";
    }


    @Override
    public void beforeReportInit() throws JRScriptletException {




//        JRFillParameter parameterDateFormat = this.parametersMap.get(JsonQueryExecuterFactory.JSON_DATE_PATTERN);
//        System.out.println((String)parameterDateFormat.getValue());
//        parameterDateFormat.setValue("yyyy-MM-dd HH:mm:ss");
//        this.parametersMap.put(JsonQueryExecuterFactory.JSON_DATE_PATTERN, parameterDateFormat);
    }

    private String getTermsQuery(String termSet){
        String query = "SELECT "+KEY_FIELD+", "+VALUE_FIELD+" FROM "+TERM_TABLE ;
        if(termSet != null) {
            query = query + " WHERE '" + termSet + "' = '" + termSet + "'";
        }
        query = query + " UNION SELECT 'datetime.format' AS "+KEY_FIELD+", 'yy/mm/dd HH:mm:ss' AS "+VALUE_FIELD;
        query = query + " UNION SELECT 'date.format' AS "+KEY_FIELD+", 'yy/mm/dd' AS "+VALUE_FIELD;
        query = query + " UNION SELECT 'time.format' AS "+KEY_FIELD+", 'HH:mm:ss' AS "+VALUE_FIELD;
        query = query + " UNION SELECT 'calendar.datetime.format' AS "+KEY_FIELD+", 'yy/mm/dd HH:mm:ss' AS "+VALUE_FIELD;
        query = query + " UNION SELECT 'calendar.date.format' AS "+KEY_FIELD+", 'yy/mm/dd' AS "+VALUE_FIELD;
        query = query + " UNION SELECT 'calendar.time.format' AS "+KEY_FIELD+", 'HH:mm:ss' AS "+VALUE_FIELD;
      //  System.out.println(query);
        return query;
    }

    @Override
    public void afterReportInit() throws JRScriptletException {
        System.out.println("#afterReportInit");
        JRFillVariable v = variablesMap.get("terms");
        Map<String, String> vMap = new HashMap<>();
        vMap.put("key", "ValueFrom map 555 ");
        v.setValue(vMap);
        variablesMap.put("terms", v);





        System.out.println("#beforeReportInit");
        JRFillParameter testParam = this.parametersMap.get(TERM_SET_PARAMETER);
        String termSet = null;
        if(testParam != null){
            termSet = (String)testParam.getValue();
        }

        DynamicResourceBundle rb = new DynamicResourceBundle();
        try {
            Map<String, String> dictionary = new HashMap<>();
            Connection connection  = (Connection)this.parametersMap.get(JRParameter.REPORT_CONNECTION).getValue();
            if(connection != null && !connection.isClosed()) {
                PreparedStatement ps = connection.prepareStatement(getTermsQuery(termSet));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dictionary.put(rs.getString(KEY_FIELD), rs.getString(VALUE_FIELD));
                }
                rb.setDictionary(dictionary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JRFillParameter parameter = this.parametersMap.get(JRParameter.REPORT_RESOURCE_BUNDLE);
        parameter.setValue(rb);
        this.parametersMap.put(JRParameter.REPORT_RESOURCE_BUNDLE, parameter);



        TimeZone tz = TimeZone.getTimeZone("America/New_York");
        JRFillParameter parameterT = this.parametersMap.get(JRParameter.REPORT_TIME_ZONE);
        parameterT.setValue(tz);
        this.parametersMap.put(JRParameter.REPORT_TIME_ZONE, parameterT);


        Locale l = Locale.GERMANY;
        JRFillParameter parameterL = this.parametersMap.get(JRParameter.REPORT_LOCALE);
        parameterL.setValue(l);
        this.parametersMap.put(JRParameter.REPORT_LOCALE, parameterL);

        JRFillParameter parameterF = this.parametersMap.get(JRParameter.REPORT_FORMAT_FACTORY);
        parameterF.setValue(new DinamicPrintFormatFactory());
        this.parametersMap.put(JRParameter.REPORT_FORMAT_FACTORY, parameterF);
        System.out.println(parameterF.getValue());


    }

    @Override
    public void beforePageInit() throws JRScriptletException {
    }

    @Override
    public void afterPageInit() throws JRScriptletException {
    }

    @Override
    public void beforeColumnInit() throws JRScriptletException {

    }

    @Override
    public void afterColumnInit() throws JRScriptletException {

    }

    @Override
    public void beforeGroupInit(String groupName) throws JRScriptletException {

    }

    @Override
    public void afterGroupInit(String groupName) throws JRScriptletException {

    }

    @Override
    public void beforeDetailEval() throws JRScriptletException {

    }

    @Override
    public void afterDetailEval() throws JRScriptletException {

    }
}
