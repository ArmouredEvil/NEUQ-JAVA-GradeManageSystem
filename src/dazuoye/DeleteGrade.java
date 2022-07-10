package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class DeleteGrade extends MyFrame{

    MyFrame mf = new MyFrame("课程删除界面");
    FrameOk fo = new FrameOk("操作成功！");
    DataManage dm = new DataManage();

    public DeleteGrade(String title) throws IOException
    {
        super(title);
        mf.setLayout(new GridLayout(3, 1));

        JPanel jp1 = new JPanel();
        jp1.setSize(500,250);
        jp1.setLayout(new FlowLayout(5,5,5));
        JLabel jl1 = new JLabel("请输入想要删除的学生的姓名");
        JTextField jt1 = new JTextField(10);
        JButton jb1 = new JButton("确认");
        JButton jb2 = new JButton("取消");
        jp1.add(jl1);jp1.add(jt1);
        jp1.add(jb1);jp1.add(jb2);
        Container c = getContentPane();
        c.add(jp1);
        c.setVisible(true);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jt1.getText();
                try {
                    dm.readData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dm.deleteGrade(str);
                dm.clearData();
                try {
                    dm.writeData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                mf.dispose();
                fo.setVisible(true);
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
