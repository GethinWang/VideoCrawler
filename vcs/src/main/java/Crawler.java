import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Crawler {

    public static String rootPath = "";

    static {
        rootPath = Crawler.class.getResource("").getPath().substring(1).replace("target/classes/", "src/main/resources");
    }

    public List<String> getVideoUrls(String url) {
        List<String> ans = new ArrayList<String>();
        System.out.println("==============================开始解析网页==============================");
        try {
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
            String urls = sbf.substring(sbf.indexOf("cdnUrls"));
            urls = urls.substring(0,urls.indexOf("playUrls"));
            urls = urls.substring(urls.indexOf("[")+1,urls.lastIndexOf("]"));
            String[] paths = urls.split(",");
            for (String path : paths) {
                if(path.contains("url")){
                    ans.add(path.substring(path.indexOf(":")+2,path.length()-1));
                }
            }
            System.out.println("==============================结束解析网页==============================");
            System.out.println("播放地址为：");
            for (String an : ans) {
                System.out.println(an);
            }
        }catch (Exception e){
            System.out.println("ERROR!");
        }
        return ans;
    }

    public static void main(String[] args) {
        String url = "https://www.acfun.cn/bangumi/ab5025182";
        System.out.println(new Crawler().getVideoUrls(url).toString());
    }
}