package simplePlayer;

public class MediaPlayer {

    public static void main(String[] args) {
        String url = "C:\\Users\\wgx\\Desktop\\a.mp4";
        PlayerRunnable playerRunnable = new PlayerRunnable(url);
        playerRunnable.paly();
    }
}

