package com.po.utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img = null;

	/**
	 * take a screenshot full screen mode
	 */
	public ScreenShot() {
		this(380, 290, 120, 60);
	}

	/**
	 * take a screenshot from point (startingPointX,startingPointY) and with a
	 * "width" and "heigth" as defined
	 * 
	 * @param startingPointX
	 * @param startingPointY
	 * @param width
	 * @param heigth
	 */
	public ScreenShot(int startingPointX, int startingPointY, int width, int heigth) {
		ActionEvent ev = new ActionEvent(this, 1001, "show details");
		this.actionPerformed(ev);
	}

	/**
	 * Do not use this method from this class. Please use
	 * {@link #ScreenShot(int,int,int,int) createImage}
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// Toolkit class returns the default toolkit
		Toolkit tk = Toolkit.getDefaultToolkit();

		// Dimension class object stores width & height of the toolkit
		// screen
		// toolkit.getScreenSize() determines the size of the screen
		Dimension d = tk.getScreenSize();

		// Creates a Rectangle with screen dimensions, here we are
		// capturing the entire screen,if you want you can change it
		// accordingly (i.e you can also capture a particular area on
		// the screen)
		Rectangle rec = new Rectangle(0, 0, d.width, d.height);

		try {
			// a very important class to capture the screen image
			Robot ro = new Robot();

			// createScreenCapture() method takes Rectangle class instance
			// as argument and returns BufferedImage
			this.img = ro.createScreenCapture(rec);
		} catch (AWTException e1) {
			System.out.println(e1);
		}

	}

	/**
	 * Export the buffered Image to file
	 * 
	 * @param fileName
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	public boolean toFile(String fileName, String extension) throws IOException {

		if (this.img != null) {
			// File class is used to write the
			// above generated buffered
			// image to a file
			File f;
			f = new File(fileName);
			// ImageIO is an API which is used to convert BufferedImage to a
			// png/jpg image
			return ImageIO.write(img, extension, f);
		}
		return false;

	}

	public static void main(String[] args) {
		ScreenShot obj = new ScreenShot();

	}

}
