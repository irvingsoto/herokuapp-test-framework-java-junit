package util;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfFont;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Vector;



public class TestLogUtil {

    private String reportFileName, reportFileFoler;

    private String reportFileFullPath;

    private String fontString = "Courier New";

    RtfFont objectFont = new RtfFont(fontString, 12, RtfFont.STYLE_UNDERLINE);
    RtfFont titleFont = new RtfFont(fontString, 12, RtfFont.BOLD);
    RtfFont normalFont = new RtfFont(fontString, 12);
    RtfFont sqlFont = new RtfFont(fontString, 9);

    Document doc = null;
    FileOutputStream steam = null;
    RtfWriter2 rtfWriter2 = null;

    public TestLogUtil(String testCaseReportName, String reportFileFoler) {
        reportFileName = testCaseReportName;
        this.reportFileFoler = reportFileFoler;
        setReportFileFullPath();
        setReportFile();
    }

    private void setReportFileFullPath() {
        reportFileFullPath = reportFileFoler + "/" + reportFileName + DateTimeUtil.getCurrentDateTime() + ".rtf";
    }

    private void setReportFile() {

        try {
            File report_file = new File(reportFileFullPath);

            if (!report_file.exists()) {
                report_file.createNewFile();
            }
            doc = new Document(PageSize.A4);
            steam = new FileOutputStream(reportFileFullPath, true);
            rtfWriter2 = RtfWriter2.getInstance(doc, steam);
            doc.open();
            // rtfWriter2.importRtfDocument(new FileInputStream(report_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printReport(String msg) {

        String curr_date_curr_zone = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");

        if ("START".equals(msg.trim())) {
            try {
                Paragraph p = new Paragraph();
                p.setFont(objectFont);
                Chunk c = new Chunk("Test Case Name :");
                c.setFont(titleFont);
                p.add(c);
                Chunk c1 = new Chunk(reportFileName);
                c1.setFont(titleFont);
                p.add(c1);
                doc.add(p);

                p = new Paragraph();
                doc.add(p);

                p = new Paragraph();
                c = new Chunk("Report Date :");
                c.setFont(objectFont);
                p.add(c);
                c1 = new Chunk(curr_date_curr_zone);
                c1.setFont(normalFont);
                p.add(c1);
                doc.add(p);

                p = new Paragraph();
                c = new Chunk("File Name :");
                c.setFont(objectFont);
                p.add(c);
                c1 = new Chunk(reportFileFullPath);
                c1.setFont(normalFont);
                p.add(c1);
                doc.add(p);

                p = new Paragraph();
                doc.add(p);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("END".equals(msg.trim())) {
            try {
                Paragraph p = new Paragraph();
                doc.add(p);

                p = new Paragraph();
                Chunk c = new Chunk("End Date :");
                c.setFont(objectFont);
                p.add(c);
                Chunk c1 = new Chunk(curr_date_curr_zone);
                c1.setFont(normalFont);
                p.add(c1);
                doc.add(p);
                doc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Paragraph p = new Paragraph();
                doc.add(p);

                p = new Paragraph();
                Chunk c = new Chunk(msg);
                c.setFont(normalFont);
                p.add(c);
                doc.add(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void printImageIntoReport(File imageFile) {

        try {
            Image img = Image.getInstance(imageFile.getAbsolutePath());
            img.scalePercent(15, 15);
            img.setAlignment(Image.MIDDLE);
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(img, 0, 0);
            p.add(c);
            doc.add(p);
            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printImageIntoReport(String imageFileFullPath) {
        try {
            Image img = Image.getInstance(imageFileFullPath);
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(img, 0, 0);
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTestObject(String message) {

        try {
            Paragraph p = new Paragraph();
            p.setFont(objectFont);
            Chunk c = new Chunk("Test Objectives:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printStep(String message, int stepNumber) {

        try {
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Test Step " + stepNumber);
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Description (Actions)");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void printExpectResult(String message) {

        try {
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Expected Results:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printActualResult(String message) {

        try {
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Actual Results:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            // c.setFont(normalFont);
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printSQLResult(Vector<String> result) {

        try {
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("SQL:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            for (int i = 0; i < getMultiRowText(result.get(0)).length; i++) {
                p = new Paragraph();
                c = new Chunk(getMultiRowText(result.get(0))[i]);
                c.setFont(sqlFont);
                p.add(c);
                doc.add(p);
            }

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("SQL Result:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            for (int i = 0; i < getMultiRowText(result.get(1)).length; i++) {
                p = new Paragraph();
                c = new Chunk(getMultiRowText(result.get(1))[i].replace("\r", ""));
                c.setFont(sqlFont);
                p.add(c);
                doc.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] getMultiRowText(String s) {
        String[] ss = s.split("\n\r");
        return ss;
    }

    public void printPrerequisite(String message, int prerequisiteNumber) {

        try {
            Paragraph p = new Paragraph();
            Chunk c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Test Prerequisite " + prerequisiteNumber);
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            p.setFont(objectFont);
            c = new Chunk("Description (Actions)");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void printJustPrint(String message, int y) {

        try {
            Paragraph p = new Paragraph();
            p.setFont(objectFont);
            Chunk c = new Chunk("DataPool Line " +y+ " Actual result:");
            c.setFont(titleFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printOnlyPrint(String message, int y) {

        try {
            Paragraph p = new Paragraph();
            p.setFont(objectFont);
            Chunk c = new Chunk("");
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(message);
            c.setFont(normalFont);
            p.add(c);
            doc.add(p);

            p = new Paragraph();
            c = new Chunk(" ");
            p.add(c);
            doc.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
