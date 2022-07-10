package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends MyFrame{
    MyFrame jf = new MyFrame("主界面");
    FrameCourse fc = new FrameCourse("课程管理界面");
    FrameGrade fg = new FrameGrade("成绩管理界面");
    public MainFrame(String title) throws IOException {
        super(title);
        JPanel jp1 = new JPanel();
        JButton b1 = new JButton("Course Manage");
        JButton b2 = new JButton("Grade Manage");
        jp1.setLayout(new FlowLayout());
        Container c=getContentPane();
        c.add(jp1);jp1.add(b1);jp1.add(b2);
        jf.setVisible(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                fc.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                fg.setVisible(true);
            }
        });

    }


}
