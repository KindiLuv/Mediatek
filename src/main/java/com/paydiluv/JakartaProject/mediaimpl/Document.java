package com.paydiluv.JakartaProject.mediaimpl;

public class Document implements mediatek2021.Document {
    private String titre;
    private String auteur;
    private int cat;
    private int id;

    public Document(String titre, String auteur, int cat, int id){
        this.auteur=auteur;
        this.cat=cat;
        this.titre=titre;
        this.id=id;
    }
    @Override
    public Object[] data() {
        return new Object[]{titre, auteur, cat, id};
    }
}
