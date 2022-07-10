package dazuoye;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameOk extends JFrame{
    public FrameOk(String title)
    {
        super(title);
        JLabel label = new JLabel("操作成功！",JLabel.CENTER);
        this.add(label);

        this.setBounds(600, 300, 100, 100);
        this.setVisible(false);
        this.setResizable(false);
        //this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*public static void main(String[] args) {
        new FrameOk("测试");
    }*/
}
