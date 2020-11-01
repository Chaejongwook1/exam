package graphic_editor;

import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ButtonPanel extends JPanel implements ActionListener, MouseListener {
		JButton circleButton;
		JButton rectButton;
		JButton paintButton;
		JButton cursorButton;
		JButton copyButton;
		JButton removeButton;
		static int buttonMode = 1;
		
	public ButtonPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setBounds(0, 0, 470, 85);
		setButton();
	}
	
	public void setButton() {
		
		circleButton = new JButton("");
		circleButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		circleButton.setBackground(Color.WHITE);
		circleButton.setIcon(new ImageIcon("./images/CircleButton.png"));
		circleButton.setBounds(12, 10, 64, 64);
		circleButton.addActionListener(this);
		circleButton.addMouseListener(this);
		add(circleButton);
		

		rectButton = new JButton("");
		rectButton.setBackground(Color.WHITE);
		rectButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		rectButton.setIcon(new ImageIcon("./images/RectButton.png"));
		rectButton.setBounds(88, 10, 64, 64);
		rectButton.addActionListener(this);
		rectButton.addMouseListener(this);
		add(rectButton);
		
		paintButton = new JButton("");
		paintButton.setBackground(Color.WHITE);
		paintButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		paintButton.setIcon(new ImageIcon("./images/PaintButton.png"));
		paintButton.setBounds(318, 10, 64, 64);
		paintButton.addActionListener(this);
		paintButton.addMouseListener(this);
		add(paintButton);
		
		cursorButton = new JButton("");
		cursorButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cursorButton.setBackground(Color.WHITE);
		cursorButton.setIcon(new ImageIcon("./images/CursorButton.png"));
		cursorButton.setBounds(164, 10, 64, 64);
		cursorButton.addActionListener(this);
		cursorButton.addMouseListener(this);
		add(cursorButton);
		
		copyButton = new JButton("");
		copyButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		copyButton.setBackground(Color.WHITE);
		copyButton.setIcon(new ImageIcon("./images/CopyButton.png"));
		copyButton.setBounds(240, 10, 64, 64);
		copyButton.addActionListener(this);
		copyButton.addMouseListener(this);
		add(copyButton);
		
		removeButton = new JButton("");
		removeButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		removeButton.setBackground(Color.WHITE);
		removeButton.setIcon(new ImageIcon("./images/RemoveButton.png"));
		removeButton.setBounds(394, 10, 64, 64);
		removeButton.addActionListener(this);
		removeButton.addMouseListener(this);
		add(removeButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(circleButton)) {
			buttonMode = 1;
		} else if(e.getSource().equals(rectButton)) {
			buttonMode = 2;
		} else if(e.getSource().equals(cursorButton)) {
			buttonMode = 3;
		} else if(e.getSource().equals(copyButton)) {
			buttonMode = 4;
		} else if(e.getSource().equals(paintButton)) {
			buttonMode = 5;
		} else if(e.getSource().equals(removeButton)) {
			buttonMode = 6;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		
		JButton button = (JButton)e.getSource();
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
