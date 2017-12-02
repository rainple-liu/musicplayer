package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;

public class PlayList extends JPanel implements ActionListener {
	// 界面上各组件
	private JPanel contentPane;
	private JLabel ListLabel;
	private JButton addBtn;
	private JList<String> musicList;
	private JButton deleteBtn;
	// 保存所有音乐文件
	private ArrayList<File> allFile = new ArrayList<File>();
	// 保存名称
	private ArrayList<String> musicName = new ArrayList<String>();
	// 记录列表选择的位置 与上面两个list对应
	private int chooseIndex;


//	public static void main(String[] args) {
//		PlayList frame = new PlayList();
//		frame.setVisible(true);
//	}

	/**
	 * 构造函数 初始化组件位置及大小
	 */
	public PlayList() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(null);

		ListLabel = new JLabel("播放列表");
		ListLabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
//		ListLabel.setBounds(14, 16, 107, 28);
		contentPane.add(ListLabel);

		addBtn = new JButton("添加音乐");
		addBtn.setBackground(Color.WHITE);
		addBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
//		addBtn.setBounds(180, 17, 90, 30);
		addBtn.addActionListener(this);
        contentPane.add(addBtn);

		deleteBtn = new JButton("删除音乐");
		deleteBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		deleteBtn.setBackground(Color.WHITE);
//		deleteBtn.setBounds(287, 17, 90, 30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		contentPane.add(deleteBtn);
		
		initList();
		//给list加点击监听 选择某个元素就记录当前选择元素的下标
		musicList = new JList<String>(musicName.toArray(new String[] {}));
		musicList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				chooseIndex = musicList.getSelectedIndex();
				deleteBtn.setEnabled(true);

			}
		});

		musicList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		musicList.setForeground(Color.DARK_GRAY);
		musicList.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(musicList);
//		scrollPane.setBounds(14, 63, 365, 520);
		contentPane.add(scrollPane);
//		this.setResizable(false);
	}
	
/**
 * 从文件夹获取所有已存在的音乐文件
 */
	private void initList() {
		musicName.clear();
		allFile.clear();
		File f = new File("Music");
		//如果这个文件夹不存在就创建文件夹
		if (!f.exists()) {
			f.mkdirs();
		} else {
			//得到文件夹里的所有文件
			File fa[] = f.listFiles();
			for (int i = 0; i < fa.length; i++) {
				File fs = fa[i];
				if (!fs.isDirectory()) {
					//得到文件名和文件类型后缀
					String name = fs.getName().substring(0, fs.getName().indexOf("."));
					String type = fs.getName().substring(fs.getName().indexOf(".") + 1);
					if (type.toLowerCase().equals("mp3") || type.toLowerCase().equals("wav")) {
						musicName.add(name);
						allFile.add(fs);
					}
				}
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//如果点击删除按钮
		if (obj == deleteBtn) {
			//根据选择的下标得到文件
			File f = allFile.get(chooseIndex);
			//删除文件夹里的文件
			f.delete();
			//从集合中删除
			allFile.remove(chooseIndex);
			musicName.remove(chooseIndex);
			//更新jlist显示的东西
			musicList.removeAll();
			ListModel<String> model = new DefaultComboBoxModel(musicName.toArray(new String[] {}));
			musicList.setModel(model);
			//设置删除按钮不可选中(只有你选择了具体的音乐之后才可选)
			deleteBtn.setEnabled(false);
		} else {
			//添加按钮
			//打开文件选择器
			JFileChooser chooser = new JFileChooser();
			//设置选择器 只能选择具体的类型(这里是mp3 和 wav)
			myFileFilter filter = new myFileFilter();
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			chooser.showDialog(new JLabel(), "选择");
			//得到选择的文件
			File f = chooser.getSelectedFile();
			if (f == null)
				return;
			String endPath = new File("Music").getAbsolutePath() + "/" + f.getName();
			//将这个文件移动到music文件夹下
			f.renameTo(new File(endPath));
			//更新集合
			initList();
			musicList.removeAll();
			//更新jlist选择的元素
			ListModel<String> model = new DefaultComboBoxModel(musicName.toArray(new String[] {}));
			musicList.setModel(model);
		}
	}
	
/**
 * 设置文件选择器选择的类型
 */
	class myFileFilter extends FileFilter {
		public String getDescription() {
			return "*.mp3;*.wav";
		}

		public boolean accept(File file) {
			String name = file.getName();
			return file.isDirectory() || name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav");
		}
	}
}