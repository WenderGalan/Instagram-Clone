package com.parse.starter.util;

import java.util.HashMap;

/**
 * Created by Wender Galan Gamer on 12/01/2018.
 */

public class ParseErros {

    private HashMap<Integer, String> erros;

    public ParseErros() {
        this.erros = new HashMap<>();
        this.erros.put(202, "Usuário já existe, escolha outro nome de usuário!");
        this.erros.put(201, "A senha não foi preenchida!");
    }

    public String getErro( int codErro ){
        return this.erros.get(codErro);
    }
}
