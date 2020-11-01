package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Circle extends Shape {
	public Circle(int x, int y, int w, int h, Color color, Boolean paint) {
		super(x,y, x+w, y+h, color, paint);
	}
	
	public void paint(Graphics g) {
		g.setColor(this.color);
		if(paintMode == false) {
			g.drawOval(x, y, X-x, Y-y);
		} else if(paintMode == true) {
			g.fillOval(x, y, X-x, Y-y);
		}
	}
	
}
