package Relatorio;

public abstract class Relatorio {
    private long inicioInsercao;
    private long fimInsercao;
    private long deltaInsercao;
    private long inicioBusca;
    private long fimBusca;
    private long deltaBusca;
    protected int colisões;

    public void iniciarInserção() {
        inicioInsercao = System.nanoTime();
    }

    public void finalizarInserção() {
        fimInsercao = System.nanoTime();
        deltaInsercao = fimInsercao - inicioInsercao;
    }

    public void incrementarColisões() {
        colisões++;
    }

    public void iniciarBusca() {
        inicioBusca = System.nanoTime();
    }

    public void finalizarBusca() {
        fimBusca = System.nanoTime();
        deltaBusca = fimBusca - inicioBusca;
    }

    public void imprimirRelatorio() {
        System.out.println("Tempo de inserção: " + deltaInsercao + "ns");
        System.out.println("Tempo de busca: " + deltaBusca + "ns");
        System.out.println("Colisões: " + colisões);
        chavesPorHash();
    }

    public abstract void chavesPorHash();

    public void comparar(Relatorio outro, String nome, String nomeOutro) {
        System.out.println("Comparação entre " + nome + " e " + nomeOutro);
        if (deltaInsercao < outro.deltaInsercao) {
            System.out.println(nome + " é mais rápido em " + (outro.deltaInsercao - deltaInsercao) + "ns na inserção");
        } else {
            System.out.println(nomeOutro + " é mais rápido em " + (deltaInsercao - outro.deltaInsercao) + "ns na inserção");
        }
        if (deltaBusca < outro.deltaBusca) {
            System.out.println(nome + " é mais rápido em " + (outro.deltaBusca - deltaBusca) + "ns na busca");
        } else {
            System.out.println(nomeOutro + " é mais rápido em " + (deltaBusca - outro.deltaBusca) + "ns na busca");
        }
    }
}
