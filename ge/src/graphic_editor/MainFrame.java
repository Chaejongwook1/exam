package graphic_editor;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	public static CanvasPanel canvasPanel = new CanvasPanel();
	private ButtonPanel buttonPanel;
	private ColorPanel colorPanel;
	private int frame_W = 1200; // ������ ����
	private int frame_H = 800; // ������ ����
	private MenuBar menuBar;

	private Point point = new Point(); // ��ǥ�� ������ ���� ��ü

	public MainFrame() {
		setTitle("GraphicEditor");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frame_W, frame_H);
		setResizable(false); //âũ�� ���� x
		setLocationRelativeTo(null); //�������
		getContentPane().setLayout(null);

		// buttonPanel add
		buttonPanel = new ButtonPanel();
		getContentPane().add(buttonPanel);

		// canvasPanel add
		getContentPane().add(canvasPanel);

		// colorPanel add
		colorPanel = new ColorPanel();
		getContentPane().add(colorPanel);
		
		// �޴��� ����
		menuBar = new MenuBar();
		setJMenuBar(menuBar);

		setVisible(true);
	}
	
}
