package edu.remad.apachepdfboxtutorials;

import java.io.InputStream;
import org.apache.jempbox.xmp.pdfa.XMPSchemaPDFAId;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.jempbox.xmp.XMPMetadata;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;

public class PdfACreation {

  public static void main(String[] args) throws Exception {
    PDDocument pdfDoc = new PDDocument();
    PDPage pdfPage = new PDPage(PDRectangle.A4);
    pdfDoc.addPage(pdfPage);

    InputStream fontStream = PdfACreation.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/ArialMT.ttf");
    PDFont font = PDType0Font.load(pdfDoc, fontStream);

    PDMetadata metadata = new PDMetadata(pdfDoc);

    XMPMetadata xmp = new XMPMetadata();
    XMPSchemaPDFAId pdfaid = new XMPSchemaPDFAId(xmp);
    xmp.addSchema(pdfaid);
    pdfaid.setConformance("B");
    pdfaid.setPart(1);
    pdfaid.setAbout("");
    metadata.importXMPMetadata(xmp.asByteArray());

    // Create output intent
    PDDocumentCatalog documentCatalog = new PDDocumentCatalog(pdfDoc);
    InputStream colorProfile = PdfACreation.class.getResourceAsStream("/org/apache/pdfbox/resources/pdfa/sRGB Color Space Profile.icm");
    PDOutputIntent oi = new PDOutputIntent(pdfDoc, colorProfile);
    oi.setInfo("sRGB IEC61966-2.1");
    oi.setOutputCondition("sRGB IEC61966-2.1");
    oi.setOutputConditionIdentifier("sRGB IEC61966-2.1");
    oi.setRegistryName("http://www.color.org");
    documentCatalog.addOutputIntent(oi);
  }
}
