package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface AbstractReportElementsFactory {

  public abstract ReportBody createReportBody();

  public abstract ReportFooter createReportFooter();

  public abstract ReportHeader createReportHeader();
}
