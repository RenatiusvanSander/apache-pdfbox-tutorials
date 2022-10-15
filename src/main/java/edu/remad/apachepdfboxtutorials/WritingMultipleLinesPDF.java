package edu.remad.apachepdfboxtutorials;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class WritingMultipleLinesPDF {

  /**
   * Runs write multiple lines text into PDF
   *
   * @param args arguments from environment
   */
  public static void main(String[] args) throws IOException {
    PDPage page = new PDPage(PDRectangle.A4);
    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(page);

    String firstLine = "It is only a single line";
    String secondLine = "This is the second line of text";
    PDFont fontType = PDType1Font.TIMES_ROMAN;
    float fontSize = 12.0f;

    PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
    // first overall begin text
    contentStream.beginText();
    contentStream.setFont( fontType, fontSize );
    contentStream.setLeading(fontSize * 1.5f);
    contentStream.newLineAtOffset(25, 700);
    contentStream.showText( firstLine );
    contentStream.newLine();
    contentStream.showText(secondLine);
    contentStream.endText();
    contentStream.close();

    pdfDocument.save("/home/rmeier/write_multiple_lines_doc.pdf");
    pdfDocument.close();
  }
}
