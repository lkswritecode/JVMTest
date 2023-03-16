package qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class QRCodeUtil {

    /**
     * 加密 文字信息->二维码
     * @param content 文字信息/网站
     * @param imgPath 二维码生成位置
     * @param imgType 图片类型
     * @param size 图片大小
     */
    public void encoderQRCode(String content,String imgPath,String imgType,int size,String logoPath) throws IOException {
        //文件生成路径
        File file = new File(imgPath);
        //类存中的图片
        BufferedImage renderedImage = getBufferedImage(content,imgType,size,logoPath);
        ImageIO.write(renderedImage,imgType,file);
    }

    /**
     *
     * @param content 图片中的信息
     * @param imgType 图片类型
     * @param size  图片大小
     * @return
     */
    private BufferedImage getBufferedImage(String content,String imgType,int size,String logoPath) throws IOException {
        BufferedImage bufferedImage = null;
        Qrcode qrCodeHandler = new Qrcode();
        //设置二维码排错率 L<M<Q<H ,排错率越高，放的信息越少，对二维码清晰图越小
        qrCodeHandler.setQrcodeErrorCorrect('M');
        //存放类型 N:数字 A:数字+A-Z B:所有
        qrCodeHandler.setQrcodeEncodeMode('B');
        //尺寸：范围1-40
        qrCodeHandler.setQrcodeVersion(size);
        byte [] qrCodebytes =  content.getBytes("UTF-8");
        //二维码的二维数组
        boolean[][] codeOut = qrCodeHandler.calQrcode(qrCodebytes);
        //放大图片
        int imgSize = 67 + 12*(size - 1);
        //BufferedImage.TYPE_INT_RGB计算机三原色 红 绿 蓝 （RGB）
        bufferedImage = new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_RGB);
        //创建画板
        Graphics2D graphics = bufferedImage.createGraphics();
        //设置图片背景颜色
        graphics.setBackground(Color.WHITE);
        //设置白色背景面积 x:0左上角横坐标 y:0 左上角纵坐标
        graphics.clearRect(0,0,imgSize,imgSize);
        //设置图片颜色
        graphics.setColor(Color.BLACK);
        //偏移，每个小黑格之间的空隙
        int pixoff = 2;
        for (int i = 0; i < codeOut.length; i++) {
            for (int j = 0; j < codeOut.length; j++) {
                if(codeOut[i][j]){
                    //每个小黑格位置与大小
                    graphics.fillRect(i*3+pixoff,j*3+pixoff,3,3);
                }
            }
        }

        if(logoPath!=null&&!Objects.equals("",logoPath)){
            //增加logo
            Image logo = ImageIO.read(new File(logoPath));
            int maxHeight = bufferedImage.getHeight();
            int maxWidth = bufferedImage.getWidth();
            //logo位置与大小
            graphics.drawImage(logo,imgSize/5*2,imgSize/5*2,maxHeight/5,maxWidth/5,null);
        }

        //释放空间
        graphics.dispose();
        //将管道中的数据压入内存,也叫清理
        bufferedImage.flush();
        return  bufferedImage;
    }
    //解密 二维码->文字信息
    public String decoderQRCode(String imagePath) throws IOException {
        //将硬盘中的图片加入到内存中
        BufferedImage read = ImageIO.read(new File(imagePath));
       // new QRCodeDecoder();
        return  null;
    }
}
