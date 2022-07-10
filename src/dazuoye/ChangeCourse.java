package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class ChangeCourse extends MyFrame{
    MyFrame mf = new MyFrame("课程修改界面");
    DataManage dm = new DataManage();
    FrameOk fq = new FrameOk("操作成功");

    public ChangeCourse(String title) throws IOException
    {
        super(title);
        mf.setLayout(new GridLayout(3, 1));

        JPanel jp1 = new JPanel();
        jp1.setSize(500,250);
        jp1.setLayout(new GridLayout(3,2,5,5));
        JLabel jl1 = new JLabel("请输入想要修改的课程名称");
        JTextField jt1 = new JTextField(10);

        JLabel jl2 = new JLabel("请输入修改后的名称");
        JTextField jt2 = new JTextField(10);

        JButton jb1 = new JButton("确认");
        JButton jb2 = new JButton("取消");

        jp1.add(jl1);jp1.add(jt1);
        jp1.add(jl2);jp1.add(jt2);
        jp1.add(jb1);jp1.add(jb2);
        mf.add(jp1);
        Container c = getContentPane();
        c.add(jp1);
        c.setVisible(true);
        mf.setVisible(false);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = jt1.getText();
                String str2 = jt2.getText();
                try {
                    dm.readData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dm.changeCourse(str1,str2);
                dm.clearData();
                try {
                    dm.writeData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                mf.dispose();
                fq.setVisible(true);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}
