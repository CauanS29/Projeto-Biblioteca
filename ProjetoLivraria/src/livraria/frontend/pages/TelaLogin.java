package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.*;

import livraria.backend.Usuario;
import livraria.frontend.MudarTela;

public class TelaLogin extends JFrame {
    private static JPanel panel;
    private static JPanel adminPanel;
    private static JLabel titleLabel;
    private static JLabel adminLabel;
    private static JLabel userLabel;
    private static JTextField userField;
    private static JLabel passwordLabel;
    private static JPasswordField passwordField;
    private static JButton confirmAdminBtn;
    private static JButton enterClienteBtn;
    private static JLabel successLabel;

    public TelaLogin() {
        iniciarTela();
    }

    private void iniciarTela() {
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(44, 139, 59));
        add(panel);

        titleLabel = new JLabel("Bem vindo a Livraria Carrara");
        titleLabel.setBounds(130, 50, 400, 25);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(titleLabel);

        adminPanel = new JPanel();
        adminPanel.setLayout(null);
        adminPanel.setBounds(150, 100, 350, 220);
        adminPanel.setBackground(Color.lightGray);

        panel.add(adminPanel);

        adminLabel = new JLabel("Entrar como administrador");
        adminLabel.setBounds(100, 20, 190, 25);
        adminPanel.add(adminLabel);

        userLabel = new JLabel("Usuário");
        userLabel.setBounds(30, 70, 80, 25);
        adminPanel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(100, 70, 165, 25);
        adminPanel.add(userField);

        passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(30, 110, 80, 25);
        adminPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 110, 165, 25);
        adminPanel.add(passwordField);

        confirmAdminBtn = new JButton("Entrar");
        confirmAdminBtn.setBounds(130, 160, 80, 25);
        confirmAdminBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                adminBtnAction();
            }
        });
        adminPanel.add(confirmAdminBtn);

        successLabel = new JLabel("");
        successLabel.setBounds(100, 190, 300, 25);
        adminPanel.add(successLabel);

        enterClienteBtn = new JButton("Entrar como cliente");
        enterClienteBtn.setBounds(245, 350, 160, 25);
        enterClienteBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                clienteBtnAction();
            }
        });
        panel.add(enterClienteBtn);
    }

    private void clienteBtnAction() {
        Usuario usuario = new Usuario(false);
        new MudarTela(this, new Menu(usuario));
    }

    private void adminBtnAction() {
        String user = userField.getText();
        char[] password = passwordField.getPassword();
        String pass = new String(password);

        if (user.equals("admin") && pass.equals("admin")) {
            Usuario usuario = new Usuario(true);

            new MudarTela(this, new Menu(usuario));
        } else {
            successLabel.setText("Usuário ou senha errados.");
        }
    }
}