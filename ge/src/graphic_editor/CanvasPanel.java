package graphic_editor;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Shape.Shape;
import Shape.Circle;
import Shape.Rect;

import java.awt.event.MouseEvent;

import static graphic_editor.ButtonPanel.buttonMode;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	 public static int canvas_W = 1184;
 	 public static int canvas_H = 651;	
  	 public static BufferedImage bi = new BufferedImage(CanvasPanel.canvas_W, CanvasPanel.canvas_H, BufferedImage.TYPE_INT_ARGB);
	 private Point point;
	 private Vector<Shape> s;
	 private Boolean dragTrigger = false;
	 int targetNum = -1;
	 
	 
	public CanvasPanel() {
		s = new Vector<Shape>(); 
		setBackground(Color.WHITE);
		setBounds(0, 85, canvas_W, canvas_H);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		
		if(MenuBar.loadTrigger == true) { // 로드 트리거가 true이면 로드된 이미지를 버퍼에 초기화해줌 // 드래그할때를 위해서
			g.drawImage(bi,0,0,this);
		}


		for(int i = 0; i < s.size(); i++) {
			Shape s1 = s.elementAt(i);
			s1.paint(g);
		}
		
		if(dragTrigger == true) { // 드래그일때만 작동
			update(g);
		}
	}
	
	
	public void drawBuffer() {
		Graphics g;
		g = bi.getGraphics();
		for(int i = 0; i < s.size(); i++) {
			s.elementAt(i).paint(g);
		}
	} 
	
	public void update(Graphics g) {
		dragDraw(g);
	}
	
	public void dragDraw(Graphics g) {
		if(buttonMode == 1) { 
			g.setColor(ColorPanel.colorMode);
			int choice = point.choiceQuadrant();
			switch(choice) {
			case 1:
				g.drawOval(point.getStart_x(), point.getD_y()
						, point.getW(), point.getH());
				break;
			case 2:
				g.drawOval(point.getD_x(), point.getD_y()
						, point.getW(), point.getH());
				break;
			case 3:
				g.drawOval(point.getD_x(), point.getStart_y()
						, point.getW(), point.getH());
				break;
			case 4:
				g.drawOval(point.getStart_x(), point.getStart_y()
						, point.getW(), point.getH());
				break;
			}
		} else if(buttonMode == 2) {
			g.setColor(ColorPanel.colorMode);
			int choice = point.choiceQuadrant();
			switch(choice) {
			case 1:
				g.drawRect(point.getStart_x(), point.getD_y()
						, point.getW(), point.getH());
				break;
			case 2:
				g.drawRect(point.getD_x(), point.getD_y()
						, point.getW(), point.getH());
				break;
			case 3:
				g.drawRect(point.getD_x(), point.getStart_y()
						, point.getW(), point.getH());
				break;
			case 4:
				g.drawRect(point.getStart_x(), point.getStart_y()
						, point.getW(), point.getH());
				break;
			}
		} else if(buttonMode == 3 && targetNum != -1) {
			s.elementAt(targetNum).moveTo(point.getPre_x()+(point.getD_x() - point.getStart_x())
					, point.getPre_y()+(point.getD_y() - point.getStart_y())
					, point.getPre_X()+(point.getD_x() - point.getStart_x())
					, point.getPre_Y()+(point.getD_y() - point.getStart_y()));
		} else if(buttonMode == 4 && targetNum != -1) {
			s.elementAt(targetNum).moveTo(point.getPre_x()+(point.getD_x() - point.getStart_x())
					, point.getPre_y()+(point.getD_y() - point.getStart_y())
					, point.getPre_X()+(point.getD_x() - point.getStart_x())
					, point.getPre_Y()+(point.getD_y() - point.getStart_y()));
		}
	}
	
	public void add(Shape s1) {
		s.add(s1);
		repaint();
	}
	
	public void resetVector() {
		s.clear();
		repaint();
	}
	
	//마우스 클릭 후 도형 찾는 함수
	public int findIndex(int dx, int dy) {
		for(int i = s.size() - 1; i >= 0; i--) {
			if(s.elementAt(i).isIn(dx, dy)) {
				return i; // 찾으면 찾은 벡터의 인덱스 반환
			}
		}
		return -1; // 못찾은 경우
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		dragTrigger = true;
		point.setD_x(e.getX());
		point.setD_y(e.getY());
		point.setW();
		point.setH();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		point = new Point();
		point.setStart_x(e.getX());
		point.setStart_y(e.getY());
		targetNum = findIndex(point.getStart_x(), point.getStart_y());
		switch(buttonMode) {
		case 3: // cursor
			if(targetNum != -1 ) {
				point.setPre_x(s.elementAt(targetNum).getx());
				point.setPre_y(s.elementAt(targetNum).gety());
				point.setPre_X(s.elementAt(targetNum).getX());
				point.setPre_Y(s.elementAt(targetNum).getY());
			} else if(targetNum == -1) {
				System.out.println("범위안에 x");
			}
			break;
		case 4: // copy
			if(targetNum != -1 ) {
				point.setPre_x(s.elementAt(targetNum).getx());
				point.setPre_y(s.elementAt(targetNum).gety());
				point.setPre_X(s.elementAt(targetNum).getX());
				point.setPre_Y(s.elementAt(targetNum).getY());
				if(s.elementAt(targetNum) instanceof Circle) {
					if(s.elementAt(targetNum).paintMode == true) {
						add(new Circle(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),
								s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety(), 
								ColorPanel.colorMode, s.elementAt(targetNum).paintMode));
					} else if(s.elementAt(targetNum).paintMode == false) {
						add(new Circle(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),
								s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety(), 
								ColorPanel.colorMode, s.elementAt(targetNum).paintMode));
					}
				} else if(s.elementAt(targetNum) instanceof Rect) {
					if(s.elementAt(targetNum).paintMode == true) {
						add(new Rect(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),
								s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety(), 
								ColorPanel.colorMode, s.elementAt(targetNum).paintMode));
					} else if(s.elementAt(targetNum).paintMode == false) {
						add(new Rect(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),
								s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety(), 
								ColorPanel.colorMode, s.elementAt(targetNum).paintMode));
					}
				}
			} else if(targetNum == -1) {
				System.out.println("범위안에 x");
			}
			break;
		case 5: // fill
			if(targetNum != -1) { //찾은경우
				s.elementAt(targetNum).paintMode = true;
				s.elementAt(targetNum).color = ColorPanel.colorMode;
				repaint();
			} else if( targetNum == -1) { // 못찾은 경우
				System.out.println("못찾음");
				return;
			}
			break;
		case 6:
			if(targetNum != -1) { //찾은경우
					s.remove(targetNum);
					repaint();
				} else if( targetNum == -1) { // 못찾은 경우
					System.out.println("못찾음");
					return;
				}
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		point.setEnd_x(e.getX());
		point.setEnd_y(e.getY());
		point.setW();
		point.setH();
		if(buttonMode == 1) {
			int choice = point.choiceQuadrant();
			switch(choice) {
				case 1:
					add(new Circle(point.getStart_x(), point.getEnd_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 2:
					add(new Circle(point.getEnd_x(), point.getEnd_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 3:
					add(new Circle(point.getEnd_x(), point.getStart_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 4:
					add(new Circle(point.getStart_x(), point.getStart_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 5: // 시작좌표와 끝좌표가 같은경우 추가 x
					System.out.println("제자리");
					break;
			}
		} else if(buttonMode == 2) {
			int choice = point.choiceQuadrant();
			switch(choice) {
				case 1:
					add(new Rect(point.getStart_x(), point.getEnd_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 2:
					add(new Rect(point.getEnd_x(), point.getEnd_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 3:
					add(new Rect(point.getEnd_x(), point.getStart_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 4:
					add(new Rect(point.getStart_x(), point.getStart_y()
							, point.getW(), point.getH(), ColorPanel.colorMode,false));
					break;
				case 5:
					System.out.println("제자리");
					break;
			}
		}
		dragTrigger = false;
		targetNum = -1;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
