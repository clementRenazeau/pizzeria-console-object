package fr.pizzeria.exception;

public class FindPizzaByCodeException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FindPizzaByCodeException() {
		
	}

	public FindPizzaByCodeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}
