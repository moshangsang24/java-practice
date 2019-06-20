import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.*; 
import java.util.*;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import javax.swing.text.BadLocationException;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Window extends JFrame implements ActionListener{
	JMenuBar menubar;
	JMenu menu,menu1,menu2,itemLine,menu3,menu4;
	JSplitPane splitPane;
	JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemPrint,itemExit;
	JMenuItem itemCopy,itemCut,itemPaste,itemDelete;
	JMenuItem itemFont,line1,line2,itemhelp,itemabout;
	JTextArea text,text1;
	JLabel lblStatus;
	JTextField field;
	KeyHandler kHandler=new KeyHandler();
	JPopupMenu popupMenu;
	JToolBar statusBar;
	JCheckBoxMenuItem itemstate;

	Window(){
		init();
		intGUI();
		setBounds(500,150,500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void intGUI(){
		text=new JTextArea();
		add(new JScrollPane(text),BorderLayout.CENTER);				
		text.addKeyListener(kHandler);
		lblStatus=new JLabel("未修改");		
	}
	void init(){     //建立一个菜单
		menubar=new JMenuBar();    //建立文件菜单项

		menu=new JMenu("文件(F)");
		menubar.add(menu);
		setJMenuBar(menubar);
		itemNew=new JMenuItem("新建");  
		itemOpen=new JMenuItem("打开");
		itemSave=new JMenuItem("保存");
		itemSaveAs=new JMenuItem("另存为");
		itemPrint=new JMenuItem("打印 ");
		itemExit=new JMenuItem("退出");
		menu.add(itemNew);
		menu.add(itemOpen);
		menu.add(itemSave);
		menu.add(itemSaveAs);
		menu.add(itemPrint);
		menu.add(itemExit);
		itemNew.addActionListener(this);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		itemOpen.addActionListener(this);
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		itemSave.addActionListener(this);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		itemSaveAs.addActionListener(this);
		itemPrint.addActionListener(this);
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		itemExit.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   if(lblStatus.getText().equals("已修改")){
				   int confirm=JOptionPane.showConfirmDialog(null, "文件已修改，要保存吗？");
					if(confirm==JOptionPane.OK_OPTION)
						save();
					else if(confirm==JOptionPane.CANCEL_OPTION)
						return;
					else if(confirm==JOptionPane.CLOSED_OPTION)
						return;
				   }
				   System.exit(0);
			   }
			  
		});
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		menu1=new JMenu("编辑(E)");    //建立编辑菜单项
		menubar.add(menu1);
		setJMenuBar(menubar);
		itemCopy=new JMenuItem("复制");  
		itemCut=new JMenuItem("剪切");
		itemPaste=new JMenuItem("粘贴");
		itemDelete=new JMenuItem("删除");
		menu1.add(itemCopy);
		menu1.add(itemCut);
		menu1.add(itemPaste);
		menu1.add(itemDelete);
		itemCopy.addActionListener(this);
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		itemCut.addActionListener(this);
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		itemPaste.addActionListener(this);
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		itemDelete.addActionListener(this);
		itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

		menu2=new JMenu("格式(O)");    //建立格式菜单项
		menubar.add(menu2);
		setJMenuBar(menubar);
		
       itemLine=new JMenu("自动换行");         //建立二级菜单项
       line1=new JMenuItem("选择自动换行");
       line2=new JMenuItem("取消自动换行");
       itemLine.add(line1);
       itemLine.add(line2);
       menu2.add(itemLine);
       line1.addActionListener(this);
       line2.addActionListener(this);
       
       itemFont=new JMenuItem("字体");
	   menu2.add(itemFont);
	   itemFont.addActionListener(this);
	   
	    menu3=new JMenu("查看(V)");    //建立查看菜单项
		menubar.add(menu3);
		setJMenuBar(menubar);
		itemstate=new JCheckBoxMenuItem("状态栏");     //设置选勾菜单项
		menu3.add(itemstate);
		itemstate.addActionListener(this);
		
	    menu4=new JMenu("帮助(H)");    //建立帮助菜单项
		menubar.add(menu4);
		setJMenuBar(menubar);
		itemhelp=new JMenuItem("查看帮助");  
		menu4.add(itemhelp);
		itemhelp.addActionListener(this);
		itemabout=new JMenuItem("关于记事本");  
		menu4.add(itemabout);
		itemabout.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){       //选择
		if(e.getSource()==itemCopy)
			text.copy();
		else if(e.getSource()==itemCut)
			text.cut();
		else if(e.getSource()==itemPaste)
			text.paste();
		else if(e.getSource()==itemNew)
			inew();
		else if(e.getSource()==itemSave)
			save();
		else if(e.getSource()==itemOpen)
			open();
		else if(e.getSource()==itemSaveAs)
			saveas();
		else if(e.getSource()==itemPrint)
			print();
		else if(e.getSource()==itemDelete)
			delete();
		else if(e.getSource()==line1)
			text.setLineWrap(true);     //激活自动换行功能
		else if(e.getSource()==line2)
			text.setLineWrap(false);
		else if(e.getSource()==itemFont)
			font();
		else if(e.getSource()==itemstate)
			     {
		     if(itemstate.getState())
		    	 state();        
		     else
		      statusBar.setVisible(false);     //状态栏不可见           
		    }
		else if(e.getSource()==itemhelp)
			itemhelp();
		else if(e.getSource()==itemabout)
			itemabout();
	}	    
	  
	void itemhelp(){
		String message = "1.记事本软件界面很简洁，使用方法简单，但是也仅拥有着基本文字编辑的功能。\n不能对文字进行排版和样式编辑。"
			+"\n2.软件最上方的是标题栏，下面的是菜单栏（点击不同按钮会出现不同的下拉菜单），中间白色空\n白区域为编辑区域，下方的是状态栏，右边是滚动条。" 
			+ "\n3.下拉菜单说明："
			+ "\n(1)文件"
			+ "\n新建：新建一个空白的文档。[如果正在编辑中的文档被修改过，会提醒是否保存。]"
			+ "\n打开：打开一个已知的文本文档。[如果正在编辑中的文档被修改过，会提醒是否保存。]"
			+ "\n保存：保存现在编辑中的文档。[如果没有保存过会提示保存的位置，如果保存过则会自动覆写上已经保存的文件。]"
			+ "\n另存为：将现在编辑中的文件存到别的地方。[如果文件保存过则需要保存到别的地方或者改名保\n存到同一位置，如果文件没有保存过则功能同 保存。]"
			+ "\n打印：将现在编辑中的文件输出到打印终端进行打印。"
			+ "\n退出:退出记事本软件"
			+ "\n(2)编辑"
			+ "\n剪切：将选中的文字剪贴到剪贴板中"
			+ "\n复制：将选中的文字复制到剪贴板中"
			+ "\n粘贴：将剪贴板中的文字粘贴到记事本的光标处"
			+ "\n删除：删除选中的文字。撤销：撤销上一步操作"
			+ "\n(3)格式"
			+ "\n自动换行：当文字到达最右边的时候，自动切换到下一行"
			+ "\n字体：文字的显示设置，可设置 字体、字形、大小，并提供预览"
			+ "\n(4)查看"
			+ "\n状态栏：当前光标的所在的行数列数，显示时间以及文字总数，需要重点击状态栏才显示最新消息"		
			;
    	JOptionPane.showMessageDialog(this,message,"查看帮助",JOptionPane.PLAIN_MESSAGE);
	}
	
    void itemabout(){
    	String message = "\n名称：vivian记事本" +"\n版本：1.0\n作者：mengmeng" + "\n\n感谢您的使用\n http://t.qq.com/mengsifen ";
    	JOptionPane.showMessageDialog(this,message,"关于记事本",JOptionPane.PLAIN_MESSAGE);

	}
	
	JLabel statusLabel1,statusLabel2,statusLabel3;
	JMenuBar MenuBar=new JMenuBar(); 
	Container container=getContentPane();
	void state(){
		GregorianCalendar time=new GregorianCalendar();
		int hour=time.get(Calendar.HOUR_OF_DAY);
		int min=time.get(Calendar.MINUTE);
		int second=time.get(Calendar.SECOND);
		statusBar=new JToolBar();
		
		int curLn=1;              //设置行数列数
	    int curCol=1; 
	    int caretPos = this.text.getCaretPosition();
	    int curSel = 0;
	    try {
	      // 获取指定偏移量处的行号，返回行号的取值范围：x>=0 && x<文本域总行数
	      curLn = text.getLineOfOffset(caretPos) + 1;
	      // 获取指定行起始处的偏移量，指定行号的取值范围：x>=0 && x<文本域总行数
	      curCol+= caretPos - this.text.getLineStartOffset(curLn - 1);
	    } catch (BadLocationException x) {
	      x.printStackTrace();
	    }
	    String strSel = text.getSelectedText();
	    if (strSel != null) {
	      curSel = strSel.length();
	    }
	    /*
	     *  显示状态栏
	     */
		statusBar.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		statusLabel1=new JLabel("字数总数: " + this.text.getText().length());
		statusLabel2=new JLabel("    当前时间：    "+hour+":"+min +":"+second);
		statusLabel3=new JLabel("当前光标所在行数:"+curLn+"所在行数:"+curCol);
		statusBar.add(statusLabel1);
		statusBar.add(statusLabel2);
		statusBar.add(statusLabel3);
		container.add(statusBar,BorderLayout.SOUTH);
		statusBar.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		Clock clock =new Clock();
		clock.start();}
		class Clock extends Thread {       //模拟的时钟 
			public void run() {
			while(true){
			GregorianCalendar time=new GregorianCalendar();
			int hour=time.get(Calendar.HOUR_OF_DAY);
			int min=time.get(Calendar.MINUTE);
			int second=time.get(Calendar.SECOND);
			statusLabel2.setText("    当前时间："+hour+":"+min +":"+second);
			try{Thread.sleep(900);}catch (InterruptedException exception){}
			}		
			}			    
			}
		
     void font(){      //实现字体调整

          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    		 JList fontNames = new JList(ge.getAvailableFontFamilyNames());
             int response = JOptionPane.showConfirmDialog(null, new JScrollPane(fontNames));
    		   Object selectedFont = fontNames.getSelectedValue();
    		    if (response == JOptionPane.YES_OPTION && selectedFont != null)
    		        System.out.println("选择了 " + selectedFont);
    		      else
    		        System.out.println("取消了或没作出选择"); 
    		    }
   
	void delete(){       //实现删除功能
		text.cut();
	}
	
	void print(){              //实现打印功能
		String printStr = text.getText().trim(); // 获取需要打印的目标文本
        if (printStr != null && printStr.length() > 0) // 当打印内容不为空时
        { 
            // PAGES = getPagesCount(printStr); // 获取打印总页数
            PrinterJob myPrtJob = PrinterJob.getPrinterJob(); // 获取默认打印作业
            PageFormat pageFormat = myPrtJob.defaultPage(); // 获取默认打印页面格式
            //myPrtJob.setPrintable(this, pageFormat); // 设置打印工作
            if (myPrtJob.printDialog()) // 显示打印对话框
            { 
                try 
                { 
                    myPrtJob.print(); // 进行每一页的具体打印操作
                } 
                catch(PrinterException pe) 
                { 
                    pe.printStackTrace(); 
                } 
            } 
        } 
        else 
        { 
			 // 如果打印内容为空时，提示用户打印将取消
            JOptionPane.showConfirmDialog 
			 (null, "对不起，文本为空，打印取消!", "Empty", 
			 JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE); 
        } 
    } 


	void save()
	{       //实现保存功能
		PrintWriter w=null;
		FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt", "txt");
		JFileChooser Chooser=new JFileChooser();
		Chooser.setFileFilter(filter);
		if(lblStatus.getText().equals("已修改")){
		Chooser.setSelectedFile(new File(getName()));
		int result=Chooser.showSaveDialog(null);	
		if (result==JFileChooser.APPROVE_OPTION) {
			File file=Chooser.getSelectedFile();	
			System.out.println(file.getPath());
			if (!file.getName().endsWith(".txt")) {
				file=new File(file.getPath()+".txt");
				System.out.println(file.getPath());
			}
			try{
				w=new PrintWriter(new BufferedWriter(new FileWriter(file)));
				String ss[]=text.getText().split("\n");
				for(String st:ss)
					w.println(st);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				w.close();
			}
			}
			
		}
	}
	void open(){     //实现打开功能
		inew();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt", "txt");
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(filter);
		int s=chooser.showOpenDialog(null);
		String str="";
		if(s==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			BufferedReader r=null;
			file.getName().endsWith(".txt");
			try{
				r=new BufferedReader(new FileReader(file));
				while(true){
					str=r.readLine();
					if(str==null)
						break;
					    text.append(str+"\n");
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{r.close();}
			catch(IOException e){e.printStackTrace();}
			}
			Window.this.setTitle(file.getName());
		}	
	}
	void saveas(){      //实现另存为功能
	PrintWriter w=null;
	FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt", "txt");
	JFileChooser Chooser=new JFileChooser();
	Chooser.setFileFilter(filter);
	int result=Chooser.showSaveDialog(null); 
	if (result==JFileChooser.APPROVE_OPTION) {
		File file=Chooser.getSelectedFile();
		System.out.println(file.getPath());
		if (!file.getName().endsWith(".txt")) {
			file=new File(file.getPath()+".txt");
			System.out.println(file.getPath());
		}
		try{
			w=new PrintWriter(new BufferedWriter(new FileWriter(file)));
			String ss[]=text.getText().split("\n");
			for(String st:ss)
				w.println(st);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			w.close();
		}
		}
		
	}
	
	public void inew(){        //实现新建功能
		if(lblStatus.getText().equals("已修改")){
			int confirm=JOptionPane.showConfirmDialog(null, "文件已修改，要保存吗？");
			if(confirm==JOptionPane.OK_OPTION)
				save();
			else if(confirm==JOptionPane.CANCEL_OPTION)
				return;
			else if(confirm==JOptionPane.CLOSED_OPTION)
				return;
		}
		text.setText("");
		itemPaste.setEnabled(false);
		lblStatus.setText("未修改");
	}
	class KeyHandler extends KeyAdapter{    //定义键盘事件监听器内部类
		public void keyTyped(KeyEvent e){
			if(e.getSource()==text)
				lblStatus.setText("已修改");
			super.keyTyped(e);
		}
	}
	class MouseHandler extends MouseAdapter{     //定义鼠标事件监听器内部类
		public void mouseReleased(MouseEvent e){
			if(e.getButton()==MouseEvent.BUTTON3&&e.getSource()==text){
				popupMenu.show(text,e.getX(),e.getY());	
			}
			super.mouseReleased(e);
		}
	}

}
