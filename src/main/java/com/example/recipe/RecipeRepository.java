package com.example.recipe;
import java.util.*;
import com.example.recipe.Recipe;
public interface RecipeRepository{
    public ArrayList<Recipe> getRecipes();
    public Recipe getRecipeById(int recipeId);

    public Recipe addrecipe(Recipe recipeadd);
    public Recipe updateRecipe(int recipeId , Recipe recipeupdate);
    public void deleteRecipe(int recipeId);
}