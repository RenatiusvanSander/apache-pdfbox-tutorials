package edu.remad.apachepdfboxtutorials;

import edu.remad.apachepdfboxtutorials.pdfcreationservice.ContentLayoutData;
import edu.remad.apachepdfboxtutorials.pdfcreationservice.PageLayoutUtilities;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * This writes a DIN 5008:2020 formatted invoice to PDF-file.
 */
public class WritingInvoice {

  /**
   * font size for contact block of 9 points
   */
  public static final float CONTACT_FONT_SIZE = 9f;
  /**
   * height of 45 mm offset to have place for header
   */
  private static final float OFFSET_HEADER = PageLayoutUtilities.convertMmToPoint(250.4f);
  /**
   * left offset 25mm of page
   */
  private static final float OFFSET_LEFT = PageLayoutUtilities.convertMmToPoint(25f);

  /**
   * Runs write one single line text into PDF
   *
   * @param args arguments from environment
   */
  public static void main(String[] args) throws IOException {
    PDPage page = new PDPage(PDRectangle.A4);
    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(page);

    ContentLayoutData contentLayoutData = new ContentLayoutData();
    contentLayoutData.setCustomerName("Max", "Mustermann");
    contentLayoutData.setStreetHouseNumber("Musterstraße", "48d");
    contentLayoutData.setLocationZipCode("85354", "Musterstadt");

    float fontSize = 12f;

    PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
    // first overall begin text

    contentStream.beginText();
    contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    float upperLeftHeight = page.getMediaBox().getLowerLeftY();
    contentStream.newLineAtOffset(OFFSET_LEFT, upperLeftHeight + OFFSET_HEADER);
    contentStream.showText(contentLayoutData.getCustomerName());
    contentStream.newLineAtOffset(0, -fontSize);
    contentStream.showText(contentLayoutData.getStreetHouseNumber());
    contentStream.newLineAtOffset(0, -fontSize);
    contentStream.showText(contentLayoutData.getLocationZipCode());
    contentStream.endText();

    contentStream.beginText();
    contentStream.setFont(PDType1Font.HELVETICA, CONTACT_FONT_SIZE);
    float height = page.getMediaBox().getUpperRightY();
    contentStream.newLineAtOffset(PageLayoutUtilities.convertMmToPoint(128.016f),
        height - PageLayoutUtilities.convertMmToPoint(51.562f));
    contentStream.showText(contentLayoutData.getContactName());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getContactCompany());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getContactMobile());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getContactEmail());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getInvoiceNo());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getInvoiceCreationDate());
    contentStream.newLineAtOffset(0f, -CONTACT_FONT_SIZE);
    contentStream.showText(contentLayoutData.getTutoringAppointmentDateTime());
    contentStream.endText();
    contentStream.close();

    pdfDocument.save("/home/rmeier/write_invoice_doc.pdf");
    pdfDocument.close();
  }
}
