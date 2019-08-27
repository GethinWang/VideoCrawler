package simplePlayer;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;
import java.awt.*;

public class PlayerRunnable {

    static {
        String libPath = PlayerRunnable.class.getResource("").getPath().substring(1).replace("target/classes/simplePlayer/","src/main/resources");
        NativeLibrary.addSearchPath(
                // libvlc.dll和libvlccore的路径
                RuntimeUtil.getLibVlcLibraryName(), libPath);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }

    static ViewFrame frame;

    String url = "";

    void paly() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewFrame();
                    frame.setVisible(true);

                    frame.getMediaPlayer().playMedia(url);
                    new SwingWorker<String, Integer>() {
                        @Override
                        protected String doInBackground() throws Exception {
                            while (true) {
                                long total = frame.getMediaPlayer().getLength();
                                long curr = frame.getMediaPlayer().getTime();
                                float percent = (float) curr / total;
                                publish((int) (percent * 100));
                                Thread.sleep(100);
                            }
                        }
                        protected void process(java.util.List<Integer> chunks) {
                            for (int v : chunks) {
                                frame.getProgressBar().setValue(v);
                            }
                        };
                    }.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 播放按钮
    public static void play() {
        frame.getMediaPlayer().play();
    }

    // 暂停按钮
    public static void pause() {
        frame.getMediaPlayer().pause();
    }

    // 停止按钮
    public static void stop() {
        frame.getMediaPlayer().stop();
    }

    // 跳转按钮
    public static void jumpTo(float to) {
        frame.getMediaPlayer().setTime((long) (to * frame.getMediaPlayer().getLength()));
    }

    // 音量按钮
    public static void setvol(int v) {
        frame.getMediaPlayer().setVolume(v);
    }

    public PlayerRunnable(String url) {
        this.url = url;
    }
}

