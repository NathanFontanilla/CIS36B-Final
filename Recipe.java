package model;

import java.util.ArrayList;

public class Recipe {
	String name;
	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	String instructions[]; 
	public Recipe(String name, ArrayList<Ingredient> list, String instructs[]){
		//name=name;
		ingredients=list;
		instructions=instructs;
	}
}
 