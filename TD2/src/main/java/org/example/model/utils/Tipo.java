//Luis Felipe Dos Santos

package org.example.model.utils;

public enum Tipo {
    TERRENO("TERRENO"),
    CASA("CASA"),
    APARTAMENTO("APARTAMENTO"),
    SALA("SALA"),
    LOJA("LOJA");

    private final String TIPODEIMOVEL;
    
    Tipo(String TIPODEIMOVEL) {
        this.TIPODEIMOVEL = TIPODEIMOVEL;
    }

    public String getTipoDeApartamento() {
        return TIPODEIMOVEL;
    }
}
