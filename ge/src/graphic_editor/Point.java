package graphic_editor;

public class Point {
	private int start_x, start_y; // 시작 x,y
	private int d_x, d_y; // 드래그 x, y
	private int end_x, end_y; // 끝 x,y
	private int pre_x, pre_y; // 이전 x, y
	private int pre_X, pre_Y; // 이전 X, Y
	private int w, h; // 넓이와 높이
	
	public Point() {
	}
	
	// 사분면결정
	public int choiceQuadrant() {
		if(start_x == end_x && start_y == end_y) {
			return 5;
		}
		
		if( d_x > start_x && d_y < start_y) {
			// 1사분면
			return 1;
		} else if( d_x < start_x && d_y < start_y) {
			// 2사분면
			return 2;
		} else if( d_x < start_x && d_y > start_y) {
			// 3사분면
			return 3;
		} else {
			return 4;
		}
	}
	public void setW() {
		int choice = choiceQuadrant();
		switch(choice) {
		case 1:
			this.w = d_x - start_x;
			break;
		case 2:
			this.w = start_x - d_x;
			break;
		case 3:
			this.w = start_x - d_x;
			break;
		case 4:
			this.w = d_x - start_x;
			break;
		}
	}
	
	public void setH() {
		int choice = choiceQuadrant();
		switch(choice) {
		case 1:
			this.h = start_y - d_y;
			break;
		case 2:
			this.h = start_y - d_y;
			break;
		case 3:
			this.h = d_y - start_y;
			break;
		case 4:
			this.h = d_y - start_y;
			break;
		}
	}
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	

	public int getStart_x() {
		return start_x;
	}

	public void setStart_x(int start_x) {
		this.start_x = start_x;
	}

	public int getStart_y() {
		return start_y;
	}

	public void setStart_y(int start_y) {
		this.start_y = start_y;
	}

	public int getD_x() {
		return d_x;
	}

	public void setD_x(int d_x) {
		this.d_x = d_x;
	}

	public int getD_y() {
		return d_y;
	}

	public void setD_y(int d_y) {
		this.d_y = d_y;
	}

	public int getEnd_x() {
		return end_x;
	}

	public void setEnd_x(int end_x) {
		this.end_x = end_x;
	}

	public int getEnd_y() {
		return end_y;
	}

	public void setEnd_y(int end_y) {
		this.end_y = end_y;
	}

	public int getPre_x() {
		return pre_x;
	}

	public void setPre_x(int pre_x) {
		this.pre_x = pre_x;
	}

	public int getPre_y() {
		return pre_y;
	}

	public void setPre_y(int pre_y) {
		this.pre_y = pre_y;
	}
	
	
	public int getPre_X() {
		return pre_X;
	}

	public void setPre_X(int pre_X) {
		this.pre_X = pre_X;
	}

	public int getPre_Y() {
		return pre_Y;
	}

	public void setPre_Y(int pre_Y) {
		this.pre_Y = pre_Y;
	}
}
