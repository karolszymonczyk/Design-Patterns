package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class PDFFactoryReport extends ReportGenerator {
  @Override
  public Report instantiateReport() {
    return new PDFReport();
  }
}
