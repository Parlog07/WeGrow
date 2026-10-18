package com.wegrow.entity;


public class Employe {

    private Long id;
    private String matricule;

    private String nom;

    private String prenom;

    private String poste;

    private Departement departement;

    public Employe(Departement departement, Long id, String nom, String matricule, String prenom, String poste) {
        this.departement = departement;
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.prenom = prenom;
        this.poste = poste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Employe() {
    }

}
