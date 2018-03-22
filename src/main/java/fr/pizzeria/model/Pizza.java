package fr.pizzeria.model;

import java.lang.reflect.Field;

import fr.pizzeria.utils.ToString;

public class Pizza {
	private int id;
	@ToString(separateur="->", uppercase=true)
	private String code;
	@ToString(separateur=" ", uppercase=false)
	private String libelle;
	@ToString(separateur="€", uppercase=false)
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
	public String toString(){
		Class<Pizza> cl = Pizza.class;
		Field[] attributs = cl.getDeclaredFields();
		
		String chaine = "";
		
		try{
			//boucle sur les attributs
			for(Field attr : attributs){
				//Permet de vérifier si une annotation est présente sur l'attribut
				if(attr.isAnnotationPresent(ToString.class)){
					//Je récupère l'annotation ToString
					ToString annotation = attr.getAnnotation(ToString.class);
					//Je récupère la valeur de la propritété toUpperCase de l'annotation
					boolean uppercase = annotation.uppercase();
					//Récupération de la valeur de l'attribut pour l'instance courante
					Object value=attr.get(this);
					//Récupération du séparateur
					String sepa = annotation.separateur();
					
					String valueStr = value.toString();
					if(uppercase){
						valueStr = valueStr.toUpperCase();
					}
					//Ajout de la valeur de l'attribut à la chaine de caractères
					chaine += valueStr + sepa;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return chaine;				
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
