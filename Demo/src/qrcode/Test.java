package qrcode;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //生成二维码
        /**
         * 生成图片路径
         * 文字信息，网址信息
         */
        String imgPath = "Demo/image/二维码.png";
        String content = "https://www.bilibili.com/video/BV1AE411x76z";
        String logoPath = "Demo/image/logo.png";
        /**
         * 加密 文字信息->二维码
         * 解密 二维码->文字信息
         */
         QRCodeUtil qrCodeUtil = new QRCodeUtil();
        try {
            qrCodeUtil.encoderQRCode(content,imgPath,"png",7,logoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
