package dazuoye;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class SearchCourse extends MyFrame{
    MyFrame mf1 = new MyFrame("课程查询界面");
    MyFrame mf2 = new MyFrame("查询结果");
    FrameQuit fq = new FrameQuit("查询结果不存在！");
    DataManage dm = new DataManage();
    public int markCourse = 1;

    public void showCourse()
    {
        mf2.setLayout(new GridLayout(3, 1));
        JPanel jp2 = new JPanel();
        jp2.setSize(500,500);
        jp2.setLayout(new GridLayout(8,1,5,5));
        JLabel [] jl = new JLabel[9];
        int j = markCourse;
        for(int i=1;i<=dm.get_countPerson();i++)
        {
            jl[i] = new JLabel(dm.getName(i)+":"+dm.getGrade(i,j));
            jp2.add(jl[i]);
        }
        mf2.add(jp2);
       /* Container c = getContentPane();
        c.add(jp2);
        c.setVisible(true);*/
        mf2.setVisible(true);
    }

    public SearchCourse(String title) throws IOException
    {
        super(title);
        mf1.setLayout(new GridLayout(3, 1));
        JPanel jp1 = new JPanel();
        jp1.setSize(500,500);
        jp1.setLayout(new FlowLayout());
        mf1.add(jp1);
        JLabel jl1 = new JLabel("请输入想要查询的科目");
        JTextField jt1 = new JTextField(10);

        JButton jb1 = new JButton("确认");
        JButton jb2 = new JButton("取消");
        jp1.add(jb1);jp1.add(jb2); jp1.add(jl1);jp1.add(jt1);

        Container c =getContentPane();
        c.add(jp1);//mf1.add(c);
        c.setVisible(true);
        mf1.setVisible(false);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dm.readData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String str = jt1.getText();
                boolean judge = false;
                for(int i=1;i<=dm.get_countProject();i++)
                {
                    if(str.equals(dm.getCourse(i)))
                    {
                        judge = true;
                        markCourse = i;
                        mf1.dispose();
                        showCourse();
                        break;
                    }
                }
                if(!judge)fq.setVisible(true);
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
