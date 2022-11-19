package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.*;

import livraria.backend.EstoqueDeLivro;
import livraria.backend.Usuario;
import livraria.backend.produtos.Livro;
import livraria.frontend.MudarTela;

public class TelaAchaLivro extends JFrame {
    private Usuario usuario;

    private static JButton voltarAoMenuBtn;
    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;

    private static JLabel nomeDoLivroLabel;
    private static JTextField nomeDoLivroField;

    private static JButton acharLivroBtn;
    private static JLabel acharLivroLabel;

    private static JLabel nomeDoLivroAchadoLabel;

    private static JLabel descricaoLabel;

    private static JLabel valorLabel;

    private static JLabel quantidadeLabel;

    private static JLabel isbnLabel;

    private static JLabel autorLabel;

    private static JLabel impressoLabel;

    private static JLabel miniLabel;

    public TelaAchaLivro(Usuario usuario) {
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

        titleLabel = new JLabel("Achar Livro");
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
        menuListPanel.setBounds(150, 100, 350, 330);
        menuListPanel.setBackground(Color.lightGray);
        panel.add(menuListPanel);

        nomeDoLivroLabel = new JLabel("Nome do livro para achar:");
        nomeDoLivroLabel.setBounds(20, 20, 250, 25);
        menuListPanel.add(nomeDoLivroLabel);

        nomeDoLivroField = new JTextField();
        nomeDoLivroField.setBounds(20, 50, 100, 25);
        menuListPanel.add(nomeDoLivroField);

        acharLivroBtn = new JButton("Achar livro");
        acharLivroBtn.setBounds(200, 20, 130, 25);
        acharLivroBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        acharLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                achaLivroBtnAction();
            }
        });
        menuListPanel.add(acharLivroBtn);

        acharLivroLabel = new JLabel("");
        acharLivroLabel.setBounds(200, 50, 130, 25);
        menuListPanel.add(acharLivroLabel);

        nomeDoLivroAchadoLabel = new JLabel("");
        nomeDoLivroAchadoLabel.setBounds(20, 80, 300, 25);
        menuListPanel.add(nomeDoLivroAchadoLabel);

        descricaoLabel = new JLabel("");
        descricaoLabel.setBounds(20, 110, 300, 25);
        menuListPanel.add(descricaoLabel);

        valorLabel = new JLabel("");
        valorLabel.setBounds(20, 140, 300, 25);
        menuListPanel.add(valorLabel);

        quantidadeLabel = new JLabel("");
        quantidadeLabel.setBounds(20, 170, 300, 25);
        menuListPanel.add(quantidadeLabel);

        isbnLabel = new JLabel("");
        isbnLabel.setBounds(20, 200, 300, 25);
        menuListPanel.add(isbnLabel);

        autorLabel = new JLabel("");
        autorLabel.setBounds(20, 230, 300, 25);
        menuListPanel.add(autorLabel);

        impressoLabel = new JLabel("");
        impressoLabel.setBounds(20, 260, 300, 25);
        menuListPanel.add(impressoLabel);

        miniLabel = new JLabel("");
        miniLabel.setBounds(20, 290, 300, 25);
        menuListPanel.add(miniLabel);
    }

    private void menuBtnAction() {
        if (usuario.getPermissao()){
            new MudarTela(this, new MenuAdmin(usuario));
        } else {
            new MudarTela(this, new Menu(usuario));
        }
    }

    private void achaLivroBtnAction() {
        Boolean checaCampos = nomeDoLivroField.getText().isEmpty();

        if (checaCampos) {
            acharLivroLabel.setText("Preencha os campos");
        } else {
            String nome = nomeDoLivroField.getText();
            Livro livro = EstoqueDeLivro.achaLivro(nome);

            if (livro == null) {
                acharLivroLabel.setText("Livro não existe");
            } else {
                String descricao = livro.getDescricao();
                String valor = livro.getValorString();
                String quantidade = livro.getQuantidadeString();
                String isbn = livro.getIsbn();
                String autor = livro.getAutor().getNome();
                String impresso = livro.isImpresso() ? "Sim" : "Não";
                
                String mini = livro.isMini() ? "Sim" : "Não";
                
                nomeDoLivroAchadoLabel.setText("Nome: " + nome);
                descricaoLabel.setText("Descricao: " + descricao);
                valorLabel.setText("Valor: " + valor);
                quantidadeLabel.setText("Quantidade: " + quantidade);
                isbnLabel.setText("Isbn: " + isbn);
                autorLabel.setText("Autor: " + autor);
                impressoLabel.setText("Impresso: " + impresso);
                miniLabel.setText("Mini: "  + mini);
            }
        }
    }
}
