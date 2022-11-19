package livraria.frontend;

import javax.swing.JFrame;

public class MudarTela {
    private JFrame telaAtual;
    private JFrame telaNova;

    public MudarTela(JFrame atual, JFrame nova){
        this.telaAtual = atual;
        this.telaNova = nova;
        trocaTela();
    }

    private void trocaTela(){
        this.telaAtual.dispose();
        this.telaNova.setVisible(true);
    }
}