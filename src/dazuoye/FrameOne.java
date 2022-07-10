package dazuoye;//package
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class FrameOne extends MyFrame {
    //public boolean judgeFirst = false;
    //public boolean judgeSecond = false;
    MyFrame jf = new MyFrame("登陆界面");
    MainFrame mf = new MainFrame("主界面");
    String str1;
    String str2;

    public FrameOne(String title) throws IOException {
        super(title);
        JLabel jp0 = new JLabel("欢迎使用成绩管理系统！", JLabel.CENTER);
        jf.add(jp0);
        jf.setLayout(new GridLayout(3, 1));
        //add(new JLabel("          "));

        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("用户名");
        JTextField username = new JTextField(10);
        jp1.setLayout(new FlowLayout());
        jp1.add(jl1);
        jp1.add(username);


        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("密 码");
        JPasswordField pw = new JPasswordField(10);
        pw.setEchoChar('*');
        jp2.setLayout(new FlowLayout());
        jp2.add(jl2);
        jp2.add(pw);

        JButton ok = new JButton("确认");
        JButton quit = new JButton("取消");
        JPanel jp3 = new JPanel();
        jp3.setLayout(new FlowLayout());
        jp3.add(ok);
        jp3.add(quit);

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.setBounds(500, 400, 300, 300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);

        //str1 = username.getText();
        //str2 = new String(pw.getPassword());

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("如果窗体未关闭，则密码错误");
                str1 = username.getText();
                str2 = new String(pw.getPassword());
                if (str1.equals("guanliyuan") && str2.equals("12345"))
                {jf.dispose();mf.setVisible(true);}
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
   /* public static void main(String args[]){new FrameOne("ceshi");}*/
}



