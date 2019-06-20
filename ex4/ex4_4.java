import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ex4_4 extends JFrame{
	//序列化ID，相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性，在程序版本升级时避免程序报出版本不一致的错误。
	private static final long serialVersionUID = 1L;
	/* METHOD
	*@para: text,传入文字
	*@description:构造方法，用于初始化GUI
	*/    
	public ex4_4(String text) {
	    super("跑马灯");
	    this.setBounds(300, 240, 400, 300);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    if(text==null)
	         this.getContentPane().add(new mainMethod("JAVA"));
	     else {
	    	 this.getContentPane().add(new mainMethod(text));
	    }
	    this.setVisible(true);
	}

    //重载方法，用于参数为空时初始化
	public  ex4_4() {
	    this(null);
	}
	private class mainMethod extends JPanel implements ActionListener,Runnable {
	    private static final long serialVersionUID = 1L;
	    //初始化组件
	    JTextField text_word,text_sleep,text_state=null;
	    JTextField fs;
	    JButton button_start,button_interrupt;
	    Thread thread;
	    int sleeptime;
	    /* METHOD
	    *@para:text,跑马灯的文字
	    *@description:组件的摆放方法
	    */    
	    mainMethod(String text) {
	        this.setLayout(new GridLayout(3,1));
	        text_word =new JTextField(String.format("%115s", text));
	        Font f1=new Font("TimesRoman",Font.BOLD,30);
	        text_word.setFont(f1);
	        Color col = new Color(0,0,0);
	        text_word.setForeground(col);
	        this.add(text_word);
	        JPanel panel_sub=new JPanel();
	        this.add(panel_sub);
	        panel_sub.add(new Label("sleep time"));
	        this.sleeptime=50;
	        text_sleep=new JTextField(""+sleeptime,5);
	        panel_sub.add(text_sleep);
	        text_sleep.addActionListener(this);
	        button_start=new JButton("启动");
	        panel_sub.add(button_start);
	        button_start.addActionListener(this);
	        button_interrupt=new JButton("中断");
	        panel_sub.add(button_interrupt);
	        button_interrupt.addActionListener(this);
	        thread =new Thread(this);
	        button_interrupt.setEnabled(false);
	        panel_sub.add(new JLabel("state"));
	        text_state=new JTextField(""+thread.getState(),10);
	        text_state.setEditable(false);
	        panel_sub.add(text_state);
	        JPanel panel_subb=new JPanel();
	        fs=new JTextField("30",5);
	        fs.addActionListener(this);
	        JLabel lb=new JLabel("Font Size");
	        panel_subb.add(lb);
	        panel_subb.add(fs);
	        this.add(panel_subb);
	    }
	    /* METHOD
	    *@para:none
	    *@description:重载run方法，用于多线程的运行
	    */    
	    public void run() {
	        while (true) {
	            String str = text_word.getText();
	            text_word.setText(str.substring(3)+str.substring(0,3));
	            try {
	                Thread.sleep(sleeptime);
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                break;
	            }
	        }
	    }
	    /* METHOD
	    *@para:e,传入事件
	    *@description:重载方法，用于实现事件的监听
	    */    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	           if(e.getSource()==button_start){
	               thread= new Thread(this);
	               thread.start();//线程开始
	               int font_size=Integer.parseInt(fs.getText());
	               Font f1=new Font("TimesRoman",Font.BOLD,font_size);
	               text_word.setFont(f1);
	               text_state.setText(""+thread.getState());
	               //设置按钮的状态
	               button_start.setEnabled(false);
	               button_interrupt.setEnabled(true);

	           }    
	           if (e.getSource()==button_interrupt) {
	            thread.interrupt();//线程中止
	            text_state.setText(""+thread.getState());
                //设置按钮的状态
	            button_start.setEnabled(true);
	            button_interrupt.setEnabled(false);

	        }
	        //设置线程的休眠时间
	           if (e.getSource()==text_sleep) 
	           {
	               try
	               {
	            	   sleeptime=Integer.parseInt(text_sleep.getText());
	               }
	               catch(NumberFormatException nfex)
	               {	
	            	   JOptionPane.showMessageDialog(this, "\""+text_sleep.getText()+"\"不能转换成整数，请重新输入！");
	               }
	           
	           }
	    }
	}
	//main方法用于测试
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    String texts="Liu";
	    new ex4_4(texts);

	}

}
