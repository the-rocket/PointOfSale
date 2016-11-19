package com.company;

import sun.plugin.dom.core.Text;
import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JPanel implements OnClickListener {

    private JPanel authentication;
    private JButton LogIn, Forget;

    private JTextField user = new JTextField(20);
    private JPasswordField password = new JPasswordField(20);

    OnClickListener listener;

    public SignIn(OnClickListener listener) {
        super();
        this.listener = listener;

        init();

        authentication = get(LogIn, Forget, user, password);

        setVisible(true);
    }

    void init() {
        LogIn = new JButton("Log In");
        Forget = new JButton("Forget?");

        LogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.play(user.getText(), new String(password.getPassword()));
            }
        });
    }


    private JPanel get(JButton log, JButton Forget, JTextField fill_login, JPasswordField fill_password) {

        //Initializing second window screen for Sign In
        JPanel auth = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();

        auth.setBorder(BorderFactory.createLineBorder(Color.black));
        auth.setLayout(new GridBagLayout());
        auth.setBackground(Color.WHITE);

        //Initializing Title of sign in field
        JLabel sign = new JLabel("Sign in",SwingConstants.CENTER);
        sign.setFont(new Font(getFont().getName(), Font.PLAIN, 25));

        //Sign in box default
        constraints.fill = GridBagConstraints.HORIZONTAL;

        //adding Sing word
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridx = 0;
        constraints.gridy= 0;
        auth.add(sign, constraints);

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridx = 0;
        constraints.ipady=10;

        //adding login field
        constraints.gridy = 1;
        auth.add(fill_login,constraints);

        //adding password field
        constraints.gridwidth= GridBagConstraints.REMAINDER;

        constraints.gridy = 2;
        auth.add(fill_password, constraints);

        constraints.gridwidth=GridBagConstraints.RELATIVE;
        constraints.gridy = 3;


        //adding button log
        constraints.weightx=1.0;
        constraints.gridx=0;

        auth.add(log, constraints);

        constraints.gridwidth=GridBagConstraints.REMAINDER;
        //adding button Forget to restore password
        constraints.weightx=0.0;
        constraints.gridx=1;

        auth.add(Forget, constraints);

        return auth;
    }

    public JPanel take() {
        return this.authentication;
    }

    @Override
    public void play(String user, String password) {

    }
}
