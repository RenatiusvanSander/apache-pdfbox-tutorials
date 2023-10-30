package edu.remad.apachepdfboxtutorials;

import edu.remad.apachepdfboxtutorials.pdfcreationservice.ContentLayoutData;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.remad.apachepdfboxtutorials.pdfcreationservice.PDFCreationBuilder;
import edu.remad.apachepdfboxtutorials.pdfcreationservice.pagecontent.PDFPageContentTextLayouter;
import edu.remad.apachepdfboxtutorials.pdfcreationservice.pagecontent.SinglePageContentLayouter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
    PDFCreationBuilder pdfBuilder = new PDFCreationBuilder();

    PDDocument document = new PDDocument();
    PDPage firstPage = new PDPage(PDRectangle.A4);
    document.addPage(firstPage);

    ContentLayoutData contentLayout = new ContentLayoutData();
    contentLayout.setCustomerName("Remy", "Meier");
    File logo = new File("src/main/resources/img/logo.png");
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
    List<String> paymentMethods = List.of("Paypal: remad@web.de","Überweisung: DE62 1203 0000 1071 0649 66 / BYLADEM1001","Bargeld","Kleinanzeigen.de-Methoden");
    contentLayout.setPaymentMethods(paymentMethods);
    contentLayout.setPaymentMethodColor(new Color(122, 122, 122));
    contentLayout.setTutoringAppointmentDate("12/03/2023");
    contentLayout.setInvoiceCreationDate("23/03/2023");
    contentLayout.setCapitalFontSize(12F);
    contentLayout.setTextFontSize(16F);
    contentLayout.setPaymentMethodFontSize(10F);
    contentLayout.setbottomLine("Lernen ist das halbe Leben!");
    contentLayout.setBottomLineFontSize(20);
    contentLayout.setBottomLineFontColor(Color.DARK_GRAY);
    contentLayout.setBottomLineWidth(20F);
    contentLayout.setBottomRectColor(new Color(255, 91, 0));
    contentLayout.setBottomRect(new Rectangle(0, 0, 0, 30));
    contentLayout.setAuthoSign("Unterschrift");
    contentLayout.setAuthoSignColor(Color.BLACK);
    contentLayout.setTableCellWidths(new int[]{80, 230, 70, 80, 80});
    contentLayout.setTableCellHeight(30);
    List<String> tableHeaders = List.of("Position", "Beschreibung", "Preis", "Menge", "Gesamt");
    contentLayout.setTableHeaders(tableHeaders);
    List<Map<String, String>> tableRows = new ArrayList<>();
    Map<String,String> row1 = new LinkedHashMap<>();
    row1.put("Position", "1");
    row1.put("Beschreibung", "Elektrotechnik Nachhilfe");
    row1.put("Preis", "25");
    row1.put("Menge", "1");
    row1.put("Gesamt", "25 EUR");
    tableRows.add(row1);
    Map<String,String> row2 = new LinkedHashMap<>();
    row2.put("Position", "2");
    row2.put("Beschreibung", "IHK-Projekt Unterstützung");
    row2.put("Preis", "20");
    row2.put("Menge", "1");
    row2.put("Gesamt", "20 EUR");
    tableRows.add(row2);
    Map<String,String> row3 = new LinkedHashMap<>();
    row3.put("Position", "3");
    row3.put("Beschreibung", "Nachhilfe Programmieren");
    row3.put("Preis", "35");
    row3.put("Menge", "1");
    row3.put("Gesamt", "35 EUR");
    tableRows.add(row3);
    Map<String,String> row4 = new LinkedHashMap<>();
    row4.put("Position", "4");
    row4.put("Beschreibung", "IT Nachhilfe");
    row4.put("Preis", "20");
    row4.put("Menge", "1");
    row4.put("Gesamt", "20 EUR");
    tableRows.add(row4);
    Map<String,String> row5 = new LinkedHashMap<>();
    row5.put("Position", "5");
    row5.put("Beschreibung", "IT-Ausbildung Nachhilfe");
    row5.put("Preis", "12");
    row5.put("Menge", "1");
    row5.put("Gesamt", "12 EUR");
    tableRows.add(row5);
    Map<String,String> row6 = new LinkedHashMap<>();
    row6.put("Position", "6");
    row6.put("Beschreibung", "IT-Ausbildung Nachhilfe");
    row6.put("Preis", "12");
    row6.put("Menge", "1");
    row6.put("Gesamt", "12 EUR");
    tableRows.add(row6);
    contentLayout.setTableRows(tableRows);
    contentLayout.setPageWidth((int) firstPage.getTrimBox().getWidth());
    contentLayout.setPageHeight((int) firstPage.getTrimBox().getHeight());
    contentLayout.setInvoiceNoLabel("Rechnungsnummer");
    contentLayout.setInvoiceDateLabel("Rechnungsdatum");
    contentLayout.setInvoicePerformanceDateLabel("Leistungsdatum");
    contentLayout.setValueAddedTaxDisclaimerText(new String[]{"Gemäß § 19 UStG wird keine Umsatzsteuer berechnet."});

    int pageWidth = contentLayout.getPageWidth();
    int pageHeight = contentLayout.getPageHeight();

    PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
    PDFPageContentTextLayouter myTextClass = new PDFPageContentTextLayouter(document, contentStream);
    SinglePageContentLayouter pageContenLayouter = new SinglePageContentLayouter(document, firstPage, contentLayout, contentStream);

    PDFont font = contentLayout.getFont();
    PDFont italicFont = contentLayout.getItalicFont();

    // int pageHeight = contentLayout.getPageHeight();
    /*Color tableHeadColor = contentLayout.getTableHeaderColor();
    Color tableBodyColor = contentLayout.getTableBodyColor();
    MyTableClass myTable = new MyTableClass(document, contentStream);
    myTable.setTable(contentLayout.getTableCellWidths(), contentLayout.getTableCellHeight(), 25, pageHeight - 350);
    myTable.setTableFont(font, contentLayout.getTextFontSize(), contentLayout.getFontColor());

    // table header, own TableLayouter
    for(String header : contentLayout.getTableHeaders()) {
      myTable.addCell(header, tableHeadColor);
    }

    for(Map<String, String> row : contentLayout.getTableRows()) {
      for (Map.Entry<String, String> entry : row.entrySet()) {
        myTable.addCell(entry.getValue(), tableBodyColor);
      }
    }

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("Zwischen-Summe", null);
    myTable.addCell("", null);
    myTable.addCell("112", null);

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("USt", null);
    myTable.addCell("0%", null);
    myTable.addCell("0", null);

    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("", null);
    myTable.addCell("Summe", tableHeadColor);
    myTable.addCell("112", tableHeadColor);*/

    // myTextClass.addMultiLineText(contentLayout.getValueAddedTaxDisclaimerText(), 15, 25, 270, italicFont, contentLayout.getPaymentMethodFontSize(), contentLayout.getPaymentMethodColor());
    /* myTextClass.addMultiLineText(contentLayout.getPaymentMethods().toArray(String[]::new), 15, 25, 250, italicFont, contentLayout.getPaymentMethodFontSize(),
        contentLayout.getPaymentMethodColor()); */

    /*contentStream.setStrokingColor(contentLayout.getAuthoSignColor());
    contentStream.setLineWidth(2);
    contentStream.moveTo(pageWidth - 250, 150);
    contentStream.lineTo(pageWidth - 25, 150);
    contentStream.stroke();*/

    /*String authoSign = contentLayout.getAuthoSign();
    float authoSignWidth = myTextClass.getTextWidth(authoSign, italicFont, contentLayout.getTextFontSize());
    int xpos = pageWidth - 250 + pageWidth - 25;
    myTextClass.addSingleLineText(authoSign, (int) (xpos - authoSignWidth) / 2, 125, italicFont, contentLayout.getTextFontSize(),
        contentLayout.getFontColor());*/

    /*
    String bottomLine = contentLayout.getBottomLine();
    float bottomLineWidth = myTextClass.getTextWidth(bottomLine, font, contentLayout.getBottomLineWidth());
    myTextClass.addSingleLineText(bottomLine, (int) (pageWidth - bottomLineWidth) / 2, 50,
        italicFont, contentLayout.getBottomLineFontSize(), contentLayout.getBottomLineFontColor()); */

    /*contentStream.setNonStrokingColor(contentLayout.getBottomRectColor());
    contentStream.addRect((float) contentLayout.getBottomRect().getX(), (float) contentLayout.getBottomRect().getY(), pageWidth, (float) contentLayout.getBottomRect().getHeight());
    contentStream.fill();*/

    contentStream.close();
    document.save("C:\\Users\\Remy Meier\\apache-pdfbox-tutorials\\invoice_generated.pdf");
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
