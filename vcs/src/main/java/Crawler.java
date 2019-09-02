import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Crawler {

    public static String rootPath = "";

    static {
        rootPath = Crawler.class.getResource("").getPath().substring(1).replace("target/classes/", "src/main/resources");
    }

    public static void main(String[] args) throws Exception {
        String url = "https://www.acfun.cn/bangumi/ab5025182";
        Runtime rt = Runtime.getRuntime();
        String exec = rootPath + "/phantomjs.exe " + rootPath + "/code.js " + url;
        Process p = rt.exec(exec);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        writeFile("C:\\Users\\wgx\\Desktop\\demo.txt", sbf.toString());
    }

    public static void writeFile(String pathname, String content) {
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