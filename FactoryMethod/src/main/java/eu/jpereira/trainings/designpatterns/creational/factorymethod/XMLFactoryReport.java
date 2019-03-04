package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class XMLFactoryReport extends ReportGenerator {
  @Override
  public Report instantiateReport() {
    return new XMLReport();
  }
}
