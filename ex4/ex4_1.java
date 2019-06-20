import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ex4_1 extends JFrame implements ActionListener{
	//序列化ID，相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性，在程序版本升级时避免程序报出版本不一致的错误。
	private static final long serialVersionUID = 1L;
	//添加一个标签和四个按钮
	private JLabel lb=new JLabel("Center",JLabel.CENTER);//设置居中对齐
	private JButton bt1=new JButton("North");
	private JButton bt2=new JButton("South");
	private JButton bt3=new JButton("East");
	private JButton bt4=new JButton("West");
	//主函数用于测试控制
	public static void main(String[] arg)
	{
		new ex4_1();
	}
	//构造方法，GUI的组件从这里构造

	public void init()
	{
		JFrame f1=new JFrame();
		Container cp=f1.getContentPane();
		f1.setTitle("ex4-1");
		f1.setVisible(true);
		f1.setSize(550,500);
		lb.setVerticalAlignment(0);
		cp.add(lb,BorderLayout.CENTER);
		cp.add(bt1,BorderLayout.NORTH);
		cp.add(bt2,BorderLayout.SOUTH);
		cp.add(bt3,BorderLayout.EAST);
		cp.add(bt4,BorderLayout.WEST);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}
	public ex4_1()
	{
		init();

	}
	// 覆盖 actionPerformed 方法，用于监听事件并做出响应
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bt1)
		{
			lb.setText(bt1.getText());//设置标签信息
		}
		if(e.getSource()==bt2)
		{
			lb.setText(bt2.getText());//设置标签信息
		}
		if(e.getSource()==bt3)
		{
			lb.setText(bt3.getText());//设置标签信息
		}
		if(e.getSource()==bt4)
		{
			lb.setText(bt4.getText());//设置标签信息
		}

		
	}

}
