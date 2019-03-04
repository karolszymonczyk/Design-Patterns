package eu.jpereira.trainings.designpatterns.creational.builder.json;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class JSONReportBodyBuilder extends JSONReportBody implements ReportBodyBuilder {

  private JSONReportBody reportBody = new JSONReportBody();

  @Override
  public ReportBodyBuilder setCustomerName(String customerName) {
    reportBody.addContent("sale:{customer:{");
    reportBody.addContent("name:\"");
    reportBody.addContent(customerName);
    return this;
  }

  @Override
  public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
    reportBody.addContent("\",phone:\"");
    reportBody.addContent(phoneNumber);
    reportBody.addContent("\"}");
    return this;
  }

  @Override
  public ReportBodyBuilder withItems() {
    reportBody.addContent(",items:[");
    return this;
  }

  @Override
  public ReportBodyBuilder newItem(String name, int quantity, double price) {
		    if(((String) reportBody.getAsString()).charAt(((String)reportBody.getAsString()).length()-1) != '[') {

		        reportBody.addContent(",");
        }
          reportBody.addContent("{name:\"");
          reportBody.addContent(name);
          reportBody.addContent("\",quantity:");
          reportBody.addContent(String.valueOf(quantity));
          reportBody.addContent(",price:");
          reportBody.addContent(String.valueOf(price));
          reportBody.addContent("}");
          return this;

  }

  @Override
  public ReportBodyBuilder endItems(){
    reportBody.addContent("]}");
    return this;
  }

  @Override
  public ReportBody getReportBody() {
    return reportBody;
  }
}

//	/**
//	 * @param type
//	 * @return
//	 */
//	public Report getReport(String type) {
//		Report report = new Report();
//
//		// Algorithms to build the body objects are different
//		if (type.equals("JSON")) {
//
//			JSONReportBody reportBody = new JSONReportBody();
//			//Add customer info
//			reportBody.addContent("sale:{customer:{");
//			reportBody.addContent("name:\"");
//			reportBody.addContent(saleEntry.getCustomer().getName());
//			reportBody.addContent("\",phone:\"");
//			reportBody.addContent(saleEntry.getCustomer().getPhone());
//			reportBody.addContent("\"}");
//			//add array of items
//			reportBody.addContent(",items:[");
//			Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
//			while ( it.hasNext() ) {
//				SoldItem item = it.next();
//				reportBody.addContent("{name:\"");
//				reportBody.addContent(item.getName());
//				reportBody.addContent("\",quantity:");
//				reportBody.addContent(String.valueOf(item.getQuantity()));
//				reportBody.addContent(",price:");
//				reportBody.addContent(String.valueOf(item.getUnitPrice()));
//				reportBody.addContent("}");
//				if ( it.hasNext() ) {
//					reportBody.addContent(",");
//				}
//
//			}
//			reportBody.addContent("]}");
//
//
//			report.setReportBody(reportBody);
//
//		} else if (type.equals("XML")) {
//			XMLReportBody reportBody = new XMLReportBody();
//			reportBody.putContent("<sale><customer><name>");
//			reportBody.putContent(this.saleEntry.getCustomer().getName());
//			reportBody.putContent("</name><phone>");
//			reportBody.putContent(this.saleEntry.getCustomer().getPhone());
//			reportBody.putContent("</phone></customer>");
//
//			reportBody.putContent("<items>");
//
//			Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
//			while ( it.hasNext() ) {
//				SoldItem soldEntry= it.next();
//				reportBody.putContent("<item><name>");
//				reportBody.putContent(soldEntry.getName());
//				reportBody.putContent("</name><quantity>");
//				reportBody.putContent(soldEntry.getQuantity());
//				reportBody.putContent("</quantity><price>");
//				reportBody.putContent(soldEntry.getUnitPrice());
//				reportBody.putContent("</price></item>");
//			}
//			reportBody.putContent("</items></sale>");
//			report.setReportBody(reportBody);
//		} else if (type.equals("HTML")) {
//
//			HTMLReportBody reportBody = new HTMLReportBody();
//			reportBody.putContent("<span class=\"customerName\">");
//			reportBody.putContent(this.saleEntry.getCustomer().getName());
//			reportBody.putContent("</span><span class=\"customerPhone\">");
//			reportBody.putContent(this.saleEntry.getCustomer().getPhone());
//			reportBody.putContent("</span>");
//
//			reportBody.putContent("<items>");
//
//			Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
//			while ( it.hasNext() ) {
//				SoldItem soldEntry= it.next();
//				reportBody.putContent("<item><name>");
//				reportBody.putContent(soldEntry.getName());
//				reportBody.putContent("</name><quantity>");
//				reportBody.putContent(soldEntry.getQuantity());
//				reportBody.putContent("</quantity><price>");
//				reportBody.putContent(soldEntry.getUnitPrice());
//				reportBody.putContent("</price></item>");
//			}
//			reportBody.putContent("</items>");
//			report.setReportBody(reportBody);
//		}
//
//		return report;
//	}