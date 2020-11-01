package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Shape {
	
	
	// x,y = 마우스 시작 좌표 X,Y = 마우스 끝나는 좌표값
	int x, y, X, Y;
	public Color color;
	public Boolean paintMode = false;

	
	public Shape(int x, int y,int X, int Y, Color color, Boolean paint) {
		this.x = x;
		this.y = y;
		this.X = X;
		this.Y = Y;
		this.color = color;
		this.paintMode = paint;
	}
	
	public abstract void paint(Graphics g);
	
	
	public void moveBy(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
	
	public void moveTo(int newx, int newy, int newX, int newY) {
		x = newx;
		y = newy;
		X = newX;
		Y = newY;
	}
	
	public boolean isIn(int tx, int ty) {
		if(x <= tx && tx <= X) {
			if(y <= ty && ty <= Y) {
				return true;
			}
		}
		return false;
	}

	public int getx() {
		return x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public int gety() {
		return y;
	}

	public void sety(int y) {
		this.y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Boolean getPaintMode() {
		return paintMode;
	}

	public void setPaintMode(Boolean paintMode) {
		this.paintMode = paintMode;
	}
	

}
