//Luis Felipe Dos Santos

package org.example.model.utils;

public enum Situacao {

    VENDA_REALIZADA("VENDA REALIZADA"),
    VENDA_NAO_REALIZADA("VENDA NÃO REALIZADA");

    private final String VENDA;

    Situacao(String VENDA) {
        this.VENDA = VENDA;
    }

    public String getVENDA() {
        return VENDA;
    }
}
