package model;

//import java.util.ArrayList;

public class Ingredient {
	String name;
	String[] containingRecipes;
	//ArrayList<Recipe> recipes=new ArrayList<Recipe>(); 
	
	public Ingredient(String name, String[] recipes){
		//name=name;
		containingRecipes=recipes;
	}
}
 