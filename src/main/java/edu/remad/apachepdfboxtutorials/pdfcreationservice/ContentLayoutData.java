package edu.remad.apachepdfboxtutorials.pdfcreationservice;

import java.awt.Color;
import java.io.File;
import org.apache.pdfbox.pdmodel.font.PDFont;

/**
 * Layouts the content
 */
public class ContentLayoutData {

  /**
   * prefix of invoice creation date
   */
  public static final String INVOICE_CREATION_DATE_PREFIX = "Rechnungsdatum: ";

  public static final String TUTORING_APPOINTMENT_PREFIX = "Nachhilfe am:";
  /**
   * prefix of invoice number
   */
  private static final String INVOICE_NO_PREFIX = "Rechnungsnummer: ";
  /**
   * prefix of full name
   */
  private static final String NAME_PREFIX = "Frau / Herrn ";
  /**
   * full customer's name
   */
  private String customerName;

  /**
   * customers street and house number
   */
  private String streetHouseNumber;

  /**
   * customer's location and zip code united
   */
  private String locationZipCode;

  /**
   * the contact name
   */
  private String contactName;

  /**
   * the contact company
   */
  private String contactCompany;

  /**
   * the contact mobile number
   */
  private String contactMobile;

  /**
   * contact E-Mail
   */
  private String contactEmail;

  /**
   * invoice number
   */
  private String invoiceNo;

  /**
   * the invoice creation date
   */
  private String invoiceCreationDate;

  /**
   * tutoring appointment date and time
   */
  private String tutoringAppointmentDateTime;

  /**
   * logo file path
   */
  private File logo;

  /**
   * font color as {@link Color}
   */
  private Color fontColor;

  /**
   * Normal used font
   */
  private PDFont font;

  /**
   * font for italic styled texte
   */
  private PDFont italicFont;

  /**
   * Sets full name
   *
   * @param firstName customer's first name
   * @param lastName  customer's last name
   */
  public void setCustomerName(String firstName, String lastName) {
    this.customerName = String.format("%s %s %s", NAME_PREFIX, firstName, lastName);
  }

  /**
   * Gets full name
   *
   * @return the full name
   */
  public String getCustomerName() {
    return this.customerName;
  }

  /**
   * Sets street and house number
   *
   * @param street      customer's street to set
   * @param houseNumber customer's house number
   */
  public void setStreetHouseNumber(String street, String houseNumber) {
    this.streetHouseNumber = String.format("%s %s", street, houseNumber);
  }

  /**
   * Gets street house number
   *
   * @return united street and house number
   */
  public String getStreetHouseNumber() {
    return this.streetHouseNumber;
  }

  /**
   * Sets location and zip code
   *
   * @param location customer's location
   * @param zipCode  customer's zip code
   */
  public void setLocationZipCode(String location, String zipCode) {
    this.locationZipCode = String.format("%s %s", location, zipCode);
  }

  /**
   * Gets location zip code
   *
   * @return location and zip code
   */
  public String getLocationZipCode() {
    return this.locationZipCode;
  }

  /**
   * Gets contact name
   *
   * @return contact name
   */
  public String getContactName() {
    return this.contactName;
  }

  /**
   * Sets contact name
   *
   * @param contactName contact name t set
   */
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  /**
   * Gets contact company
   *
   * @return contact company
   */
  public String getContactCompany() {
    return this.contactCompany;
  }

  /**
   * Sets contact company
   *
   * @param contactCompany
   */
  public void setContactCompany(String contactCompany) {
    this.contactCompany = contactCompany;
  }

  /**
   * Gets contact mobile
   *
   * @return contact mobile number
   */
  public String getContactMobile() {
    return this.contactMobile;
  }

  /**
   * Sets contact mobile.
   *
   * @param contactMobile contact mobile number to set
   */
  public void setContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
  }

  /**
   * Gets contact e-Mail
   *
   * @return contact e-mail
   */
  public String getContactEmail() {
    return this.contactEmail;
  }

  /**
   * Sets contact
   *
   * @param contactEmail contact E-Mail to set
   */
  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  /**
   * Gets invoice number
   *
   * @return invoice number
   */
  public String getInvoiceNo() {
    return this.invoiceNo;
  }

  /**
   * Sets invoice number
   *
   * @param invoiceNo invoice number to set
   */
  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = String.format("%s %s", INVOICE_NO_PREFIX, invoiceNo);
  }

  /**
   * Gets invoice creation date
   *
   * @return string-encoded creation date
   */
  public String getInvoiceCreationDate() {
    return this.invoiceCreationDate;
  }

  /**
   * Sets invoice creation date
   *
   * @param invoiceCreationDate invoice creation date to set
   */
  public void setInvoiceCreationDate(String invoiceCreationDate) {
    this.invoiceCreationDate = String.format("%s %s", INVOICE_CREATION_DATE_PREFIX,
        invoiceCreationDate);
  }

  /**
   * Gets tutoring appointment date and time
   *
   * @return string-encoded tutoring appointment date and time
   */
  public String getTutoringAppointmentDateTime() {
    return this.tutoringAppointmentDateTime;
  }

  /**
   * Sets tutoring apoint date and time.
   *
   * @param date string-encoded and DIN 5008:2020 formatted date to set
   * @param time string-encoded and DIN 5008:2020 formatted time to set.
   */
  public void setTutoringAppointmentDateTime(String date, String time) {
    this.tutoringAppointmentDateTime = String.format("%s %s %s",
        TUTORING_APPOINTMENT_PREFIX,
        date,
        time);
  }

  /**
   * Gets logo.
   *
   * @return path to logo as {@link File}
   */
  public File getLogo() {
    return logo;
  }

  /**
   * Sets logo
   *
   * @param logo file path to the logo file
   */
  public void setLogo(File logo) {
    this.logo = logo;
  }

  /**
   * Gets font color.
   *
   * @return color of the font, {@link Color}
   */
  public Color getFontColor() {
    return fontColor;
  }

  /**
   * Sets font color
   *
   * @param fontColor the font color as instance of {@link Color}
   */
  public void setFontColor(Color fontColor) {
    this.fontColor = fontColor;
  }

  public PDFont getFont() {
    return font;
  }

  public void setFont(PDFont font) {
    this.font = font;
  }

  public PDFont getItalicFont() {
    return italicFont;
  }

  public void setItalicFont(PDFont italicFont) {
    this.italicFont = italicFont;
  }
}
