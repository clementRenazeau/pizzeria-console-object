package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	private static int temp = 0;
	private static int[] array = new int[0];
	
	public static void main(String[] args){
		while(true){//boucle infinie qui peut �tre arr�ter si on tape 3 au moment du choix
		System.out.println("***** Pizzeria Administration *****"
				+ "\n1. Lister les pizzas"
				+ "\n2. Ajouter une nouvelle pizza"
				+ "\n3. Mettre à jour une pizza"
				+ "\n4. Supprimer une pizza"
				+ "\n99. Sortir");
		Scanner questionUser = new Scanner(System.in);
		int a = questionUser.nextInt();
		if(a==1){
			System.out.println("Liste des pizzas");
		}
		if(a==2){
			System.out.println("Ajout d'une nouvelle pizza");
		}
		if(a==3){
			System.out.println("Mise à jour d'une pizza");
		}
		if(a==4){
			System.out.println("Suppression d'une pizza");
		}
		if(a==99){
			System.out.println("Aurevoir \u2639");
			break;
		}
		}
	}
}
