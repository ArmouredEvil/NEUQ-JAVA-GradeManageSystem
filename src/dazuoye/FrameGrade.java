package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class FrameGrade extends MyFrame{
    MyFrame jf = new MyFrame("成绩管理界面");
    AddGrade ag = new AddGrade("成绩录入界面");
    SearchGrade sg = new SearchGrade("成绩查询界面");
    ChangeGrade cg = new ChangeGrade("成绩修改界面");
    DeleteGrade dg = new DeleteGrade("成绩删除界面");
    public FrameGrade(String title) throws IOException {
        super(title);
        JPanel jp1 = new JPanel();
        JButton b1 = new JButton("录入");
        JButton b2 = new JButton("查询");
        JButton b3 = new JButton("修改");
        JButton b4 = new JButton("删除");
        jp1.setLayout(new FlowLayout());
        Container c=getContentPane();
        c.add(jp1);
        jp1.add(b1);jp1.add(b2);jp1.add(b3);jp1.add(b4);
        jf.setVisible(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                ag.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                sg.setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                cg.setVisible(true);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                dg.setVisible(true);
            }
        });

    }
}
