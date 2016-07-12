package com.example.a41665767.tp3;

/**
 * Created by 41665767 on 28/6/2016.
 */
public class Jugada {
    public String username;
    public String secuencia;
    public int clicks;

    public Jugada(String username, String secuencia, int jugada) {
        this.username = username;
        this.secuencia = secuencia;
        this.clicks = jugada;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }
}

