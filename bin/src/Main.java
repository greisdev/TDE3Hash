import CSV.ArquivoCSV;
import TabelasHash.TabelaHashFuncaoA;
import TabelasHash.TabelaHashFuncaoB;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "female_names.csv";
        ArquivoCSV leitor = new ArquivoCSV(caminhoArquivo);
        
        int qtdInserir = 5000;
        int qtdBuscar = 500;
        
        // Obter nomes para inserção e busca
        String[] nomesParaInserir = new String[qtdInserir];
        for (int i = 0; i < qtdInserir; i++) {
            nomesParaInserir[i] = leitor.obterNomes()[i];
        }
        
        String[] nomesParaBuscar = new String[qtdBuscar];
        int indiceAleatorio = (int) (Math.random() * (4999 - qtdBuscar));
        for (int i = 0; i < qtdBuscar; i++) {
            nomesParaBuscar[i] = leitor.obterNomes()[(indiceAleatorio + i) % 5000];
        }

        // Criar e testar Tabela Hash Funcao A
        int tamanho = qtdInserir * 2;
        TabelaHashFuncaoA tabelaA = new TabelaHashFuncaoA(tamanho);
        tabelaA.inserirTodos(nomesParaInserir);
        tabelaA.buscarTodos(nomesParaBuscar);
        System.out.println("Relatório da Tabela A:");
        tabelaA.imprimirRelatorio();

        // Criar e testar Tabela Hash Funcao B
        TabelaHashFuncaoB tabelaB = new TabelaHashFuncaoB(tamanho);
        tabelaB.inserirTodos(nomesParaInserir);
        tabelaB.buscarTodos(nomesParaBuscar);
        System.out.println("Relatório da Tabela B:");
        tabelaB.imprimirRelatorio();

        // Comparar as tabelas
        tabelaA.comparar(tabelaB, "Tabela A", "Tabela B");
    }
}
