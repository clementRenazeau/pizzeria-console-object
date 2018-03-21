package fr.pizzeria.model;

public class Pizza {
	private int id;
	private String code;
	private String libelle;
	private double prix;
	private static int compteur=0;
	private CategoriePizza categorie;
	
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie){
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		this.categorie=categorie;
		compteur++;
		this.id=compteur;
	}	
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categorie){
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		this.categorie=categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public CategoriePizza getCategorie() {
		return categorie;
	}
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
