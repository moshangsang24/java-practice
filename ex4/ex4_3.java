import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* CLASS
*@name:ex4_3
*@description:主类，用于构造整个程序
*/    
public class ex4_3 {
	
	public JFrame f=new JFrame("记事本");
	private JTextArea tf=new JTextArea();
	private JMenuBar bar1=new JMenuBar();
	private JLabel lblStatus;
	/*******************************************/
	private JMenu menu1=new JMenu("文件(F)");
	private JMenuItem newf=new JMenuItem("新建");
	private JMenuItem open=new JMenuItem("打开");
	private JMenuItem save=new JMenuItem("保存");
	private JMenuItem quit=new JMenuItem("退出");
	/*******************************************/
	private JMenu menu2=new JMenu("编辑(E)");
	private JMenuItem undo=new JMenuItem("撤销");
	private JMenuItem cut=new JMenuItem("剪切");
	private JMenuItem copy=new JMenuItem("复制");
	private JMenuItem paste=new JMenuItem("粘贴");
	/*******************************************/
	private JMenu menu3=new JMenu("格式(O)");
	private JMenuItem set_font=new JMenuItem("字体");
	JRadioButtonMenuItem aoto_wrap_line = new JRadioButtonMenuItem("自动换行");
	/*******************************************/
	private JMenu menu4=new JMenu("帮助(H)");
	private JMenuItem itemAbout=new JMenuItem("关于记事本");
	/*******************************************/
	private FileDialog openDia, saveDia;// 定义“打开、保存”对话框
	private File file;//定义文件

	//构造方法，用于初始化GUI，建立菜单
	public ex4_3()
	{
		f.setSize(1000,1000);
		f.setVisible(true);
		f.getContentPane().add(new JScrollPane(tf));
		tf.setEditable(true);
		bar1.setOpaque(false);
		menu1.setMnemonic('F');
		lblStatus=new JLabel("未修改");		
		f.setJMenuBar(bar1);
		menu1.add(newf);
		menu1.add(open);
		//添加快捷键
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		menu1.add(save);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		menu1.addSeparator();
		menu1.add(quit);
		bar1.add(menu1);
		bar1.add(menu2);
		bar1.add(menu3);
		bar1.add(menu4);
		menu2.add(cut);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		menu2.setMnemonic('E');
		menu2.add(copy);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		menu2.add(paste);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		menu3.setMnemonic('O');
		menu3.add(set_font);
		menu3.add(aoto_wrap_line);
		menu4.add(itemAbout);
		//初始化文件对话框
		openDia = new FileDialog(f, "打开", FileDialog.LOAD);
		saveDia = new FileDialog(f, "保存", FileDialog.SAVE);
		//注册事件监听
		newf.addActionListener(new Ac());
		open.addActionListener(new Ac());
		save.addActionListener(new Ac());
		quit.addActionListener(new Ac());
		copy.addActionListener(new Ac());
		cut.addActionListener(new Ac());
		paste.addActionListener(new Ac());
		aoto_wrap_line.addActionListener(new Ac());
		set_font.addActionListener(new Ac());
		itemAbout.addActionListener(new Ac());
		f.addWindowListener(new WinLis());
		tf.addKeyListener(new KeyHandler());
	}

	//类Ac用来实现监听器
	class Ac implements ActionListener
	{
		/* METHOD
		*@para:none
		*@description:覆盖actionPerformed方法，注册事件监听
		*/    
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==quit)
			{
				quitf();
			}
			if(e.getSource()==newf)
			{
				newfile();
			}
			if(e.getSource()==open)
			{
				openf();
			}
			if(e.getSource()==save)
			{
				savef();
			}
			if(e.getSource()==cut)
			{
				tf.cut();
			}
			if(e.getSource()==copy)
			{
				tf.copy();
			}
			if(e.getSource()==paste)
			{
				tf.paste();
			}
			if(e.getSource()==aoto_wrap_line)
			{
				wrap();
			}
			if(e.getSource()==set_font)
			{
				setFont();
			}
			if(e.getSource()==itemAbout)
			{
				about();
			}
		}
		/* METHOD
		*@para:none
		*@description:退出，但是在退出之前需要检查文件是否被修改，决定是否保存
		*/    
		public void quitf()
		{
		    if(lblStatus.getText().equals("已修改"))
		    {
			    int confirm=JOptionPane.showConfirmDialog(null, "文件已修改，要保存吗？");
				if(confirm==JOptionPane.OK_OPTION)
				{
					savef();
				}
				else if(confirm==JOptionPane.CANCEL_OPTION)
				{
					return;
				}
				else if(confirm==JOptionPane.CLOSED_OPTION)
				{
					return;
				}
		    }
		   System.exit(0);
		}
		/* METHOD
		*@para:none
		*@description:用于新建一个文件
		*/    
		public void newfile()
		{
			//新建之前要先确定是否要保存现在的文件，防止文件的丢失
			if(lblStatus.getText().equals("已修改"))
			{
				//弹出一个对话框，返回确定值
				int confirm=JOptionPane.showConfirmDialog(null, "文件已修改，要保存吗？");
				if(confirm==JOptionPane.OK_OPTION)
				{
					savef();
				}
				else if(confirm==JOptionPane.CANCEL_OPTION)
				{
					return;
				}
				else if(confirm==JOptionPane.CLOSED_OPTION)
				{
					return;
				}
			}
			tf.setText("");//清空
			paste.setEnabled(false);
			lblStatus.setText("未修改");
		}
		/* METHOD
		*@para:none
		*@description:打开关于记事本对话框
		*/    
		public void about()
		{
		String message = "\n名称：记事本" +"\n版本：1.0\n作者：Liu" + "\n\n感谢您的使用\n";
    	JOptionPane.showMessageDialog(null,message,"关于记事本",JOptionPane.PLAIN_MESSAGE);
		}
		/* METHOD
		*@name:openf
		*@description:弹出一个对话框，用于打开文件
		*/    
		public void openf()
		{
			openDia.setVisible(true);//显示打开文件对话框
            String dirpath = openDia.getDirectory();//获取打开文件路径并保存到字符串中。
            String fileName = openDia.getFile();//获取打开文件名称并保存到字符串中
            
            if (dirpath == null || fileName == null)//判断路径和文件是否为空
                return;
            else
                tf.setText(null);//文件不为空，清空原来文件内容。
            file = new File(dirpath, fileName);//创建新的路径和名称
            try {
                BufferedReader bufr = new BufferedReader(new FileReader(file));//尝试从文件中读东西
                String line = null;//变量字符串初始化为空
                while ((line = bufr.readLine()) != null) {
                    tf.append(line + "\r\n");//显示每一行内容
                }
                bufr.close();//关闭文件
            } catch (FileNotFoundException e1) {
                // 抛出文件路径找不到异常
                e1.printStackTrace();
            } catch (IOException e1) {
                // 抛出IO异常
                e1.printStackTrace();
            }
		}
		/* METHOD
		*@name:savef
		*@description:弹出一个对话框，用于保存文件
		*/    
		public void savef()
		{
			if (file == null) {
                saveDia.setVisible(true);//显示保存文件对话框
                String dirpath = saveDia.getDirectory();//获取保存文件路径并保存到字符串中。
                String fileName = saveDia.getFile();////获取打保存文件名称并保存到字符串中
                
                if (dirpath == null || fileName == null)//判断路径和文件是否为空
                    return;//空操作
                else
                    file=new File(dirpath,fileName);//文件不为空，新建一个路径和名称
            }
                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                    
                    String text = tf.getText();//获取文本内容
                    bufw.write(text);//将获取文本内容写入到字符输出流
                    
                    bufw.close();//关闭文件
                } catch (IOException e1) {
                    //抛出IO异常
                    e1.printStackTrace();
                }
		}
		/* METHOD
		*@name:wrap
		*@description:用于设置自动换行
		*/    
		public void wrap()
		{
			if(tf.getLineWrap()){
				tf.setLineWrap(false);
			}
			else{
				tf.setLineWrap(true);
			}
		}
		/* METHOD
		*@name: setFont
		*@description:用于开启一个新窗口设置字体
		*/    
		public void setFont()
		{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    		JList fontNames = new JList(ge.getAvailableFontFamilyNames());//放置一个字体列表
            int response = JOptionPane.showConfirmDialog(null, new JScrollPane(fontNames));
    		String selectedFont = (String)fontNames.getSelectedValue();
		    if (response == JOptionPane.YES_OPTION && selectedFont != null)
		    	{
		    		System.out.println("选择了 " + selectedFont);
		    		Font f1=new Font(selectedFont,Font.PLAIN,15);
		    		tf.setFont(f1);
		    	}
		    else
		        System.out.println("取消了或没作出选择"); 
		}

		
	}

	/* CLASS
	*@name:Winlis
	*@description:实现 WindowAdapter
	*/    
	class WinLis extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}

	/* CLASS
	*@name:KeyHandler
	*@description:监听键盘事件，如果有事件，就将状态设置为未保存
	*/    
	class KeyHandler extends KeyAdapter
	{    
		public void keyTyped(KeyEvent e)
		{
			if(e.getSource()==tf)
			{
				lblStatus.setText("已修改");
			}
			super.keyTyped(e);
		}
	}

	//main方法用于测试
	public static void main(String[] args) {
		new ex4_3();
	}
}
