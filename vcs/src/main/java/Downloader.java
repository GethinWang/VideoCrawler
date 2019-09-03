import java.io.*;

/**
 * Create by 10007886 on 2019/9/3
 */
public class Downloader {

    public static String rootPath = "";

    static {
        rootPath = Downloader.class.getResource("").getPath().substring(1).replace("target/classes/", "src/main/resources");
    }

    public static void downloadFile(String url,String output){
        try {
            System.out.println("==============================开始下载==============================");
            Runtime rt = Runtime.getRuntime();
            String exec = rootPath + "/ffmpeg.exe -i \"" + url + "\" -vcodec copy -acodec copy -absf aac_adtstoasc " + output;
            Process p = rt.exec(exec);
//            SequenceInputStream sequenceInputStream = new SequenceInputStream(p.getInputStream(), p.getErrorStream());
//            InputStreamReader inputStreamReader = new InputStreamReader(sequenceInputStream, "UTF-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = null;
//            while (null != (line = bufferedReader.readLine())) {
//                System.out.println(line);
//            }
//            p.waitFor();
//            p.destroy();
//            System.out.println("==============================下载结束==============================");
        }catch (Exception e){
            System.out.println("ERROR!"+e);
        }
    }

}
