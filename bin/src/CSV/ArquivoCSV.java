package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoCSV {
    private String caminho;
    private List<String> nomes;

    public ArquivoCSV(String caminho) {
        this.caminho = caminho;
        this.nomes = new ArrayList<>();
        try {
            ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ler() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha);
            }
        }
    }

    public String[] obterNomes() {
        return nomes.toArray(new String[0]);
    }
}
