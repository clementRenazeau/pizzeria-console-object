package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJDBCDao implements PizzaDao{
	public PizzaJDBCDao(){
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		try {
			PreparedStatement creationBase = conn.prepareStatement("DELETE FROM pizza");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS pizza (ID INT NOT NULL AUTO_INCREMENT, CODE_PIZZA CHAR(5) NOT NULL, NOM TEXT NOT NULL, PRIX DECIMAL(4,2) UNSIGNED NOT NULL, CATEGORIE_PIZZA TEXT NOT NULL, PRIMARY KEY(ID), UNIQUE KEY(CODE_PIZZA))");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('PEP', 'Pépéroni', 12.50, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('MAR', 'Margherita', 14.00, 'SANS_VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('REIN', 'La_Reine', 11.50, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('FRO', 'La_4_Fromage', 12.00, 'SANS_VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('CAN', 'La_Cannibale', 12.50, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('SAV', 'La_Savoyarde', 13.00, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('ORI', 'L''Orientale', 13.50, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			creationBase = conn.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES('IND', 'L''Indienne', 14.00, 'VIANDE')");
			creationBase.executeUpdate();
			creationBase.close();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public List<Pizza> findAllPizzas() {
		Connection pizzaConnection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		ResultSet resultats = null;
		List<Pizza> listePizza = new ArrayList<>();
		try{
			PreparedStatement findAll= pizzaConnection.prepareStatement("SELECT * FROM pizza");
			resultats = findAll.executeQuery();
			while(resultats.next()) {
				int id = resultats.getInt("ID");
				String code = resultats.getString("CODE_PIZZA");
				String nom = resultats.getString("NOM");
				double prix = resultats.getBigDecimal("PRIX").doubleValue();
				CategoriePizza categorie = CategoriePizza.valueOf(resultats.getString("CATEGORIE_PIZZA"));
				listePizza.add(new Pizza(id, code, nom, prix, categorie));
			}
			resultats.close();
			return listePizza;
			
		}

		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				resultats.close();
				pizzaConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Connection pizzaConnection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		try{
			PreparedStatement saveNew= pizzaConnection.prepareStatement("INSERT IGNORE INTO pizza(CODE_PIZZA, NOM, PRIX, CATEGORIE_PIZZA) VALUES(?,?,?,?) ");
			saveNew.setString(1, (pizza.getCode()));
			saveNew.setString(2, (pizza.getLibelle()));
			saveNew.setDouble(3, (pizza.getPrix()));
			saveNew.setString(4, (pizza.getCategorie().name()));
			saveNew.executeUpdate();
			pizzaConnection.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally{
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Connection pizzaConnection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		try{
			PreparedStatement update= pizzaConnection.prepareStatement("UPDATE pizza SET CODE_PIZZA = ?, NOM = ?, PRIX = ?, CATEGORIE_PIZZA = ? WHERE CODE_PIZZA = ?");
			update.setString(1, pizza.getCode());
			update.setString(2, pizza.getLibelle());
			update.setDouble(3, pizza.getPrix());
			update.setString(4, pizza.getCategorie().name());
			update.setString(5, codePizza);
			update.executeUpdate();
			pizzaConnection.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally{
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		Connection pizzaConnection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		try{
			PreparedStatement delete= pizzaConnection.prepareStatement("DELETE FROM pizza WHERE CODE_PIZZA = ?");
			delete.setString(1, codePizza);
			delete.executeUpdate();
			pizzaConnection.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		finally{
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		Connection pizzaConnection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("la connection n'est pas établie");
		}
		ResultSet resultat = null;
		try{
			PreparedStatement exists= pizzaConnection.prepareStatement("SELECT * FROM pizza WHERE CODE_PIZZA = ?");
			exists.setString(1, codePizza);
			resultat = exists.executeQuery();
			pizzaConnection.commit();
			if(resultat != null){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				resultat.close();
				pizzaConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
