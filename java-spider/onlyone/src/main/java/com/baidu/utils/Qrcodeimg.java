package com.baidu.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class Qrcodeimg {

	public static int createQRCode(String content, String imgPath,
			String ccbPath) {
		try {
			Qrcode qrcodeHandler = new Qrcode();

			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			qrcodeHandler.setQrcodeVersion(7);

			byte[] contentBytes = content.getBytes("gb2312");

			BufferedImage bufImg = new BufferedImage(150, 150,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 200, 200);

			gs.setColor(Color.black);

			int pixoff = 2;

			if (contentBytes.length > 0 && contentBytes.length < 120) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = "
						+ contentBytes.length + " not in [ 0,120 ]. ");
				return -1;
			}
			Image img = ImageIO.read(new File(ccbPath));

			gs.drawImage(img, 44, 44, 70, 70, null);
			gs.dispose();
			bufImg.flush();

			File imgFile = new File(imgPath);
			ImageIO.write(bufImg, "png", imgFile);
		} catch (Exception e) {
			e.printStackTrace();
			return -100;
		}
		return 0;
	}

	public static void main(String[] args) {

		String imgPath = "D:/1/aa.png";

		String content = "1111";
		String ccbPath = "D:/1/J0302953.JPG";
		Qrcodeimg qrcodeimg = new Qrcodeimg();
		qrcodeimg.createQRCode(content, imgPath, ccbPath);

	}

}
