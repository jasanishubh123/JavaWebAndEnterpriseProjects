import java.io.*;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordHandling
{
    public static void main(String[] args)
    {
       try {
                File file = new File("ejb.doc");
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());

                XWPFDocument document = new XWPFDocument(fis);

                List<XWPFParagraph> paragraphs = document.getParagraphs();


                for (XWPFParagraph para : paragraphs) {
                    System.out.println(para.getText());
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}