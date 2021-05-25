package model;

import java.util.ArrayList;

public class UserPantry {
	
	private ArrayList<String> ingredients=new ArrayList<String>(); 
	
	
	public UserPantry(){
		}

	public void addIngredient(String string) {
		ingredients.add(string);
	}

	public ArrayList<String> getIngredients() {
		// TODO Auto-generated method stub
		return ingredients;
	}
}
 