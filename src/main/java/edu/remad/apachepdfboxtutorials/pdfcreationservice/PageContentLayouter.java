package edu.remad.apachepdfboxtutorials.pdfcreationservice;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class PageContentLayouter {

  /**
   * height of 45 mm offset to have place for header
   */
  private static final float OFFSET_HEADER = PageLayoutUtilities.convertMmToPoint(46.6f);

  /**
   * left offset 25mm of page
   */
  private static final float OFFSET_LEFT = PageLayoutUtilities.convertMmToPoint(25f);

  /**
   * zero offset, means zero points
   */
  private static final float ZERO_OFFSET = 0f;

  /**
   * the font size of 12 points
   */
  private static final float FONT_SIZE = 12f;
  /**
   * a blank DIN4 rectangled in-memory-PDF-Document
   */
  private final PDDocument pdfDocument;
  /**
   * PDF page
   */
  private final PDPage pdfPage;

  /**
   * pdf page content stream
   */
  private final PDPageContentStream contentStream;

  /**
   * content layout data
   */
  private final ContentLayoutData contentLayoutData;

  /**
   * PageContentLayouter Constructor
   *
   * @param pdfDocument In-Memory PDF-Document
   * @param pdfPage     DIN A4 rectangled PDF page
   * @throws IOException In case of the {@link PDPageContentStream} fails to initialize.
   */
  public PageContentLayouter(final PDDocument pdfDocument, final PDPage pdfPage,
      final ContentLayoutData contentLayoutData)
      throws IOException {
    this.pdfDocument = pdfDocument;
    this.pdfPage = pdfPage;
    this.contentLayoutData = contentLayoutData;
    this.contentStream = new PDPageContentStream(pdfDocument, pdfPage);

    build();
  }

  /**
   * Build the content and layouts
   */
  private void build() throws IOException {
    this.generateAddressHeader();
  }

  /**
   * Generates address header
   *
   * @throws IOException
   */
  private void generateAddressHeader() throws IOException {
    this.contentStream.beginText();
    float upperLeftHeight = this.pdfPage.getMediaBox().getHeight();
    this.contentStream.newLineAtOffset(OFFSET_LEFT, upperLeftHeight - OFFSET_HEADER);
    this.contentStream.showText(this.contentLayoutData.getFullName());
    this.contentStream.newLineAtOffset(ZERO_OFFSET, -FONT_SIZE);
    this.contentStream.showText(this.contentLayoutData.getStreetHouseNumber());
    this.contentStream.newLineAtOffset(ZERO_OFFSET, -FONT_SIZE);
    this.contentStream.showText(this.contentLayoutData.getLocationZipCode());
    this.contentStream.endText();
    this.contentStream.close();
  }
}
