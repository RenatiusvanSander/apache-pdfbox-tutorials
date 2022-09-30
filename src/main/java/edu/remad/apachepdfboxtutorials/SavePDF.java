package edu.remad.apachepdfboxtutorials;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * Saves PDF
 */
public class SavePDF {

  /**
   * Runs save PDF
   *
   * @param args arguments from environment
   */
  public static void main(String[] args) throws IOException {
    PDPage page = new PDPage(PDRectangle.A4);
    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(page);

    //Saving the document
    pdfDocument.save("/home/rmeier/my_doc.pdf");
    pdfDocument.close();
  }
}
