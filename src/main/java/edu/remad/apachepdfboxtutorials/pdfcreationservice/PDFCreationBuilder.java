package edu.remad.apachepdfboxtutorials.pdfcreationservice;

import java.util.ArrayList;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * A pdf creator written with a builder pattern
 */
public class PDFCreationBuilder {

  /**
   * empty in-memory PDF document
   */
  private final PDDocument pdfDocument;

  /**
   * PDF page to add to PDF document
   */
  private final ArrayList<PDPage> pdfPages;

  /**
   * pdf document information
   */
  private PDDocumentInformation documentInformation;

  /**
   * PDFCreationBuilder constructor
   */
  public PDFCreationBuilder() {
    this.pdfDocument = new PDDocument();
    this.pdfPages = new ArrayList<>();
    this.documentInformation = new PDDocumentInformation();
  }

  /**
   * Adds page
   *
   * @param page PDF page to add to pdf document
   * @return PDF creation builder
   */
  public PDFCreationBuilder addPage(PDPage page) {
    this.pdfPages.add(page);

    return this;
  }

  /**
   * Adds pages.
   *
   * @param pages PDF pages to add to document
   * @return PDF creation builder
   */
  public PDFCreationBuilder addPages(ArrayList<PDPage> pages) {
    this.pdfPages.addAll(pages);

    return this;
  }

  /**
   * Sets document information
   *
   * @param author        string-encoded author
   * @param invoiceNumber numeric invoice number
   * @param creator       string-encoded creator
   * @param subject       string-encoded subject
   * @param creationDate  date-encoded creation date
   * @param keywords      string-encoded keywords
   * @return PDF creation builder
   */
  public PDFCreationBuilder setDocumentInformation(String author, long invoiceNumber,
      String creator,
      String subject, Date creationDate, String keywords) {
    this.documentInformation = new DocumentInformationBuilder()
        .setAuthor(author)
        .setInvoiceNumber(invoiceNumber)
        .setCreator(creator)
        .setSubject(subject)
        .setCreationDate(creationDate)
        .setKeywords(keywords)
        .build();

    return this;
  }

  /**
   * Builds PDF
   *
   * @return built PDF document
   */
  public PDDocument build() {
    if (!this.pdfPages.isEmpty()) {
      for (PDPage page : this.pdfPages) {
        this.pdfDocument.addPage(page);
      }
    }

    this.pdfDocument.setDocumentInformation(this.documentInformation);

    return this.pdfDocument;
  }
}
