package TabelasHash;

public class TabelaHashFuncaoB extends TabelaHash {
    public TabelaHashFuncaoB(int tamanho) {
        super(tamanho);
    }

    @Override
    public int funcaoHash(String valor) {
        int hash = 0;
        for (int i = 0; i < valor.length(); i++) {
            hash += valor.charAt(i) * (31 ^ i);
        }
        return Math.abs(hash) % tabela.length;
    }
}
