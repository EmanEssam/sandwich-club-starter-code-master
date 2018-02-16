package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static List<String> alsoKnownAs = new ArrayList<>();
    private static List<String> ingredients = new ArrayList<>();

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichObject = new JSONObject(json);
            JSONObject sandwichName = sandwichObject.getJSONObject("name");
            sandwich.setMainName(sandwichName.getString("mainName"));
            JSONArray alsoKnownArray = sandwichName.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownArray.length(); i++) {
                alsoKnownAs.add(alsoKnownArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setDescription(sandwichObject.getString("description"));
            sandwich.setImage(sandwichObject.getString("image"));
            sandwich.setPlaceOfOrigin(sandwichObject.getString("placeOfOrigin"));
            JSONArray ingredientsArray = sandwichObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }
            sandwich.setIngredients(ingredients);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return sandwich;
    }
}
