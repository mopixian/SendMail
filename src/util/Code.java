package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Code {
	
	private BufferedImage image;

	private String code;
	
	private char [] CODE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
	
	private Code(){
		init();
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public static Code getInstance(){
		return new Code();
	}
	
	private void init(){
		int width = 85;
		int height = 20;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics g = image.getGraphics();
		
		Random random = new Random();
		
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		g.setColor(getRandColor(160, 200));
		
		for(int i = 0; i < 155; i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			
			g.drawLine(x, y, x1, y1);
		}
		
		String s = "";
		for(int i = 0; i < 4; i++){
			String rand = String.valueOf(CODE[random.nextInt(CODE.length)]);
			s += rand;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13*i + 6, 16);
		}
		
		this.code = s;
		
		g.dispose();
		
		this.image = image;
		
	}
	
	private Color getRandColor(int fc, int bc){	
		Random random = new Random();
		if(fc > 255){
			fc = 255;
		}
		if(bc > 255){
			bc = 255;
		}
		
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		
		return new Color(r, g, b);
	}
}
