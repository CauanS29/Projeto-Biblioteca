package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import livraria.backend.Usuario;
import livraria.frontend.MudarTela;

public class MenuAdmin extends JFrame {
    private Usuario usuario;

    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;

    private static JButton adicionarLivroBtn;
    private static JButton removerLivroBtn;
    private static JButton acharLivroBtn;
    private static JButton alterarLivroBtn;

    private static JButton voltarAoMenuBtn;

    public MenuAdmin(Usuario usuario) {
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

        voltarAoMenuBtn = new JButton("Voltar ao menu");
        voltarAoMenuBtn.setBounds(10, 80, 120, 25);
        voltarAoMenuBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                MenuBtnAction();
            }
        });
        panel.add(voltarAoMenuBtn);

        titleLabel = new JLabel("Administrar Livros");
        titleLabel.setBounds(220, 50, 400, 25);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(titleLabel);

        menuListPanel = new JPanel();
        menuListPanel.setLayout(null);
        menuListPanel.setBounds(150, 100, 350, 220);
        menuListPanel.setBackground(Color.lightGray);
        panel.add(menuListPanel);

        adicionarLivroBtn = new JButton("Adicionar Livro");
        adicionarLivroBtn.setBounds(80, 20, 200, 25);
        adicionarLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                adicionarLivroBtnAction();
            }
        });
        menuListPanel.add(adicionarLivroBtn);

        removerLivroBtn = new JButton("Remover Livro");
        removerLivroBtn.setBounds(80, 50, 200, 25);
        removerLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                removerLivroBtnAction();
            }
        });
        menuListPanel.add(removerLivroBtn);

        acharLivroBtn = new JButton("Achar Livro");
        acharLivroBtn.setBounds(80, 80, 200, 25);
        acharLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                acharLivroBtnAction();
            }
        });
        menuListPanel.add(acharLivroBtn);

        alterarLivroBtn = new JButton("Alterar Livro");
        alterarLivroBtn.setBounds(80, 110, 200, 25);
        alterarLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                alterarLivroBtnAction();
            }
        });
        menuListPanel.add(alterarLivroBtn);
    }

    private void MenuBtnAction() {
        new MudarTela(this, new Menu(usuario));
    }

    private void adicionarLivroBtnAction() {
        new MudarTela(this, new TelaAdicionaLivro(usuario));
    }

    private void removerLivroBtnAction() {
        new MudarTela(this, new TelaRemoveLivro(usuario));
    }

    private void acharLivroBtnAction() {
        new MudarTela(this, new TelaAchaLivro(usuario));
    }

    private void alterarLivroBtnAction() {
        new MudarTela(this, new TelaAlteraLivro(usuario));
    }
}