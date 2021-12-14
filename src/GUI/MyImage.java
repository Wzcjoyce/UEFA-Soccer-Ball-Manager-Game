package GUI;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * class for adding image to view
 * this is modified from GUI ICE
 * go through during class
 */
@SuppressWarnings("serial")
class MyImage extends JPanel{
	private BufferedImage imgs;

	
	/**
	 * constructor of MyImage class
	 * @param x
	 * @param y
	 */
	public MyImage(int x, int y){
		super();
		imgs = new BufferedImage(x, y, BufferedImage.TYPE_4BYTE_ABGR_PRE);
	}
	
	public void addPicture(String filename){

		try {
			imgs = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.err.println("Unable to read the file: " + filename);
		}
		
	}
	
	@Override
	public void paint(Graphics g){

		g.drawImage(imgs, 0, 0, null);
		

	}
}