package com.company;

import javafx.geometry.Orientation;
import javafx.geometry.VerticalDirection;
import sun.security.util.Password;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.naming.AuthenticationException;
import javax.swing.*;


public class Main extends javax.swing.JFrame{

    final static String app_name = "Authentication";

    static final String username = "Admin";
    static final String key = "Admin";

    private static SignIn signin;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    load_SignIn();
                    new Main();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void load_SignIn() {
        signin = new SignIn(new OnClickListener() {
            @Override
            public void play(final String user, final String password) {
                JFrame check = new JFrame();
                check.setSize(100,100);
                JLabel succ = new JLabel("success your "+user+" "+password);
                JLabel fail = new JLabel("fail");

                System.out.println(username+"="+user);
                System.out.println(key+"="+password);

                if (username.equals(user) && key.equals(password))
                    check.add(succ);
                else
                    check.add(fail);
                check.setVisible(true);
            }
        });
    }

    private Main() {
        super(app_name);

        //Window screen initalizing

        //Initializing main screen
        setSize(1000,600);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //make appear in center of the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //screen contains toolbar and main
        JPanel screen = new JPanel();
        JPanel toolbar = new JPanel();
        JPanel main = new JPanel();
        JPanel back = new JPanel();

        screen.setLayout(new GridBagLayout());
        screen.setSize(600,600);

        toolbar.setBackground(Color.decode("#448AFF"));

        GridLayout gridLayout = new GridLayout(2,1);
        BorderLayout borderLayout = new BorderLayout();

        //Greeting on Toolbar
        //#448AFF for design
        //first Layout initializing
        JLabel hello = new JLabel("\tHello Manager, Please Sign in...");
        hello.setFont(new Font(hello.getFont().getName(), Font.PLAIN,25));
        hello.setForeground(Color.WHITE);
        toolbar.setLayout(new BorderLayout());
        toolbar.add(hello, BorderLayout.CENTER);

        //second Layout initializing
        main.setBackground(Color.WHITE);
        main.setLayout(new GridBagLayout());
        main.add(signin.take());

        //third Layout initializig
        back.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.weightx = 1;
        constraints.ipady = 200;
        constraints.gridx = 0;

        constraints.gridy = 1;
        screen.add(toolbar, constraints);

        constraints.gridy = 2;
        screen.add(main, constraints);

        constraints.gridy = 3;
        screen.add(back, constraints);

        add(screen);

        screen.setVisible(true);
        setVisible(true);
    }

//    public interface OnClickListener {
//        void play();
//    }
}
