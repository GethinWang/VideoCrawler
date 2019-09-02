import java.io.*;

public class Crawler {

    public static void main(String[] args) throws Exception{
        String url = "http://www.le.com/ptv/vplay/31628417.html";
        Runtime rt = Runtime.getRuntime();
        String exec = "C:\\Users\\10007886\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs C:\\Users\\10007886\\Desktop\\phantomjs-2.1.1-windows\\bin\\code.js " + url;
        Process p = rt.exec(exec);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while((tmp = br.readLine())!=null){
            sbf.append(tmp);
        }
        //System.out.println(sbf.toString());
//        return sbf.toString();
        writeFile("C:\\Users\\10007886\\Desktop\\demo.txt",sbf.toString());

//        Document doc = Jsoup.parse(is, "UTF-8", url);
//        Elements elements = doc.getAllElements();
//        StringBuffer stringBuffer = new StringBuffer();
//        for (Element element : elements) {
//            stringBuffer.append(element.attributes()).append("\n");
////            System.out.println(element.attributes());
//        }
//        writeFile("C:\\Users\\10007886\\Desktop\\demo.txt",stringBuffer.toString());
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