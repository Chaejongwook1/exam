package Shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	public Rect(int x, int y, int w, int h,Color color,Boolean paint ) {
		super(x,y, x+w, y+h, color, paint);
	}

	public void paint(Graphics gbuf) {
		gbuf.setColor(this.color);
		if(paintMode == false) {
			gbuf.drawRect(x, y, X-x, Y-y);
		} else if(paintMode == true) {
			gbuf.fillRect(x, y, X-x, Y-y);
		}
	}
}
