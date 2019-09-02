import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Crawler {

    public static void main(String[] args) throws Exception{
        String url = "https://www.csdn.net";
        Runtime rt = Runtime.getRuntime();
        String exec = "C:\\Users\\10007886\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs C:\\Users\\10007886\\Desktop\\phantomjs-2.1.1-windows\\bin\\code.js " + url;
        Process p = rt.exec(exec);
        InputStream is = p.getInputStream();
        Document doc = Jsoup.parse(is, "UTF-8", url);
        Elements elements = doc.getAllElements();
        StringBuffer stringBuffer = new StringBuffer();
        for (Element element : elements) {
            stringBuffer.append(element.attributes()).append("\n");
//            System.out.println(element.attributes());
        }
        writeFile("C:\\Users\\10007886\\Desktop\\demo.txt",stringBuffer.toString());
    }
    public static void writeFile(String pathname,String content) {
        try {
            File writeName = new File(pathname);
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(content);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}