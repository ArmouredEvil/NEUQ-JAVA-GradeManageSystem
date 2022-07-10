package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
public class FrameCourse extends MyFrame{
    MyFrame jf = new MyFrame("课程管理界面");
    AddCourse ac = new AddCourse("课程录入界面");
    SearchCourse sc = new SearchCourse("课程查询界面");
    ChangeCourse cc = new ChangeCourse("课程修改界面");
    DeleteCourse dc = new DeleteCourse("课程删除界面");
    public FrameCourse(String title) throws IOException {
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
                ac.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                sc.setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                cc.setVisible(true);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                dc.setVisible(true);
            }
        });
    }
}
