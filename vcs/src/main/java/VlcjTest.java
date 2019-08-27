//import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
//
//public class VlcjTest {
//    private static String formatHttpStream(String serverAddress, int serverPort, String id) {
//        StringBuilder sb = new StringBuilder(60);
//        sb.append(":sout=#transcode{vcodec=theo,vb=2200,scale=1,acodec=vorb,ab=32,channels=2,samplerate=44100} :duplicate{dst=std{access=http,mux=ogg,");
//        sb.append("dst=");
//        sb.append(serverAddress);
//        sb.append(':');
//        sb.append(serverPort);
//        sb.append("/");
//        sb.append(id);
//        sb.append("}}");
//        return sb.toString();
//    }
//
//    private Boolean isInterrupt = false;
//    private String url;//摄像头访问地址
//    private HeadlessMediaPlayer mediaPlayer;
//    private String suffix;//发布后的最后一级访问路径
//    private String serverAddress;//发布后的地址(IP)
//    private int serverPort;//发布后的端口号
//
//    public StreamTaskThread(String url, HeadlessMediaPlayer mediaPlayer, String serverAddress, int serverPort, String suffix) {
//        this.url = url;
//        this.mediaPlayer = mediaPlayer;
//        this.serverAddress = serverAddress;
//        this.serverPort = serverPort;
//        this.suffix = suffix;
//    }
//
//    @Override
//    public void run() {
//        if (!this.isInterrupt) {
//            System.out.println(url + "开始运行");
//            try {
//
//                //不管摄像头的类型是什么，浏览器的网络协议就是http，所以全部按照http协议转换。
//                String options = formatHttpStream();
//
//                //此处针对不同的协议类型，发布的时候也需要附带不同的参数。
//                if (url.startsWith("http")) {
//                    mediaPlayer.playMedia(url, options, ":sout-ts-dts-delay=100", ":sout-all", ":sout-keep");
//                } else if (url.startsWith("rtsp") | url.startsWith("rtp")) {
//                    mediaPlayer.playMedia(url, options, ":no-sout-rtp-sap",
//                            ":sout-ts-dts-delay=100",
//                            ":no-sout-standard-sap",
//                            ":sout-all",
//                            ":sout-keep");
//                }
//            } catch (Exception e) {
//                System.out.println(url + "发布失败，从阻塞中退出...");
//            }
//        }
//    }
//    /**
//     * The proper way to stop the thread
//     */
//    @Override
//    public void interrupt() {
//        this.isInterrupt = true;
//        mediaPlayer.stop();
//        try {
//            super.interrupt();
//        } catch (Exception e) {
//            System.out.println("The thread has been interrupted.");
//        }
//    }
//
//}
