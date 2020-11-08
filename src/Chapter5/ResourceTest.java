package Chapter5;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/8
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ResourceTest {

    public static void main(String[] args) throws IOException {
        Class cl = ResourceTest.class;
        URL aboutURL = cl.getResource("../Resources/img/xixi.jpg");
        var icon = new ImageIcon(aboutURL);

        InputStream stream = cl.getResourceAsStream("../Resources/txt/about.txt");
        var about = new String(stream.readAllBytes(), "UTF-8");

        InputStream stream2 = cl.getResourceAsStream("../Resources/txt/title.txt");
        var title = new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
