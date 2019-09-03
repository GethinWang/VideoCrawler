import simplePlayer.PlayerRunnable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String url = "https://www.acfun.cn/bangumi/ab5025182";
        List<String> urls = new Crawler().getVideoUrls(url);
        if(urls.size()!=0){
            PlayerRunnable playerRunnable = new PlayerRunnable(urls.get(0));
            playerRunnable.paly();
        }
    }
}
