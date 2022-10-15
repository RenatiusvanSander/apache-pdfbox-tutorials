package edu.remad.apachepdfboxtutorials;

import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TableCreator {

  public static void main(String[] args) throws IOException {
    PDPage page = new PDPage(PDRectangle.A4);
    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(page);

    int pageHeight = (int) page.getTrimBox().getHeight();
    int pageWidth = (int) page.getTrimBox().getWidth();

    PDFont fontType = PDType1Font.TIMES_ROMAN;
    float fontSize = 12.0f;

    PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);

    contentStream.setStrokingColor(Color.DARK_GRAY);
    contentStream.setLineWidth(1);

    int initX = 50;
    int initY = pageHeight - 50;
    int cellHeight = 30;
    int cellWidth = 100;

    int columnCount = 5;
    int rowCount = 10;

    for(int i = 1; i <= rowCount; i++) {
      for(int j = 1; j <= columnCount; j++) {
        contentStream.addRect(initX, initY, cellWidth, -cellHeight);

        contentStream.beginText();
        contentStream.newLineAtOffset(initX + 10, initY -cellHeight +10);
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 18f);
        contentStream.showText("Hello");
        contentStream.endText();

        initX += cellWidth;
      }

      initX = 50;
      initY -= cellHeight;
    }

    contentStream.stroke();
    contentStream.close();

    pdfDocument.save("/home/rmeier/draw_simple_table.pdf");
    pdfDocument.close();
  }
}
