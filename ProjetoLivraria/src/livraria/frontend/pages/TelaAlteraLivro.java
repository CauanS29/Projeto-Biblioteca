package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.*;

import livraria.backend.Autor;
import livraria.backend.EstoqueDeLivro;
import livraria.backend.Usuario;
import livraria.backend.produtos.Ebook;
import livraria.backend.produtos.LivroFisico;
import livraria.backend.produtos.MiniLivro;
import livraria.frontend.MudarTela;

public class TelaAlteraLivro extends JFrame {
    private Usuario usuario;

    private static JLabel selectLivroLabel;
    private static JComboBox<String> selectLivroBox;

    private static JLabel nomeDoLivroLabel;
    private static JTextField nomeDoLivroField;

    private static JLabel descricaoLabel;
    private static JTextField descricaoField;

    private static JLabel valorLabel;
    private static JTextField valorField;

    private static JLabel quantidadeLabel;
    private static JTextField quantidadeField;

    private static JLabel isbnLabel;
    private static JTextField isbnField;

    private static JLabel autorLabel;
    private static JTextField autorField;

    private static JButton voltarAoMenuBtn;
    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;

    private static JButton alterarLivroBtn;
    private static JLabel alterarLivroLabel;

    public TelaAlteraLivro(Usuario usuario) {
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

        titleLabel = new JLabel("Altera Livro");
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
        menuListPanel.setBounds(150, 100, 350, 350);
        menuListPanel.setBackground(Color.lightGray);
        panel.add(menuListPanel);

        selectLivroLabel = new JLabel("Selecione o tipo de livro:");
        selectLivroLabel.setBounds(20, 20, 160, 25);
        menuListPanel.add(selectLivroLabel);

        String tiposDeLivros[] = { "Livro físico", "Ebook", "Mini Livro" };
        selectLivroBox = new JComboBox<String>(tiposDeLivros);
        selectLivroBox.setBounds(190, 20, 90, 25);
        menuListPanel.add(selectLivroBox);

        nomeDoLivroLabel = new JLabel("Nome do livro para achar:");
        nomeDoLivroLabel.setBounds(20, 60, 250, 25);
        menuListPanel.add(nomeDoLivroLabel);

        nomeDoLivroField = new JTextField();
        nomeDoLivroField.setBounds(20, 90, 100, 25);
        menuListPanel.add(nomeDoLivroField);

        descricaoLabel = new JLabel("Descricao:");
        descricaoLabel.setBounds(20, 140, 80, 25);
        menuListPanel.add(descricaoLabel);

        descricaoField = new JTextField();
        descricaoField.setBounds(90, 140, 100, 25);
        menuListPanel.add(descricaoField);

        valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(20, 180, 50, 25);
        menuListPanel.add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(90, 180, 100, 25);
        valorField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    e.consume();
                }
                if ((valorField.getText().contains(".")) && c == '.') {
                    e.consume();
                }
                if (valorField.getText().isEmpty() && (c == '.') && ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        menuListPanel.add(valorField);

        quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setBounds(20, 220, 100, 25);
        menuListPanel.add(quantidadeLabel);

        quantidadeField = new JTextField();
        quantidadeField.setBounds(90, 220, 100, 25);
        quantidadeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (quantidadeField.getText().isEmpty() && ((c < '1') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        menuListPanel.add(quantidadeField);

        isbnLabel = new JLabel("Isbn:");
        isbnLabel.setBounds(20, 260, 50, 25);
        menuListPanel.add(isbnLabel);

        isbnField = new JTextField();
        isbnField.setBounds(90, 260, 100, 25);
        isbnField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '-')) {
                    e.consume();
                }
            }
        });
        menuListPanel.add(isbnField);

        autorLabel = new JLabel("Autor:");
        autorLabel.setBounds(20, 300, 80, 25);
        menuListPanel.add(autorLabel);

        autorField = new JTextField();
        autorField.setBounds(90, 300, 100, 25);
        menuListPanel.add(autorField);

        alterarLivroBtn = new JButton("Alterar livro");
        alterarLivroBtn.setBounds(200, 140, 130, 25);
        alterarLivroBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        alterarLivroBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                alteraLivroBtnAction();
            }
        });
        menuListPanel.add(alterarLivroBtn);

        alterarLivroLabel = new JLabel("");
        alterarLivroLabel.setBounds(200, 170, 130, 25);
        menuListPanel.add(alterarLivroLabel);
    }

    private void menuBtnAction() {
        new MudarTela(this, new MenuAdmin(usuario));
    }

    private void alteraLivroBtnAction() {
        Boolean checaCampos = (nomeDoLivroField.getText().isEmpty() ||
                descricaoField.getText().isEmpty() ||
                valorField.getText().isEmpty() ||
                quantidadeField.getText().isEmpty() ||
                isbnField.getText().isEmpty() ||
                autorField.getText().isEmpty());

        if (checaCampos) {
            alterarLivroLabel.setText("Preencha os campos");
        } else {
            String nome = nomeDoLivroField.getText();

            if (EstoqueDeLivro.achaLivro(nome) != null) {
                String livroSelecionado = selectLivroBox.getItemAt(selectLivroBox.getSelectedIndex());
                String nomeDoAutor = autorField.getText();
                String descricao = descricaoField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());
                String isbn = isbnField.getText();

                double valor = Double.parseDouble(valorField.getText());

                Autor autor = new Autor();
                autor.setNome(nomeDoAutor);

                switch (livroSelecionado) {
                    case "Livro físico":
                        LivroFisico livroFisico = new LivroFisico(autor);
                        livroFisico.setNome(nome);
                        livroFisico.setDescricao(descricao);
                        livroFisico.setIsbn(isbn);
                        livroFisico.setValor(valor);
                        livroFisico.setQuantidade(quantidade);

                        EstoqueDeLivro.alteraLivro(nome, livroFisico);
                        break;
                    case "Ebook":
                        Ebook ebook = new Ebook(autor);
                        ebook.setNome(nome);
                        ebook.setDescricao(descricao);
                        ebook.setIsbn(isbn);
                        ebook.setValor(valor);
                        ebook.setQuantidade(quantidade);

                        EstoqueDeLivro.alteraLivro(nome, ebook);
                        break;
                    case "Mini Livro":
                        MiniLivro miniLivro = new MiniLivro(autor);
                        miniLivro.setNome(nome);
                        miniLivro.setDescricao(descricao);
                        miniLivro.setIsbn(isbn);
                        miniLivro.setValor(valor);
                        miniLivro.setQuantidade(quantidade);

                        EstoqueDeLivro.alteraLivro(nome, miniLivro);
                        break;
                    default:
                        break;
                }

                alterarLivroLabel.setText("Livro alterado");
            } else {
                alterarLivroLabel.setText("Livro não existe");
            }
        }
    }
}
