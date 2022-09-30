package edu.remad.apachepdfboxtutorials;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * Settings documents information for PDF document to create.
 */
public class SettingDocumentInformation {

  /**
   * Runs setting the PDF Document Informations
   *
   * @param args argument from environment
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    PDPage page = new PDPage(PDRectangle.A4);
    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(page);

    PDDocumentInformation documentInformation = new PDDocumentInformation();
    // Setting the author of the document
    documentInformation.setAuthor("Remy Meier");

    // Setting the title of the document
    documentInformation.setTitle("Document Information stored");

    //Setting the creator of the document
    documentInformation.setCreator("TutoringAPI");

    //Setting the subject of the document
    documentInformation.setSubject("Document information subject in document");

    //Setting the created date of the document
    Calendar date = new GregorianCalendar();
    date.set(2015, 11, 5);
    documentInformation.setCreationDate(date);
    //Setting the modified date of the document
    date.set(2016, 6, 5);
    documentInformation.setModificationDate(date);

    //Setting keywords for the document
    documentInformation.setKeywords("sample, first example, my pdf");

    pdfDocument.setDocumentInformation(documentInformation);
    pdfDocument.save("/home/rmeier/my_doc_document_information.pdf");
    pdfDocument.close();
  }
}
