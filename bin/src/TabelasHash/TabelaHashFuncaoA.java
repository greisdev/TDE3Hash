package TabelasHash;

public class TabelaHashFuncaoA extends TabelaHash {
    public TabelaHashFuncaoA(int tamanho) {
        super(tamanho);
    }

    @Override
    public int funcaoHash(String valor) {
        int hash = 0;
        for (int i = 0; i < valor.length(); i++) {
            hash += valor.charAt(i);
        }
        return hash % tabela.length;
    }
}
