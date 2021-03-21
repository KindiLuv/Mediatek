package com.paydiluv.JakartaProject.mediaimpl;

public class Utilisateur implements mediatek2021.Utilisateur {
    private String login;
    private String password;

    public Utilisateur(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public String login() {
        return null;
    }

    @Override
    public String password() {
        return null;
    }

    @Override
    public Object[] data() {
        return new Object[]{login, password};
    }
}
