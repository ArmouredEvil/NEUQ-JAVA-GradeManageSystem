package dazuoye;
import javax.swing.*;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);
        this.setTitle(title);
        this.setBounds(500, 300, 700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
