package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageCaptchaCode {
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 30;
	
	public static void main(String[] args){
		int width = DEFAULT_WIDTH;
		int height = DEFAULT_HEIGHT;
		//创建图片缓冲区
		BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics2D g = (Graphics2D) im.getGraphics();
		Random r = new Random();
		//设置随机背景
		g.setColor(new Color(255,255,r.nextInt(245) + 10));
//		g.setColor(Color.WHITE);
		//填充一个矩形 左上角坐标(0,0),宽width,高height;填充整张图片 
		g.fillRect(0, 0, width, height);
		//画边框
		//g.drawRect(0,0,width-1,height-1);
		//设置字体:字体、字号、大小 
		g.setFont(new Font("宋体",Font.BOLD,14)); 
		//设置背景颜色
		g.setColor(Color.BLACK);
		//向图片上写字符串 
		g.drawString("HelloWorld",10,20); 
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./a.jpg");
			ImageIO.write(im, "jpeg",fos);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
