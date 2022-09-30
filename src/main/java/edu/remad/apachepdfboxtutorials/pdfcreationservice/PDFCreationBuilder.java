package edu.remad.apachepdfboxtutorials.pdfcreationservice;

import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
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
   * PDFCreationBuilder constructor
   */
  public PDFCreationBuilder() {
    this.pdfDocument = new PDDocument();
    this.pdfPages = new ArrayList<>();
  }

  /**
   * Adds page
   *
   * @param page PDF page to add to pdf document
   */
  public void addPage(PDPage page) {
    this.pdfPages.add(page);
  }

  /**
   * Adds pages.
   *
   * @param pages PDF pages to add to document
   */
  public void addPages(ArrayList<PDPage> pages) {
    this.pdfPages.addAll(pages);
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

    return this.pdfDocument;
  }
}
