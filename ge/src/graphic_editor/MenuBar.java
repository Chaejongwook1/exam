package graphic_editor;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import java.awt.FileDialog;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar implements ActionListener{
		
	private JMenu fileMenu;
	private JMenuItem newItem;
	private JMenuItem saveItem;
	private JMenuItem loadItem;
	private JMenuItem exitItem;
	public static Boolean loadTrigger = false;
	
	public MenuBar() {
		
		fileMenu = new JMenu("File");
		add(fileMenu);
		
		newItem = new JMenuItem("New");
		newItem.addActionListener(this);
		fileMenu.add(newItem);
		
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);
		
		
		loadItem = new JMenuItem("Load");
		loadItem.addActionListener(this);
		fileMenu.add(loadItem);		
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		fileMenu.add(exitItem);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(newItem)) {
			
			CanvasPanel.bi = new BufferedImage(1184, 655, BufferedImage.TYPE_INT_ARGB);
			loadTrigger = false;
			MainFrame.canvasPanel.resetVector();
		} else if(e.getSource().equals(saveItem)) {
			try {
				
				JFrame frame = null;
				FileDialog dl= new FileDialog(frame, "저장", FileDialog.SAVE);
				dl.setVisible(true);
				String path = dl.getDirectory() + dl.getFile();
				
				MainFrame.canvasPanel.drawBuffer(); // 버퍼에 이미지 그리기
				
				if(dl.getFile() != null) {
					System.out.println(path);
					ImageIO.write(CanvasPanel.bi, "png", new File(path + ".png")); 
				}
			} catch (IOException e1) {
				e1.printStackTrace(); 
            }  
		} else if(e.getSource().equals(loadItem)) {
			try {
				
				JFrame frame = null;
				FileDialog dl= new FileDialog(frame, "불러오기", FileDialog.LOAD);
				dl.setVisible(true);
				String path = dl.getDirectory() + dl.getFile();
				if(dl.getFile() != null) {
					loadTrigger = true;
					CanvasPanel.bi = ImageIO.read(new File(path));
					MainFrame.canvasPanel.resetVector();
					MainFrame.canvasPanel.repaint();
				}
			}
            catch (Exception e1) { e1.printStackTrace(); } 
		} else if(e.getSource().equals(exitItem)) {
			System.exit(1);
		}
	}
}
