package eu.jpereira.trainings.designpatterns.creational.builder.html;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class HTMLReportBody implements ReportBody {

  private StringBuilder stringBuilder = new StringBuilder();

  @Override
  public Object getAsString() {
    return stringBuilder.toString();
  }

  public void setContent(Object content) {
    this.stringBuilder.append(content);
  }
}
