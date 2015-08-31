import java.awt.image.*;

import java.io.IOException;
import java.io.File;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.sound.sampled.LineUnavailableException;

//The SoundUtils class isn't written by meowzie

public class ImageToMusic {
	public static void main(String[] args) throws IOException, LineUnavailableException{
	    BufferedImage image = ImageIO.read(new File("what.bmp"));
		
		for (int y = 0; y < image.getWidth(); y++)
		{
			for (int x = 0; x < image.getHeight(); x++)
			{
				int clr = image.getRGB(x, y); //the color - 2^24
				System.out.println(clr);
				
				int red   = (clr & 0x00ff0000) >> 16;
				int green = (clr & 0x0000ff00) >> 8;
				int blue  =  clr & 0x000000ff;
				image.setRGB(x, y, clr); //??
				
				SoundUtils.tone(clr, 1000, 1.0); // 1 pixel / 500ms == 2 pixels / 1 sec
			}
		}
	}
}
