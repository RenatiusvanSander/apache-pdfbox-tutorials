package edu.remad.apachepdfboxtutorials.pdfcreationservice;

public class PageLayoutUtilities {

  /**
   * points constant
   */
  public static final float POINTS_CONSTANT = 2.8346438836889f;
  /**
   * point unit
   */
  public static final float POINT_UNIT = 25.4f / 72f;

  /**
   * private PageLayoutUtilities Constructor for static access
   */
  private PageLayoutUtilities() {
  }

  /**
   * Converts point to milimetres
   *
   * @param point 1 pt = 1/72 inch = 25.4/72 mm
   * @return converted point value as milimetres
   */
  public static float convertPointToMm(final float point) {
    return point * POINT_UNIT;
  }

  /**
   * Converts mm to points.
   *
   * @param mm milimetres to convert into points
   * @return converted milimtres values as points
   */
  public static float convertMmToPoint(final float mm) {
    return mm * POINTS_CONSTANT;
  }
}
