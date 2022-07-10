package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class AddCourse extends MyFrame{
    MyFrame mf = new MyFrame("课程录入界面");
    DataManage dm = new DataManage();
    FrameOk fo = new FrameOk("操作成功");
    public AddCourse(String title) throws IOException {
        super(title);
        mf.setLayout(new GridLayout(3, 1));
        JPanel jp0 = new JPanel();
        jp0.setSize(500,100);
        jp0.setLayout(new FlowLayout());
        mf.add(jp0);

        JPanel jp1 = new JPanel();
        jp1.setSize(500,500);
        jp1.setLayout(new FlowLayout());
        mf.add(jp1);

        JPanel jp2 = new JPanel();
        jp2.setSize(500,100);
        jp2.setLayout(new FlowLayout());
        mf.add(jp2);

        JLabel jl0 = new JLabel("请输入想要录入的新课程", JLabel.CENTER);
        JLabel jl1 = new JLabel("（添加成功后所有学生的该课程成绩默认为60）", JLabel.CENTER);

        JLabel jl2 = new JLabel("新课程：");
        JTextField jt1 = new JTextField(10);

        JButton jb1 = new JButton("确认");
        JButton jb2 = new JButton("取消");

        jp0.add(jl0);jp0.add(jl1);
        jp0.add(jt1);
        jp0.add(jb1);jp0.add(jb2);

        Container c=getContentPane();
        c.add(jp0);
        c.setVisible(true);
        mf.setVisible(false);


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    String str1 = jt1.getText();
                    dm.readData();
                    dm.addCourse(str1);
                    dm.clearData();
                    dm.writeData();
                    mf.dispose();
                    fo.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
