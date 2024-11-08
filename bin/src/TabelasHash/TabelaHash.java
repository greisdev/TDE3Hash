package TabelasHash;

import Relatorio.Relatorio;
import java.util.Arrays;

public abstract class TabelaHash extends Relatorio {
    protected String[] tabela;
    protected int tamanhoAtual;

    public TabelaHash(int tamanho) {
        tabela = new String[tamanho];
        tamanhoAtual = 0;
        colisões = 0;
    }

    public abstract int funcaoHash(String valor);

    public boolean estaCheia() {
        return tamanhoAtual == tabela.length;
    }

    public void aumentarTamanho() {
        tabela = Arrays.copyOf(tabela, tabela.length * 2);
    }

    public void inserir(String valor) {
        if (estaCheia()) {
            aumentarTamanho();
        }
        int indice = funcaoHash(valor);
        while (tabela[indice] != null) {
            incrementarColisões();
            indice = (indice + 1) % tabela.length;
        }
        tamanhoAtual++;
        tabela[indice] = valor;
    }

    public void inserirTodos(String[] valores) {
        iniciarInserção();
        for (String valor : valores) {
            inserir(valor);
        }
        finalizarInserção();
    }

    public boolean buscar(String valor) {
        int indice = funcaoHash(valor);
        while (tabela[indice] != null && !tabela[indice].equals(valor)) {
            indice = (indice + 1) % tabela.length;
        }
        return tabela[indice] != null;
    }

    public void buscarTodos(String[] valores) {
        iniciarBusca();
        for (String valor : valores) {
            buscar(valor);
        }
        finalizarBusca();
    }

    public void deletar(String valor) {
        int indice = funcaoHash(valor);
        while (tabela[indice] != null && !tabela[indice].equals(valor)) {
            indice = (indice + 1) % tabela.length;
        }
        if (tabela[indice] != null) {
            tabela[indice] = null;
            indice = (indice + 1) % tabela.length;
            while (tabela[indice] != null) {
                String temporario = tabela[indice];
                tabela[indice] = null;
                inserir(temporario);
                indice = (indice + 1) % tabela.length;
            }
        }
    }

    public void chavesPorHash() {
        int[] chavesPorHash = new int[tabela.length];
        for (String chave : tabela) {
            if (chave != null) {
                chavesPorHash[funcaoHash(chave)]++;
            }
        }
        System.out.println("Distribuição das chaves:");
        System.out.println(Arrays.toString(chavesPorHash));
    }

    public void imprimir() {
        System.out.println(Arrays.toString(tabela));
    }

    public String toString() {
        return Arrays.toString(tabela);
    }
}
