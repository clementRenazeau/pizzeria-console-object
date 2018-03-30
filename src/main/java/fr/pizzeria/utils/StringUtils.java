package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class StringUtils {
	public static String toString(Object o){
		Class<?> cl = o.getClass();
		Field[] attributs = cl.getDeclaredFields();
		
		String chaine = "";
		
		try{
			//boucle sur les attributs
			for(Field attr : attributs){
				//Les champs sont privés mais on peut y accéder quand même
				attr.setAccessible(true);
				//Permet de vérifier si une annotation est présente sur l'attribut
				if(attr.isAnnotationPresent(ToString.class)){
					//Je récupère l'annotation ToString
					ToString annotation = attr.getAnnotation(ToString.class);
					//Je récupère la valeur de la propritété toUpperCase de l'annotation
					boolean uppercase = annotation.uppercase();
					//Récupération de la valeur de l'attribut pour l'instance courante
					Object value=attr.get(o);
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
}
