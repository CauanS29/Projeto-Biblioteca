package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.*;

import livraria.backend.EstoqueDeLivro;
import livraria.backend.Usuario;
import livraria.backend.produtos.Livro;
import livraria.frontend.MudarTela;

public class TelaRemoveLivro extends JFrame {
    private Usuario usuario;

    private static JButton voltarAoMenuBtn;
    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;

    private static JLabel nomeDoLivroLabel;
    private static JTextField nomeDoLivroField;

    private static JLabel quantidadeLabel;
    private static JTextField quantidadeField;

    private static JButton removerLivroBtn;

    private static JLabel mensagemRemoverLivro;

    public TelaRemoveLivro(Usuario usuario) {
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

        titleLabel = new JLabel("Remover Livro");
        titleLabel.setBounds(150, 50, 270, 25);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(titleLabel);

        voltarAoMenuBtn = new JButton("Voltar ao Menu");
        voltarAoMenuBtn.setBounds(400, 50, 150, 25);
        voltarAoMenuBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                menuBtnAction();
            }
        });
        panel.add(voltarAoMenuBtn);

        menuListPanel = new JPanel();
        menuListPanel.setLayout(null);
        menuListPanel.setBounds(150, 100, 350, 300);
        menuListPanel.setBackground(Color.lightGray);
        panel.add(menuListPanel);

        nomeDoLivroLabel = new JLabel("Nome:");
        nomeDoLivroLabel.setBounds(20, 60, 50, 25);
        menuListPanel.add(nomeDoLivroLabel);

        nomeDoLivroField = new JTextField();
        nomeDoLivroField.setBounds(90, 60, 100, 25);
        menuListPanel.add(nomeDoLivroField);

        quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setBounds(20, 100, 80, 25);
        menuListPanel.add(quantidadeLabel);

        quantidadeField = new JTextField();
        quantidadeField.setBounds(90, 100, 100, 25);
        quantidadeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        menuListPanel.add(quantidadeField);

        removerLivroBtn = new JButton("Remover livro");
        removerLivroBtn.setBounds(200, 140, 130, 25);
        removerLivroBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        removerLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                removerLivroBtnAction();
            }
        });
        menuListPanel.add(removerLivroBtn);

        mensagemRemoverLivro = new JLabel("");
        mensagemRemoverLivro.setBounds(150, 170, 180, 25);
        menuListPanel.add(mensagemRemoverLivro);
    }

    private void menuBtnAction() {
        new MudarTela(this, new MenuAdmin(usuario));
    }

    private void removerLivroBtnAction() {
        String nome = nomeDoLivroField.getText();
        String quantidadeString = quantidadeField.getText();

        Boolean checaCampos = (nome.isEmpty() ||
                quantidadeString.isEmpty());

        if (checaCampos) {
            mensagemRemoverLivro.setText("Preencha os campos");
        } else {
            int quantidade = Integer.parseInt(quantidadeString);
            Livro livro = EstoqueDeLivro.achaLivro(nome);

            if (livro == null) {
                mensagemRemoverLivro.setText("Livro não existe");
            } else {
                EstoqueDeLivro.removeLivro(nome, quantidade);
                Livro livroRemovido = EstoqueDeLivro.achaLivro(nome);
                if (livroRemovido == null){
                    mensagemRemoverLivro.setText("Livro removido do estoque");
                } else{
                    mensagemRemoverLivro.setText(quantidadeString + " livros removidos do estoque");
                }
                
            }
        }
    }
}
