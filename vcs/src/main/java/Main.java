import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    public String getByString(String url) {
        String returnBody = "";
        try {
            //先调用下忽略https证书的再请求才可以
            HttpsUrlValidator.retrieveResponseFromServer(url);
            Document doc = Jsoup
                    .connect(url)
                    .header("Accept", "text/html")
                    .header("Accept-Charset", "utf-8")
                    .header("Accept-Encoding", "gzip")
                    .header("Accept-Language", "en-US,en")
                    .header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22")
                    .timeout(10000).get();
            String body = doc.getElementsByTag("body").html();
            System.out.println(body);
        } catch (Exception e) {
            System.out.println("ERROR");
        }finally {
            return returnBody;
        }
    }

    public String getVideoUrl(String result){
        if(result==null){return null;}
        Document doc = Jsoup.parse(result);
        Elements firstElements = doc.select("script");
        return "";
    }

    public static void main(String[] args) {
        String url = "http://play.fkc123.com/vodyun/?url=http://www.le.com/ptv/vplay/31626398.html";
//        String url = "https://www.bilibili.com/video/av63892038/?spm_id_from=333.334.b_63686965665f7265636f6d6d656e64.16";
        new Main().getByString(url);
    }
}
