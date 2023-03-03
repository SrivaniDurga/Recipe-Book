package com.example.recipe;

import com.example.recipe.RecipeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.recipe.Recipe;

import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
        int uniqueId = 6;
        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        @Override
        public ArrayList<Recipe> getRecipes(){
                Collection<Recipe> allRecipes = recipeBook.values();
                ArrayList<Recipe> RecipesAll = new ArrayList<>(allRecipes);
                return RecipesAll;
        }
        @Override
        public Recipe getRecipeById(int recipeId){
                Recipe recipebyId = recipeBook.get(recipeId);
                if(recipebyId == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return recipebyId;
        }
        @Override
        public Recipe addrecipe(Recipe recipeadd){
                recipeadd.setRecipeId(uniqueId);
                recipeBook.put(uniqueId, recipeadd);
                uniqueId += 1;
                return recipeadd;
        }
        @Override
        public Recipe updateRecipe(int recipeId , Recipe recipeupdate){
                Recipe existingRecipe = recipeBook.get(recipeId);
                if(existingRecipe == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                if(recipeupdate.getRecipeName() != null){
                        existingRecipe.setRecipeName(recipeupdate.getRecipeName());
                }
                if(recipeupdate.getRecipeType() != null){
                        existingRecipe.setRecipeTyep(recipeupdate.getRecipeType());
                }
                if(recipeupdate.getIngredients() != null){
                        existingRecipe.setIngredients(recipeupdate.getIngredients());
                }
                return existingRecipe;
        }
        @Override
        public void deleteRecipe(int recipeId){
                Recipe recipedelete = recipeBook.get(recipeId);
                if(recipedelete == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }else{
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        }
}