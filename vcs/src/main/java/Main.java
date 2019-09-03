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
//            String url = "https://www.acfun.cn/bangumi/ab5025182";
//            List<String> urls = new Crawler().getVideoUrls(url);
//            //选择输出路径，文件夹
            String output = "C:/Users/10007886/Desktop/a1.mp4";
            Downloader.downloadFile("https://tx-video.acfun.cn/mediacloud/acfun/acfun_video/segment/R0Jb5JHC1jheBaDjBYV4iNX0-uxVwiuat084zhbVYfjKRE1-O_KT0ETzIbc39JH8.m3u8?sign=6522010b8352106960f81757f1c9f08d&t=1567513664&us=684510119",output);
        }catch (Exception e){
            System.out.println("ERROR!"+e);
        }
    }
}
