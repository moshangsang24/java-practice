import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* CLASS
*@name: ex4_2
*@description:主类
*/    
public class ex4_2 {
	int r,g,b=0;
	String s,s1=" ",s2=" ",s3=" ";
	JScrollBar sbr,sbg,sbb;
	JPanel pa1,pa2,pa3;
	JLabel lb1=new JLabel("刻度： "),lb2=new JLabel(" 标签  "),
	lb3=new JLabel(" 调色板 "),lbr=new JLabel("红色"),
			lbg=new JLabel("绿色"),lbb=new JLabel("蓝色");

	/* METHOD
	*@name:main
	*@description:main方法用于测试
	*/   

	public static void main(String[] args) 
	{
		new ex4_2();
	}

	//构造方法，GUI的组件从这里构造
	public ex4_2()
	{
		//创建jframe框架
		JFrame f=new JFrame("JScrollBar");
		Container cp=f.getContentPane();//get面板
		Box baseBox=Box.createVerticalBox();//创建一个box
		cp.add(baseBox);
		Box box1=Box.createHorizontalBox();
		box1.add(lb1);
		box1.add(lb2);
		baseBox.add(box1);
		Box box3=Box.createVerticalBox();
		baseBox.add(box3);
		lb3.setBackground(new Color(0, 0, 0));
		lb3.setBorder(BorderFactory.createEtchedBorder());
		lb3.setOpaque(true);//设置不透明
		lb3.setMaximumSize(new Dimension(450, 200));
		box3.add(lb3);
		//创建滑动组件
		sbr=new JScrollBar(JScrollBar.HORIZONTAL, 10, 10, 0, 260);
		sbr.setUnitIncrement(5);
		sbr.setBlockIncrement(10);
		sbr.addAdjustmentListener(new DJ());
		box3.add(lbr);
		box3.add(sbr);
		sbg=new JScrollBar(JScrollBar.HORIZONTAL, 10, 10, 0, 260);
		sbg.setUnitIncrement(5);
		sbg.setBlockIncrement(10);
		sbg.addAdjustmentListener(new DJ());
		box3.add(lbg);
		box3.add(sbg);
		sbb=new JScrollBar(JScrollBar.HORIZONTAL, 10, 10, 0, 260);
		sbb.setUnitIncrement(5);
		sbb.setBlockIncrement(10);
		sbb.addAdjustmentListener(new DJ());
		box3.add(lbb);
		box3.add(sbb);
		f.pack();
		f.setVisible(true);//一定要setVisible
		f.addWindowListener(new WinLis());
	}
	/* CLASS
	*@name:WinLis
	*@description: 用于实现WindowsAdapter,监听窗口
	*/    
	class WinLis extends WindowAdapter
	{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	/* METHOD
	*@name:DJ
	*@description:实现AdjustmentListener,用于监听滑动组件的事件，并做出相应的响应
	*/    
	class DJ implements AdjustmentListener
	{
		public void adjustmentValueChanged(AdjustmentEvent e)
		{
			if((JScrollBar)e.getSource()==sbr)
			{
				r=e.getValue();
				s1="red: ";
			}
			if((JScrollBar)e.getSource()==sbg)
			{
				g=e.getValue();
				s2="green: ";
			}
			if((JScrollBar)e.getSource()==sbb)
			{
				b=e.getValue();
				s3="red: ";
			}
			s=s1+r+" "+s2+g+" "+s3+b;
			lb2.setText(s);
			lb3.setBackground(new Color(r,g,b));
		}
	}
}
