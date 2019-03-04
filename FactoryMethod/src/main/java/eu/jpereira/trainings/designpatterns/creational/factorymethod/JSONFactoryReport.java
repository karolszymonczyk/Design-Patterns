package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class JSONFactoryReport extends ReportGenerator {
  @Override
  public Report instantiateReport() {
    return new JSONReport();
  }
}
