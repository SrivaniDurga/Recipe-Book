package com.example.recipe;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.recipe.Recipe;
import com.example.recipe.RecipeService;

@RestController
public class RecipeController{
    RecipeService RS = new RecipeService();
    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipes(){
        return RS.getRecipes();
    }
    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable ("recipeId") int recipeId){
        return RS.getRecipeById(recipeId);
    }
    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipeadd){
        return RS.addrecipe(recipeadd);
    }
    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable ("recipeId") int recipeId , @RequestBody Recipe recipeupdate){
        return RS.updateRecipe(recipeId , recipeupdate);
    }
    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable ("recipeId") int recipeId){
        RS.deleteRecipe(recipeId);
    }
}