package edu.remad.apachepdfboxtutorials;

import edu.remad.apachepdfboxtutorials.pdfcreationservice.ContentLayoutData;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * Concerning complex invoice to be created as PDF.
 */
public class ComplexInvoice {

  /**
   * Runs creation of complex invoice
   *
   * @param args arguments from environment
   * @throws IOException In case of creation of PDF fails.
   */
  public static void main(String[] args) throws IOException {
    PDDocument document = new PDDocument();
    PDPage firstPage = new PDPage(PDRectangle.A4);
    document.addPage(firstPage);

    ContentLayoutData contentLayout = new ContentLayoutData();
    contentLayout.setCustomerName("Remy", "Meier");
    File logo = new File("src/main/resources/img/lifehotout.png");
    contentLayout.setLogo(logo);
    contentLayout.setFont(PDType1Font.HELVETICA);
    contentLayout.setItalicFont(PDType1Font.HELVETICA_OBLIQUE);
    contentLayout.setFontColor(Color.BLACK);
    contentLayout.setStreetHouseNumber("Volksdorfer Grenzweg","40A");
    contentLayout.setLocationZipCode("Hamburg","22359");
    contentLayout.setContactCompany("Remy Meier Freelance Nachhilfe");
    contentLayout.setContactName("Remy Meier");
    contentLayout.setContactStreetHouseNo("Volksdorfer Grenzweg 40A");
    contentLayout.setContactZipAndLocation("22359 Hamburg");
    contentLayout.setContactMobile("+49 176 61 36 22 53");
    contentLayout.setContactEmail("remad@web.de");
    contentLayout.setInvoiceNo("2549");
    contentLayout.setDayFormatter(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    contentLayout.setTimeFormatter(DateTimeFormatter.ofPattern("HH:mm"));
    contentLayout.setTableHeaderColor(new Color(240, 93, 11));
    contentLayout.setTableBodyColor(new Color(219, 218, 198));
    List<String> paymentMethods = List.of("Paypal","Überweisung","Bargeld","Ebay-Kleianzeigen.de Methoden");
    contentLayout.setPaymentMethods(paymentMethods);
    contentLayout.setTUtoringAppointmentDate("12/03/2023");
    contentLayout.setInvoiceCreationDate("23/03/2023");
    int pageWidth = (int) firstPage.getTrimBox().getWidth();
    int pageHeight = (int) firstPage.getTrimBox().getHeight();

    PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);

    MyTextClass myTextClass = new MyTextClass(document, contentStream);

    PDFont font = contentLayout.getFont();
    PDFont italicFont = contentLayout.getItalicFont();

    PDImageXObject headImage = PDImageXObject.createFromFile(
        contentLayout.getLogo().getPath(), document);
    contentStream.drawImage(headImage, 0, pageHeight - 235, pageWidth, 239);

    String[] contactDetails = new String[]{contentLayout.getContactCompany(), contentLayout.getContactName(), contentLayout.getContactStreetHouseNo(),contentLayout.getContactZipAndLocation(), contentLayout.getContactEmail(), contentLayout.getContactMobile()};
    myTextClass.addMultiLineText(contactDetails, 18,
        pageWidth - (int) (font.getStringWidth(Arrays.stream(contactDetails).
            max(Comparator.comparingInt(String::length)).get())+ 2200) / 1000 * 15 - 10, pageHeight - 25, font,
        15, contentLayout.getFontColor());
    myTextClass.addSingleLineText(contentLayout.getContactCompany(), 25, pageHeight - 150, font, 30, contentLayout.getFontColor());

    myTextClass.addSingleLineText(contentLayout.getCustomerName(), 25, pageHeight - 250, font, 16,
        contentLayout.getFontColor());
    myTextClass.addSingleLineText(contentLayout.getStreetHouseNumber(), 25, pageHeight - 274, font, 16,
        contentLayout.getFontColor());
    myTextClass.addSingleLineText(contentLayout.getLocationZipCode(), 25, pageHeight - 294, font, 16,
        contentLayout.getFontColor());

    float textWidth = myTextClass.getTextWidth(contentLayout.getInvoiceNo(), font, 16);
    myTextClass.addSingleLineText(contentLayout.getInvoiceNo(), (int) (pageWidth - 25 - textWidth), pageHeight - 250,
        font, 16, contentLayout.getFontColor());

    String date = LocalDate.parse(contentLayout.getInvoiceCreationDate(), contentLayout.getDateFormatter()).format(contentLayout.getDateFormatter());
    float dateTextWidth = myTextClass.getTextWidth("Rechnungsdatum: " + date, font,
        16);
    myTextClass.addSingleLineText("Rechnungsdatum: " + date,
        (int) (pageWidth - 25 - dateTextWidth), pageHeight - 274, font, 16, contentLayout.getFontColor());
    String tutoringDate = LocalDate.parse(contentLayout.getTutoringAppointmentDate(), contentLayout.getDateFormatter()).format(contentLayout.getDateFormatter());
    float tutoringDateWidth = myTextClass.getTextWidth("Leistungsdatum: " + tutoringDate, font, 16);
    myTextClass.addSingleLineText("Leistungsdatum: " + tutoringDate, (int) (pageWidth - 25 - tutoringDateWidth),
        pageHeight - 298, font, 16, contentLayout.getFontColor());

    MyTableClass myTable = new MyTableClass(document, contentStream);

    int[] cellWidths = new int[]{70, 160, 120, 90, 100};
    myTable.setTable(cellWidths, 30, 25, pageHeight - 350);
    myTable.setTableFont(font, 16, contentLayout.getFontColor());

    Color tableHeadColor = contentLayout.getTableHeaderColor();
    Color tableBodyColor = contentLayout.getTableBodyColor();

    myTable.addCell("Si.No.", tableHeadColor);
    myTable.addCell("Items", tableHeadColor);
    myTable.addCell("Price", tableHeadColor);
    myTable.addCell("Qty", tableHeadColor);
    myTable.addCell("Total", tableHeadColor);

    myTable.addCell("1", tableBodyColor);
    myTable.addCell("Masala", tableBodyColor);
    myTable.addCell("120", tableBodyColor);
    myTable.addCell("2", tableBodyColor);
    myTable.addCell("240", tableBodyColor);

    myTable.addCell("2", tableBodyColor);
    myTable.addCell("Masala", tableBodyColor);
    myTable.addCell("120", tableBodyColor);
    myTable.addCell("2", tableBodyColor);
    myTable.addCell("240", tableBodyColor);

    myTable.addCell("3", tableBodyColor);
    myTable.addCell("Masala", tableBodyColor);
    myTable.addCell("120", tableBodyColor);
    myTable.addCell("2", tableBodyColor);
    myTable.addCell("240", tableBodyColor);

    myTable.addCell("4", tableBodyColor);
    myTable.addCell("Masala", tableBodyColor);
    myTable.addCell("120", tableBodyColor);
    myTable.addCell("2", tableBodyColor);
    myTable.addCell("240", tableBodyColor);

    myTable.addCell("5", tableBodyColor);
    myTable.addCell("Masala", tableBodyColor);
    myTable.addCell("120", tableBodyColor);
    myTable.addCell("2", tableBodyColor);
    myTable.addCell("240", tableBodyColor);

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("Sub Total", null);
    myTable.addCell("", null);
    myTable.addCell("880", null);

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("GST", null);
    myTable.addCell("5%", null);
    myTable.addCell("44", null);

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("Grand Total", tableHeadColor);
    myTable.addCell("", tableHeadColor);
    myTable.addCell("924", tableHeadColor);

    myTextClass.addMultiLineText(contentLayout.getPaymentMethods().toArray(String[]::new), 15, 25, 180, italicFont, 10,
        new Color(122, 122, 122));

    contentStream.setStrokingColor(Color.BLACK);
    contentStream.setLineWidth(2);
    contentStream.moveTo(pageWidth - 250, 150);
    contentStream.lineTo(pageWidth - 25, 150);
    contentStream.stroke();

    String authoSign = "Authorised Signatory";
    float authoSignWidth = myTextClass.getTextWidth(authoSign, italicFont, 16);
    int xpos = pageWidth - 250 + pageWidth - 25;
    myTextClass.addSingleLineText(authoSign, (int) (xpos - authoSignWidth) / 2, 125, italicFont, 16,
        contentLayout.getFontColor());

    String bottomLine = "Rain or shine, it's time to dine";
    float bottomLineWidth = myTextClass.getTextWidth(bottomLine, font, 20);
    myTextClass.addSingleLineText(bottomLine, (int) (pageWidth - bottomLineWidth) / 2, 50,
        italicFont, 20, Color.DARK_GRAY);

    Color bottomRectColor = new Color(255, 91, 0);
    contentStream.setNonStrokingColor(bottomRectColor);
    contentStream.addRect(0, 0, pageWidth, 30);
    contentStream.fill();

    contentStream.close();
    document.save("/home/rmeier/invoice_generated.pdf");
    document.close();
    System.out.println("Document created.");
  }

  /**
   * sets formatted text into the PDF
   */
  private static class MyTextClass {

    /**
     * the pdf-document
     */
    private final PDDocument document;

    /**
     * pdf page content stream
     */
    private final PDPageContentStream contentStream;

    /**
     * MyTextClass Constructor
     *
     * @param document      in-memmory PDF-document
     * @param contentStream page constent stream to stream text on page
     */
    public MyTextClass(PDDocument document, PDPageContentStream contentStream) {
      this.document = document;
      this.contentStream = contentStream;
    }

    /**
     * Adds single line of text
     *
     * @param text      text to add
     * @param xPosition x position
     * @param yPosition y position
     * @param font      font type to foat text
     * @param fontSize  font size of text to add
     * @param color     color for text to add
     * @throws IOException In case of input / output errors to write on PDF-page.
     */
    public void addSingleLineText(String text, int xPosition, int yPosition, PDFont font,
        float fontSize, Color color)
        throws IOException {
      contentStream.beginText();
      contentStream.setFont(font, fontSize);
      contentStream.setStrokingColor(color);
      contentStream.newLineAtOffset(xPosition, yPosition);
      contentStream.showText(text);
      contentStream.endText();
      contentStream.moveTo(0, 0);
    }

    /**
     * Adds multi line text.
     *
     * @param textArray multi line text to write on PDF-page
     * @param leading   the leading
     * @param xPosition x position
     * @param yPosition y position
     * @param font      font type to foat text
     * @param fontSize  font size of text to add
     * @param color     color for text to add
     * @throws IOException In case of input / output errors to write on PDF-page.
     */
    public void addMultiLineText(String[] textArray, float leading, int xPosition, int yPosition,
        PDFont font, float fontSize, Color color) throws IOException {
      contentStream.beginText();
      contentStream.setFont(font, fontSize);
      contentStream.setNonStrokingColor(color);
      contentStream.setLeading(leading);
      contentStream.newLineAtOffset(xPosition, yPosition);

      for (String text : textArray) {
        contentStream.showText(text);
        contentStream.newLine();
      }
      contentStream.endText();
      contentStream.moveTo(0, 0);
    }

    /**
     * Gets text width
     *
     * @param text     the text to calculate text width
     * @param font     the font type
     * @param fontSize font size in points
     * @return text width
     * @throws IOException In case of input or output exceptions.
     */
    public float getTextWidth(String text, PDFont font, float fontSize) throws IOException {
      return font.getStringWidth(text) / 1000 * fontSize;
    }
  }

  /**
   * Concerning creation of table
   */
  private static class MyTableClass {

    /**
     * in.memory PDF-Document
     */
    PDDocument document;

    /**
     * content stream
     */
    PDPageContentStream contentStream;

    /**
     * column widths
     */
    private int[] colWidths;

    /**
     * height of cell
     */
    private int cellHeight;

    /**
     * y position
     */
    private int yPosition;

    /**
     * x position
     */
    private int xPosition;

    /**
     * column position
     */
    private int colPosition = 0;

    /**
     * initial start value position of x
     */
    private int xInitialPosition;

    /**
     * font size in points
     */
    private float fontSize;

    /**
     * font type
     */
    private PDFont font;

    /**
     * the font color
     */
    private Color fontColor;

    /**
     * MyTableClass Constructor
     *
     * @param document      PDF-document to add a table
     * @param contentStream PDF-page content stream to write table on page
     */
    public MyTableClass(PDDocument document, PDPageContentStream contentStream) {
      this.document = document;
      this.contentStream = contentStream;
    }

    /**
     * Sets table
     *
     * @param colWidths  column widths
     * @param cellHeight cell height
     * @param xPosition  x position
     * @param yPosition  y position
     */
    void setTable(int[] colWidths, int cellHeight, int xPosition, int yPosition) {
      this.colWidths = colWidths;
      this.cellHeight = cellHeight;
      this.xPosition = xPosition;
      this.yPosition = yPosition;
      this.xInitialPosition = xPosition;
    }

    /**
     * Sets table font
     *
     * @param font      the font to set for table
     * @param fontSize  the font size to set for text in table
     * @param fontColor the font color to et in table
     */
    void setTableFont(PDFont font, float fontSize, Color fontColor) {
      this.font = font;
      this.fontSize = fontSize;
      this.fontColor = fontColor;
    }

    /**
     * Adds cell
     *
     * @param text      the cell text write
     * @param fillColor the cell fillcolor for cell-background color
     * @throws IOException
     */
    void addCell(String text, Color fillColor) throws IOException {
      contentStream.setStrokingColor(1f);

      if (fillColor != null) {
        contentStream.setNonStrokingColor(fillColor);
      }

      contentStream.addRect(xPosition, yPosition, colWidths[colPosition], cellHeight);

      if (fillColor == null) {
        contentStream.stroke();
      } else {
        contentStream.fillAndStroke();
      }

      contentStream.beginText();
      contentStream.setNonStrokingColor(fontColor);

      if (colPosition == 4 || colPosition == 2) {
        float fontWidth = font.getStringWidth(text) / 1000 * fontSize;
        contentStream.newLineAtOffset(xPosition + colWidths[colPosition] - 20 - fontWidth,
            yPosition + 10);
      } else {
        contentStream.newLineAtOffset(xPosition + 20, yPosition + 10);
      }

      contentStream.showText(text);
      contentStream.endText();

      xPosition = xPosition + colWidths[colPosition];
      colPosition++;

      if (colPosition == colWidths.length) {
        colPosition = 0;
        xPosition = xInitialPosition;
        yPosition -= cellHeight;
      }
    }
  }
}
