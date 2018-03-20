package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	private static int j = 0;
	private static Pizza[] array = new Pizza[100];
	
	public static void main(String[] args){
		Pizza peper = new Pizza(0, "PEP", "Pépéroni", 12.50);
		Pizza marga = new Pizza("MAR", "Margherita", 14.00);
		Pizza reine = new Pizza("REIN", "La_Reine", 11.50);
		Pizza froma = new Pizza("FRO", "La_4_Fromages", 12.00);
		Pizza canni = new Pizza("CAN", "La_Cannibale", 12.50);
		Pizza savoy = new Pizza("SAV", "La_Savoyarde", 13.00);
		Pizza orien = new Pizza("ORI", "L'Orientale", 13.50);
		Pizza indie = new Pizza("IND", "L'Indienne", 14.00);
		
		array[0]=peper; 
		array[1]=marga;
		array[2]=reine; 
		array[3]=froma;
		array[4]=canni; 
		array[5]=savoy;
		array[6]=orien; 
		array[7]=indie;
		
		while(true){
		System.out.println("***** Pizzeria Administration *****"
				+ "\n1. Lister les pizzas"
				+ "\n2. Ajouter une nouvelle pizza"
				+ "\n3. Mettre à jour une pizza"
				+ "\n4. Supprimer une pizza"
				+ "\n99. Sortir");
		Scanner questionUser = new Scanner(System.in);
		int a = Integer.parseInt(questionUser.next());
		if(a==1){
			System.out.println("Liste des pizzas");
			int i=0;
			while(i<array.length){
				if(array[i]!=null){
					System.out.println(array[i].getCode() + "->" + array[i].getLibelle() + " (" + array[i].getPrix() + ")");	
				}
				++i;
			}
		}
		if(a==2){
			String b;
			String c;
			double d;
			int nouvPlace=0;
			System.out.println("Ajout d'une nouvelle pizza");
			System.out.println("Veuillez saisir le code :");
			b = questionUser.next();
			System.out.println("Veuillez saisir le nom (sans espace) :");
			c = questionUser.next();
			System.out.println("Veuillez saisir le prix : ");
			d = Double.parseDouble(questionUser.next());
			Pizza nouv = new Pizza(b, c, d);
			while(array[nouvPlace]!=null){
				++nouvPlace;
			}
			array[nouvPlace]=nouv;
			
		}
		if(a==3){
			String b;
			String c;
			double d;
			int place=0;
			System.out.println("Mise à jour d'une pizza");
			System.out.println("Veuillez choisir le code de la pizza à modifier");
			b = questionUser.next();
			while(!array[place].getCode().contentEquals(b)){
				++place;
			}
			System.out.println("Veuillez saisir le code :");
			b = questionUser.next();
			System.out.println("Veuillez saisir le nom (sans espace) :");
			c = questionUser.next();
			System.out.println("Veuillez saisir le prix : ");	
			d = Double.parseDouble(questionUser.next());
			array[place].setCode(b);
			array[place].setLibelle(c);
			array[place].setPrix(d);
		}
		if(a==4){
			String b;
			int place=0;
			System.out.println("Suppression d'une pizza");
			int i=0;
			while(i<array.length){
				if(array[i]!=null){
					System.out.println(array[i].getCode() + "->" + array[i].getLibelle() + " (" + array[i].getPrix() + ")");	
				}
				++i;
			}
			System.out.println("Veuillez choisir le code de la pizza à supprimer");
			b = questionUser.next();
			while(!array[place].getCode().contentEquals(b)){
				++place;
			}
			array[place]=null;
		}
		if(a==99){
			System.out.println("Aurevoir \u2639");
			break;
		}
		}
	}
}
