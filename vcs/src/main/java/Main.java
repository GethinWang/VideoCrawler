import java.util.List;

public class Main {

//    //播放视频
//    public static void main(String[] args) {
//        String url = "https://www.acfun.cn/bangumi/ab5025182";
//        List<String> urls = new Crawler().getVideoUrls(url);
//        if(urls.size()!=0){
//            PlayerRunnable playerRunnable = new PlayerRunnable(urls.get(0));
//            playerRunnable.paly();
//        }
//    }

    //下载视频
    public static void main(String[] args) {
        try {
            String url = "https://www.acfun.cn/bangumi/ab5025182";
            List<String> urls = new Crawler().getVideoUrls(url);
//            //选择输出路径，文件夹
            String output = "C:/Users/10007886/Desktop/a1.mp4";
            Downloader.downloadFile(urls.get(0),output);
        }catch (Exception e){
            System.out.println("ERROR!"+e);
        }
    }
}
