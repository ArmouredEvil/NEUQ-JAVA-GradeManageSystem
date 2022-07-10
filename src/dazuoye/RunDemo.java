package dazuoye;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class RunDemo {
    public RunDemo() throws IOException {
       FrameOne F1 = new FrameOne("登陆界面");

    }



    public static void main(String[] args) {
       try{
           new RunDemo();
       }catch (IOException ex) {
           throw new RuntimeException(ex);
       }
    }
}



