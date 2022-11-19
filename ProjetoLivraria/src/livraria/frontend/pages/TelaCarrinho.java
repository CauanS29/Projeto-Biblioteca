package livraria.frontend.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import livraria.backend.EstoqueDeLivro;
import livraria.backend.Usuario;
import livraria.backend.produtos.Livro;
import livraria.frontend.MudarTela;

public class TelaCarrinho extends JFrame {
    private Usuario usuario;

    private static JButton voltarAoMenuBtn;
    private static JPanel panel;
    private static JPanel menuListPanel;
    private static JLabel titleLabel;

    private static JLabel nomeDoLivroLabel;
    private static JTextField nomeDoLivroField;

    private static JLabel quantidadeLabel;
    private static JTextField quantidadeField;

    private static JLabel totalDeLivrosLabel;
    private static JLabel precoTotalLabel;

    private static JButton adicionarLivroAoCarrinhoBtn;
    private static JButton removerLivroDoCarrinhoBtn;

    private static JLabel mensagemAdicionarLivroAoCarrinho;
    private static JLabel mensagemRemoverLivroDoCarrinho;

    private static JButton finalizarCompraBtn;
    private static JLabel mensagemFinalizarCompra;

    public TelaCarrinho(Usuario usuario) {
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

        titleLabel = new JLabel("Carrinho");
        titleLabel.setBounds(220, 50, 150, 25);
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
        nomeDoLivroLabel.setBounds(20, 20, 50, 25);
        menuListPanel.add(nomeDoLivroLabel);

        nomeDoLivroField = new JTextField();
        nomeDoLivroField.setBounds(90, 20, 100, 25);
        menuListPanel.add(nomeDoLivroField);

        quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setBounds(20, 60, 80, 25);
        menuListPanel.add(quantidadeLabel);

        quantidadeField = new JTextField();
        quantidadeField.setBounds(90, 60, 100, 25);
        quantidadeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        menuListPanel.add(quantidadeField);

        totalDeLivrosLabel = new JLabel("Livros: " + usuario.getCarrinho().getQtdProdutos());
        totalDeLivrosLabel.setBounds(220, 20, 150, 25);
        menuListPanel.add(totalDeLivrosLabel);

        precoTotalLabel = new JLabel("Preço: " + usuario.getCarrinho().getPrecoTotal());
        precoTotalLabel.setBounds(220, 60, 150, 25);
        menuListPanel.add(precoTotalLabel);

        adicionarLivroAoCarrinhoBtn = new JButton("Adicionar livro ao carrinho");
        adicionarLivroAoCarrinhoBtn.setBounds(60, 110, 250, 25);
        adicionarLivroAoCarrinhoBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        adicionarLivroAoCarrinhoBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                try {
                    adicionarLivroAoCarrinhoBtnAction();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });
        menuListPanel.add(adicionarLivroAoCarrinhoBtn);

        mensagemAdicionarLivroAoCarrinho = new JLabel("");
        mensagemAdicionarLivroAoCarrinho.setBounds(60, 140, 250, 25);
        menuListPanel.add(mensagemAdicionarLivroAoCarrinho);

        removerLivroDoCarrinhoBtn = new JButton("Remover livro do carrinho");
        removerLivroDoCarrinhoBtn.setBounds(60, 170, 250, 25);
        removerLivroDoCarrinhoBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        removerLivroDoCarrinhoBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                try {
                    removerLivroDoCarrinhoBtnAction();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });
        menuListPanel.add(removerLivroDoCarrinhoBtn);

        mensagemRemoverLivroDoCarrinho = new JLabel("");
        mensagemRemoverLivroDoCarrinho.setBounds(60, 200, 250, 25);
        menuListPanel.add(mensagemRemoverLivroDoCarrinho);

        finalizarCompraBtn = new JButton("Finalizar compra");
        finalizarCompraBtn.setBounds(60, 230, 250, 25);
        finalizarCompraBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        finalizarCompraBtn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                finalizarCompraBtnAction();
            }
        });
        menuListPanel.add(finalizarCompraBtn);

        mensagemFinalizarCompra = new JLabel("");
        mensagemFinalizarCompra.setBounds(60, 260, 250, 25);
        menuListPanel.add(mensagemFinalizarCompra);
    }

    private void menuBtnAction() {
        new MudarTela(this, new Menu(usuario));
    }

    private void finalizarCompraBtnAction() {
        if (usuario.getCarrinho().getQtdProdutos() == 0) {
            mensagemFinalizarCompra.setText("Carrinho vazio, adicione produtos");
        } else {
            usuario.getCarrinho().finalizarCompra();
            totalDeLivrosLabel.setText("Livros: " + usuario.getCarrinho().getQtdProdutos());
            precoTotalLabel.setText("Preço: " + usuario.getCarrinho().getPrecoTotal());
            mensagemFinalizarCompra.setText("Compra finalizada");
        }
    }

    private void adicionarLivroAoCarrinhoBtnAction() throws CloneNotSupportedException {
        String nome = nomeDoLivroField.getText();
        String quantidadeString = quantidadeField.getText();

        Boolean checaCampos = (nome.isEmpty() ||
                quantidadeString.isEmpty());

        if (checaCampos) {
            mensagemAdicionarLivroAoCarrinho.setText("Preencha os campos");
        } else {
            int quantidade = Integer.parseInt(quantidadeField.getText());
            Livro livro = EstoqueDeLivro.achaLivro(nome);

            if (livro == null) {
                mensagemAdicionarLivroAoCarrinho.setText("Livro não encontrado");
            } else {
                if (quantidade >= livro.getQuantidade()) {
                    quantidade = livro.getQuantidade();
                }
                Livro livroDoCarrinho = (Livro) livro.clone();
                livroDoCarrinho.setQuantidade(quantidade);

                if (usuario.getCarrinho().achaLivro(nome) != null) {
                    usuario.getCarrinho().adicionaQtdLivros(nome, quantidade);
                } else {
                    usuario.getCarrinho().adicionaLivro(nome, livroDoCarrinho);
                }

                EstoqueDeLivro.removeLivro(nome, quantidade);

                mensagemAdicionarLivroAoCarrinho.setText(quantidade + " livros " + nome + " adicionados ao carrinho");

                totalDeLivrosLabel.setText("Livros: " + usuario.getCarrinho().getQtdProdutos());
                precoTotalLabel.setText("Preço: " + usuario.getCarrinho().getPrecoTotal());
            }
        }
    }

    private void removerLivroDoCarrinhoBtnAction() throws CloneNotSupportedException {
        String nome = nomeDoLivroField.getText();
        String quantidadeString = quantidadeField.getText();

        Boolean checaCampos = (nome.isEmpty() ||
                quantidadeString.isEmpty());

        if (checaCampos) {
            mensagemRemoverLivroDoCarrinho.setText("Preencha os campos");
        } else {
            int quantidade = Integer.parseInt(quantidadeField.getText());
            Livro livro = usuario.getCarrinho().achaLivro(nome);

            if (livro == null) {
                mensagemRemoverLivroDoCarrinho.setText("Livro não encontrado");
            } else {
                if (quantidade >= livro.getQuantidade()) {
                    quantidade = livro.getQuantidade();
                }
                Livro livroDoEstoque = (Livro) livro.clone();
                livroDoEstoque.setQuantidade(quantidade);

                if (EstoqueDeLivro.achaLivro(nome) != null) {
                    EstoqueDeLivro.adicionaQtdLivros(nome, quantidade);
                } else {
                    EstoqueDeLivro.adicionaLivro(nome, livroDoEstoque);
                }

                usuario.getCarrinho().removeLivro(nome, quantidade);

                mensagemRemoverLivroDoCarrinho.setText(quantidade + " livros " + nome + " removidos do carrinho");

                totalDeLivrosLabel.setText("Livros: " + usuario.getCarrinho().getQtdProdutos());
                precoTotalLabel.setText("Preço: " + usuario.getCarrinho().getPrecoTotal());
            }
        }
    }
}
