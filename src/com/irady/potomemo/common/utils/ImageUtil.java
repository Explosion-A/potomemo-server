package com.irady.potomemo.common.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

/**
 * 1.对图片时行格式转换

 * 2.对图片进行适度的大小裁剪
 * 
 */
public class ImageUtil {

	/**
	 * 
	 * @param infile 输入文件
	 * @param outfile 输出文件
	 * @param srcFormat 源格式
	 * @param destFormat 输出格式
	 * @return
	 * @throws Exception
	 */
	public static boolean convertFormat(InputStream infile,
			OutputStream outfile, String srcFormat, String destFormat, int width ,int height) throws Exception {
		boolean flag = false;
		BufferedImage src = ImageIO.read(infile);
		if(height > 0  && width > 0) {// compress the origin image if width and height are non-zero
			height = src.getHeight() > height ? height: src.getHeight();
			width = src.getWidth() > width ? width : src.getWidth();
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);//这个是用来进行图片大小调整的
	
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
	
			Graphics g = tag.getGraphics();
			//可在下面对图片进行绘制和更改
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
	
			g.dispose();
			tag.flush();
			flag = ImageIO.write(tag, destFormat, outfile);// 输出到经过缩放的文件流
		} else {
			flag = ImageIO.write(src, destFormat, outfile);//输出原分辨率的图片
		}
		Logger.getLogger(ImageUtil.class).info("图片转换成功: 从[" + srcFormat + "]到[" + destFormat + "]");
		return flag;
	}
}