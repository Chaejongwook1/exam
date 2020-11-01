package graphic_editor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class ColorPanel extends JPanel implements ActionListener, MouseListener {
	public static Color colorMode = new Color(0,0,0);
	private JButton redButton;
	private JButton orangeButton;
	private JButton greenButton;
	private JButton blueButton;
	private JButton pinkButton;
	private JButton blackButton;
	private JButton whiteButton;
	private JButton moreButton;
	private JLabel currentColor;
	
	public ColorPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setBounds(469, 0, 715, 85);
		setButton();
	}
	
	public void setButton() {
		redButton = new JButton();
		redButton.setBorderPainted(false);
		redButton.setBackground(Color.RED);
		redButton.setBounds(12, 10, 64, 64);
		redButton.addActionListener(this);
		redButton.addMouseListener(this);
		add(redButton);
		
		orangeButton = new JButton();
		orangeButton.setBorderPainted(false);
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setBounds(88, 10, 64, 64);
		orangeButton.addActionListener(this);
		orangeButton.addMouseListener(this);
		add(orangeButton);
		
		greenButton = new JButton();
		greenButton.setBorderPainted(false);
		greenButton.setBackground(Color.GREEN);
		greenButton.setBounds(164, 10, 64, 64);
		greenButton.addActionListener(this);
		greenButton.addMouseListener(this);
		add(greenButton);
		
		blueButton = new JButton();
		blueButton.setBorderPainted(false);
		blueButton.setBackground(Color.BLUE);
		blueButton.setBounds(240, 10, 64, 64);
		blueButton.addActionListener(this);
		blueButton.addMouseListener(this);
		add(blueButton);
		
		pinkButton = new JButton();
		pinkButton.setBorderPainted(false);
		pinkButton.setBackground(Color.PINK);
		pinkButton.setBounds(316, 10, 64, 64);
		pinkButton.addActionListener(this);
		pinkButton.addMouseListener(this);
		add(pinkButton);
		
		blackButton = new JButton();
		blackButton.setBorderPainted(false);
		blackButton.setBackground(Color.BLACK);
		blackButton.setBounds(392, 10, 64, 64);
		blackButton.addActionListener(this);
		blackButton.addMouseListener(this);
		add(blackButton);
		
		whiteButton = new JButton();
		whiteButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteButton.setBackground(Color.WHITE);
		whiteButton.setBounds(468, 10, 64, 64);
		whiteButton.addActionListener(this);
		whiteButton.addMouseListener(this);
		add(whiteButton);
		
		moreButton = new JButton(new ImageIcon("./images/moreButton.png"));
		moreButton.setBackground(Color.WHITE);
		moreButton.setBorderPainted(false);
		moreButton.setBounds(544, 10, 64, 64);
		moreButton.addActionListener(this);
		moreButton.addMouseListener(this);
		add(moreButton);
		
		currentColor = new JLabel("Current");
		currentColor.setHorizontalAlignment(SwingConstants.CENTER);
		currentColor.setOpaque(true);
		currentColor.setBackground(colorMode);
		currentColor.setBounds(635, 10, 64, 64);
		add(currentColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(redButton)) {
			colorMode = Color.RED;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(orangeButton)) {
			colorMode = Color.ORANGE;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(greenButton)) {
			colorMode = Color.GREEN;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(blueButton)) {
			colorMode = Color.BLUE;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(pinkButton)) {
			colorMode = Color.PINK;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(blackButton)) {
			colorMode = Color.BLACK;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(whiteButton)) {
			colorMode = Color.WHITE;
			currentColor.setBackground(colorMode);
		} else if(e.getSource().equals(moreButton)) {
			colorMode = JColorChooser.showDialog(null,"Color",Color.YELLOW);
			currentColor.setBackground(colorMode);
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
		JButton button = (JButton)e.getSource();
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
