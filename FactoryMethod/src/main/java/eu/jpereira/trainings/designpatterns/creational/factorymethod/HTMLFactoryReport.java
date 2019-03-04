package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class HTMLFactoryReport extends ReportGenerator {

  @Override
  public Report instantiateReport() {
    return new HTMLReport();
  }
}
