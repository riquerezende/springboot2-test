package henrique.springboot2test.enumeration;

public enum TipoTransacao {

    SAQUE("SAQUE"),
    DEPOSITO("DEPOSITO");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
