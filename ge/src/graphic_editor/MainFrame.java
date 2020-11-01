package graphic_editor;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	public static CanvasPanel canvasPanel = new CanvasPanel();
	private ButtonPanel buttonPanel;
	private ColorPanel colorPanel;
	private int frame_W = 1200; // 프레임 가로
	private int frame_H = 800; // 프레임 세로
	private MenuBar menuBar;

	private Point point = new Point(); // 좌표값 저장을 위한 객체

	public MainFrame() {
		setTitle("GraphicEditor");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frame_W, frame_H);
		setResizable(false); //창크기 제어 x
		setLocationRelativeTo(null); //가운데정렬
		getContentPane().setLayout(null);

		// buttonPanel add
		buttonPanel = new ButtonPanel();
		getContentPane().add(buttonPanel);

		// canvasPanel add
		getContentPane().add(canvasPanel);

		// colorPanel add
		colorPanel = new ColorPanel();
		getContentPane().add(colorPanel);
		
		// 메뉴바 생성
		menuBar = new MenuBar();
		setJMenuBar(menuBar);

		setVisible(true);
	}
	
}
