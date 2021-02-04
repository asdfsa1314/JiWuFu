import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class WuFu {


    public static void main(String[] args) throws Exception {

        String[] arr={"Microsoft JhengHei","Microsoft YaHei","MingLiU、PMingLiU","MS Mincho, MS PMincho","NSimSun","SimHei","SimKai","SimSun"};
        Random r = new Random();
        createImage("福", new Font(arr[r.nextInt(arr.length)], Font.PLAIN, 100), new File(
                "C:\\Users\\asdfsa\\Desktop\\asdfsa.png"), 250, 250);

    }

    public static void createImage(String str, Font font, File outFile,
                                   Integer width, Integer height) throws Exception {
        Random r = new Random();
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(new Color(r.nextInt(255), r.nextInt(255),r.nextInt(255)));
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景
        g.setColor(new Color(r.nextInt(255), r.nextInt(255),r.nextInt(255)));// 在换成黑色
        g.setFont(font);// 设置画笔字体
        /** 用于获得垂直居中y */
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;
        for (int i = 0; i < 6; i++) {// 256 340 0 680
            g.drawString(str, i * 680, y);// 画出字符串
        }
        g.dispose();
        ImageIO.write(image, "png", outFile);// 输出png图片
    }

}
