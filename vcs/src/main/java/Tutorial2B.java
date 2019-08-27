import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

public class Tutorial2B {

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tutorial2B();
            }
        });
    }

    private Tutorial2B() {
        JFrame frame = new JFrame("vlcj Tutorial");

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

        frame.setContentPane(mediaPlayerComponent);

        frame.setLocation(100, 100);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia("http://play1.cp21.ott.cibntv.net/play.videocache.lecloud.com/272/22/102/letv-uts/14/ver_00_22-1123871936-avc-417795-aac-48000-3287640-196452287-89a4b5953aa35de0031889c3b1f3aa1a-1566185393111.m3u8?crypt=5aa7f2e179&b=478&nlh=4096&nlt=60&bf=30&p2p=1&video_type=mp4&termid=1&tss=ios&platid=1&splatid=105&its=0&qos=3&fcheck=0&amltag=6&mltag=6&uid=2029267263.rp&keyitem=GOw_33YJAAbXYE-cnQwpfLlv_b2zAkYctFVqe5bsXQpaGNn3T1-vhw..&ntm=1566239400&nkey=9f32af01a98ce32206d74f1de6534700&nkey2=537bb7f30147f17746ec3a6bc1f922fd&auth_key=1566239400-1-0-1-105-cabab867b0cd4ac4157184ac27770306&geo=CN-19-0-4&mmsid=67027785&tm=1566221343&key=e00aa7d131614d69063ce1ee732ad4bb&playid=0&vtype=13&cvid=2017868547708&payff=0&m3v=1&hwtype=un&ostype=Windows10&p1=1&p2=10&p3=-&tn=0.32786001916974783&vid=31623333&uuid=8486086421CF7587EDF17CA04B19F73F991C3A07_0&sign=letv&uidx=0&errc=0&gn=50047&ndtype=2&vrtmcd=102&buss=6&cips=120.244.41.63&r=1566221352582&appid=500");// please change it to an existed media file
    }
}

