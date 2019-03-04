package eu.jpereira.trainings.designpatterns.creational.builder.html;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class HTMLReportBodyBuilder implements ReportBodyBuilder {

  private HTMLReportBody reportBody = new HTMLReportBody();

  @Override
  public ReportBodyBuilder setCustomerName(String customerName) {
    reportBody.setContent("<span class=\"customerName\">");
    reportBody.setContent(customerName);
    reportBody.setContent("</span><span class=\"customerPhone\">");
    return this;
  }

  @Override
  public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
    reportBody.setContent(phoneNumber);
    reportBody.setContent("</span>");
    return this;
  }

  @Override
  public ReportBodyBuilder withItems() {
    reportBody.setContent("<items>");
    return this;
  }

  @Override
  public ReportBodyBuilder newItem(String name, int quantity, double price) {
    reportBody.setContent("<item><name>");
    reportBody.setContent(name);
    reportBody.setContent("</name><quantity>");
    reportBody.setContent(quantity);
    reportBody.setContent("</quantity><price>");
    reportBody.setContent(price);
    reportBody.setContent("</price></item>");
    return this;
  }

  @Override
  public ReportBodyBuilder endItems() {
    reportBody.setContent("</items>");
    return this;
  }

  @Override
  public ReportBody getReportBody() {
    return reportBody;
  }
}
