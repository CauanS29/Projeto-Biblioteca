package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import livraria.backend.Usuario;
import livraria.frontend.MudarTela;

public class Menu extends JFrame {
    private Usuario usuario;
    private String permissaoDeUsuario;

    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;
    private static JLabel userLabel;

    private static JButton carrinhoBtn;
    private static JButton achaLivroBtn;
    private static JButton administrarLivrosBtn;
    private static JLabel permissionDeniedLabel;

    private static JButton voltarAoLoginBtn;

    public Menu(Usuario usuario) {
        this.usuario = usuario;
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

        permissaoDeUsuario = usuario.getPermissao() ? "Admin" : "Cliente";

        userLabel = new JLabel("Usuário: " + this.permissaoDeUsuario);
        userLabel.setBounds(20, 50, 150, 25);
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setForeground(Color.white);
        panel.add(userLabel);

        voltarAoLoginBtn = new JButton("Sair");
        voltarAoLoginBtn.setBounds(20, 80, 60, 25);
        voltarAoLoginBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                loginBtnAction();
            }
        });
        panel.add(voltarAoLoginBtn);

        titleLabel = new JLabel("Menu da livraria");
        titleLabel.setBounds(220, 50, 400, 25);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(titleLabel);

        menuListPanel = new JPanel();
        menuListPanel.setLayout(null);
        menuListPanel.setBounds(150, 100, 350, 220);
        menuListPanel.setBackground(Color.lightGray);
        panel.add(menuListPanel);

        carrinhoBtn = new JButton("Carrinho de compras");
        carrinhoBtn.setBounds(80, 20, 200, 25);
        carrinhoBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                carrinhoBtnAction();
            }
        });
        menuListPanel.add(carrinhoBtn);

        achaLivroBtn = new JButton("Achar livro");
        achaLivroBtn.setBounds(80, 50, 200, 25);
        achaLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                achaLivroBtnAction();
            }
        });
        menuListPanel.add(achaLivroBtn);

        administrarLivrosBtn = new JButton("Administrar Livros");
        administrarLivrosBtn.setBounds(80, 80, 200, 25);
        administrarLivrosBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                administrarLivrosBtnAction();
            }
        });
        menuListPanel.add(administrarLivrosBtn);

        permissionDeniedLabel = new JLabel("");
        permissionDeniedLabel.setBounds(100, 180, 200, 25);
        menuListPanel.add(permissionDeniedLabel);
    }

    private void loginBtnAction() {
        new MudarTela(this, new TelaLogin());
    }

    private void achaLivroBtnAction(){
        new MudarTela(this, new TelaAchaLivro(this.usuario));
    }

    private void carrinhoBtnAction() {
        new MudarTela(this, new TelaCarrinho(this.usuario));
    }

    private void administrarLivrosBtnAction() {
        if (usuario.getPermissao()) {
            new MudarTela(this, new MenuAdmin(usuario));
        } else {
            permissionDeniedLabel.setText("Usuário precisa ser Admin");
        }
    }
}