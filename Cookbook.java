/*
 Nathan Fontanilla 
 Cis 36B Final
 Williams
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Cookbook {
	Map<String, String[]> recipesToIngredients = new HashMap<String, String[]>();
	Map<String, HashSet<String>> ingredientsToRecipes = new HashMap<String, HashSet<String>>();
	Map<String, String[]> recipeToInstructions= new HashMap<String, String[]>(); 
	
	public Cookbook(){
		
	      try {
	          File inputFile = new File("input.txt");
	          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	          Document doc = dBuilder.parse(inputFile);
	          doc.getDocumentElement().normalize();
	          
	          System.out.print("Root element: ");
	          System.out.println(doc.getDocumentElement().getNodeName());
	          
	          NodeList nList = doc.getElementsByTagName("recipe");
	          System.out.println("----------------------------");
	          
	          
	          for (int idx1 = 0; idx1 < nList.getLength(); idx1++) {
	             Node nNode = nList.item(idx1);
	             System.out.println(nNode.getNodeName());
	             
	             List<String> ingredientList = new ArrayList<String>();
	             List<String> instructionList = new ArrayList<String>();
	             
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element eElement = (Element) nNode;
	                System.out.print("name : ");
	                System.out.println(eElement.getAttribute("name"));
	                
	                NodeList ingList = 
	                   eElement.getElementsByTagName("ingredient");
	                NodeList instList = 
	 	                   eElement.getElementsByTagName("instruction");
	                
	                System.out.println("ingredients");
	                for (int idx2 = 0; 
	                   idx2 < ingList.getLength(); idx2++) {	 
	                   Node node1 = ingList.item(idx2);
	                   if (node1.getNodeType() ==
	                      Node.ELEMENT_NODE) {
	                      Element ing = (Element) node1;
	                      System.out.print(idx2+1);
	                      System.out.print(": ");
	                      System.out.println(ing.getTextContent());
	                      ingredientList.add(ing.getTextContent());
	                   }
	                }
	                System.out.println("instructions");
	                for (int idx2 = 0; 
	 	                   idx2 < instList.getLength(); idx2++) {	 
	 	                   Node node1 = instList.item(idx2);
	 	                   if (node1.getNodeType() ==
	 	                      Node.ELEMENT_NODE) {
	 	                      Element ing = (Element) node1;
	 	                      System.out.print(idx2+1);
	 	                      System.out.print(": ");
	 	                      System.out.println(ing.getTextContent());
	 	                      instructionList.add(ing.getTextContent());
	 	                   }
	 	                }
	                
		             System.out.println();
		             
		             String[] ingredients = new String[ingredientList.size()];
		             ingredients = ingredientList.toArray(ingredients);
		             
		             String[] instructions = new String[instructionList.size()];
		             instructions = instructionList.toArray(instructions);
		
		             recipesToIngredients.put(eElement.getAttribute("name"), ingredients);
		             recipeToInstructions.put(eElement.getAttribute("name"), instructions);
	             }

	          }
	       } catch (Exception e) {
	          e.printStackTrace();
	       }
		

		for(String recipe:recipesToIngredients.keySet()){
			for(String ingredient:recipesToIngredients.get(recipe)){
				if(ingredientsToRecipes.containsKey(ingredient)){
					ingredientsToRecipes.get(ingredient).add(recipe);
				}
				else{
					HashSet<String> newSet=new HashSet<String>();
					newSet.add(recipe);
					ingredientsToRecipes.put(ingredient, newSet);
				}
			}
		}
		
		//and put them into the recipeToInstructions map right here:
		String[] wsInst={"chop veggies", "boil veggies"}; 
		String[] simpBfastInst={"crack eggs", "put in pan", "add bacon"};
		String[] allRecipes={"Wonton Soup","Simple Breakfast","Scrambled Eggs","Kebab"}; 
		
		recipeToInstructions.put(allRecipes[0],wsInst);
		recipeToInstructions.put(allRecipes[1], simpBfastInst);
		
	}

	public HashSet<String> getRecipsFromIng(String ingredient) {
		// TODO Auto-generated method stub
		if(ingredientsToRecipes.containsKey(ingredient)){
			return ingredientsToRecipes.get(ingredient);
		}else{
			return new HashSet<String>();
		}
		
		
	}	
	public String[] getIngsInRecipe(String recipe){
		return recipesToIngredients.get(recipe);
	}

	public String[] getInstr(String recipe) {
		// TODO Auto-generated method stub
		
		return recipeToInstructions.get(recipe);
		
	}
}
