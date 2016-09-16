package galyanae.monsterlunch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Owner on 13/09/2016.
 */
public class AdapterFood extends BaseAdapter {

    ArrayList<Food> foods;

    private Context context;

    public AdapterFood (Context context) {
        this.context = context;
        foods = new ArrayList<>();
        foods.add(new Food(60, "black", R.drawable.braslet, "braslet", 40, 0, Food.FoodType.Luxury));
        foods.add(new Food(80, "black", R.drawable.car, "car", 70, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.champagne, "champagne", 80, 0, Food.FoodType.Luxury));
        foods.add(new Food(120, "black", R.drawable.crawn, "crawn", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(90, "black", R.drawable.crawn2, "crawn2", 70, 0, Food.FoodType.Luxury));
        foods.add(new Food(190, "black", R.drawable.dollar, "dollar", 130, 0, Food.FoodType.Luxury));
        foods.add(new Food(80, "black", R.drawable.diamound, "diamound", 60, 0, Food.FoodType.Luxury));
        foods.add(new Food(99, "black", R.drawable.dress, "dress", 90, 0, Food.FoodType.Luxury));
        foods.add(new Food(70, "black", R.drawable.earrings, "earrings", 50, 0, Food.FoodType.Luxury));
        foods.add(new Food(110, "black", R.drawable.euro, "euro", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(200, "black", R.drawable.gold, "gold", 160, 0, Food.FoodType.Luxury));
        foods.add(new Food(130, "black", R.drawable.hat, "hat", 80, 0, Food.FoodType.Luxury));
        foods.add(new Food(80, "black", R.drawable.jacket, "jacket", 40, 0, Food.FoodType.Luxury));
        foods.add(new Food(120, "black", R.drawable.limo, "limo", 90, 0, Food.FoodType.Luxury));
        foods.add(new Food(80, "black", R.drawable.martini, "martini", 60, 0, Food.FoodType.Luxury));
        foods.add(new Food(160, "black", R.drawable.monalisa, "monalisa", 120, 0, Food.FoodType.Luxury));
        foods.add(new Food(180, "black", R.drawable.moneybag, "moneybag", 120, 0, Food.FoodType.Luxury));
        foods.add(new Food(60, "black", R.drawable.neck, "neck", 30, 0, Food.FoodType.Luxury));
        foods.add(new Food(80, "black", R.drawable.ring, "ring", 60, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.shoe, "shoe", 80, 0, Food.FoodType.Luxury));
        foods.add(new Food(130, "black", R.drawable.watches, "watches", 50, 0, Food.FoodType.Luxury));
        foods.add(new Food(130, "black", R.drawable.yahct, "yahct", 80, 0, Food.FoodType.Luxury));




        foods.add(new Food(60, "black", R.drawable.sportshoe, "braslet", 40, 0, Food.FoodType.Healthy));
        foods.add(new Food(80, "black", R.drawable.yoga, "car", 70, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.yogamat, "champagne", 80, 0, Food.FoodType.Healthy));
        foods.add(new Food(120, "black", R.drawable.banana, "crawn", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(90, "black", R.drawable.berry, "crawn2", 70, 0, Food.FoodType.Healthy));
        foods.add(new Food(190, "black", R.drawable.strewberry1, "dollar", 130, 0, Food.FoodType.Healthy));
        foods.add(new Food(80, "black", R.drawable.cactus3, "diamound", 60, 0, Food.FoodType.Healthy));
        foods.add(new Food(99, "black", R.drawable.cherry, "dress", 90, 0, Food.FoodType.Healthy));
        foods.add(new Food(70, "black", R.drawable.grapefruit, "earrings", 50, 0, Food.FoodType.Healthy));
        foods.add(new Food(110, "black", R.drawable.ananas, "euro", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(200, "black", R.drawable.avocado, "gold", 160, 0, Food.FoodType.Healthy));
        foods.add(new Food(130, "black", R.drawable.bice, "hat", 80, 0, Food.FoodType.Healthy));
        foods.add(new Food(80, "black", R.drawable.cacyus, "jacket", 40, 0, Food.FoodType.Healthy));
        foods.add(new Food(120, "black", R.drawable.hita, "limo", 90, 0, Food.FoodType.Healthy));
        foods.add(new Food(80, "black", R.drawable.lemon, "martini", 60, 0, Food.FoodType.Healthy));
        foods.add(new Food(160, "black", R.drawable.mishkolet, "monalisa", 120, 0, Food.FoodType.Healthy));
        foods.add(new Food(180, "black", R.drawable.onion, "moneybag", 120, 0, Food.FoodType.Healthy));
        foods.add(new Food(60, "black", R.drawable.roller, "neck", 30, 0, Food.FoodType.Healthy));
        foods.add(new Food(80, "black", R.drawable.shapebice, "ring", 60, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.sportshoe, "shoe", 80, 0, Food.FoodType.Healthy));
        foods.add(new Food(130, "black", R.drawable.stretch, "watches", 50, 0, Food.FoodType.Healthy));
        foods.add(new Food(130, "black", R.drawable.tomato, "yahct", 80, 0, Food.FoodType.Healthy));

    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}