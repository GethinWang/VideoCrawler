//import com.sun.jna.Native;
//import com.sun.jna.NativeLibrary;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import uk.co.caprica.vlcj.binding.LibVlc;
//import uk.co.caprica.vlcj.player.MediaPlayerFactory;
//import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
//import uk.co.caprica.vlcj.runtime.RuntimeUtil;
//
//import java.io.IOException;
//import java.util.Date;
//
//public class Main {
//    public String getByString(String url) {
//        String responseBody = "";
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//
//        try {
//            HttpGet httpget = new HttpGet(url);
//            httpget.addHeader("Accept", "text/html");
//            httpget.addHeader("Accept-Charset", "utf-8");
//            httpget.addHeader("Accept-Encoding", "gzip");
//            httpget.addHeader("Accept-Language", "en-US,en");
//            httpget.addHeader("User-Agent",
//                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        HttpEntity entity = response.getEntity();
//                        System.out.println(status);
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        System.out.println(status);
//                        Date date = new Date();
//                        System.out.println(date);
//                        System.exit(0);
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//            };
//            responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println(responseBody);
//        } catch (Exception e) {
//            System.out.println("ERROR");
//        } finally {
//            return responseBody;
//        }
//    }
//    private HeadlessMediaPlayer mediaPlayer;
//    static MediaPlayerFactory mediaPlayerFactory;
//
//    public void test(){
//
//    }
//    public static void main(String[] args) throws Exception {
//
//        NativeLibrary.addSearchPath(
//                // 此处的路径是你安装vlc的路径加上sdk和lib下面会给出详细解释
//                RuntimeUtil.getLibVlcLibraryName(), "E:\\wuyuinfo\\Test\\lib");
//        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
//
//        mediaPlayerFactory = new MediaPlayerFactory(args);
//        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
//        mediaPlayer.playMedia("screen:// ", getMediaOptions("127.0.0.1", 5888));
//        Thread.currentThread().join();
//    }
//}
