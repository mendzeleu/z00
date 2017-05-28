package org.leme.z00.web.z00web.controller.data;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import org.leme.z00.components.domain.user.report.RoleUserReport;
import org.leme.z00.components.service.membership.UserDataService;
import org.leme.z00.jasperscriptlib.DynamicResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/data/user/report")
public class UserReportController {

  @Autowired
  private UserDataService userDataService;

  @Autowired
  ServletContext context;
  

  @RequestMapping(value="/roleuserreport", method = RequestMethod.GET)
  public @ResponseBody
  RoleUserReport getRoleUserReport() {
    return userDataService.getRoleUserReport();
  }

  @RequestMapping(value="/roleuserreport/pdf", method = RequestMethod.GET)
  public @ResponseBody
  ResponseEntity<byte[]> getRoleUserReportPdf() throws JRException, IOException {

    Map<String, Object> params = new HashMap<String, Object>();
//    params.put(JsonQueryExecuterFactory.JSON_DATE_PATTERN, "yyyy-MM-dd");
//    params.put(JsonQueryExecuterFactory.JSON_NUMBER_PATTERN, "#,##0.##");
//    params.put(JsonQueryExecuterFactory.JSON_LOCALE, Locale.ENGLISH);
    params.put(JRParameter.REPORT_LOCALE, Locale.US);
    params.put(JRParameter.REPORT_RESOURCE_BUNDLE, new DynamicResourceBundle());



    String path = context.getRealPath("/WEB-INF");
    JasperPrint jp = JasperFillManager.fillReport(path+"/jasper/user/role_user.jasper", params);

    byte [] report = JasperExportManager.exportReportToPdf(jp);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    String filename = "RoleUserReport.pdf";
    headers.setContentDispositionFormData(filename, filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(report, headers, HttpStatus.OK);

    return response;
  }
  
}
