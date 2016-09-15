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
        foods.add(new Food(200, "black",R.drawable.food,"chickenLeg",200,0, Food.FoodType.Healthy));
        foods.add(new Food(300, "black",R.drawable.cactus,"cactus",300,0, Food.FoodType.Healthy));
        foods.add(new Food(500, "black",R.drawable.diamound,"diamond",500,0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black",R.drawable.doughnut,"doughnut",200,0, Food.FoodType.Sweet));
        foods.add(new Food(400, "black",R.drawable.cupcake,"cupcake",200,0, Food.FoodType.Sweet));
        foods.add(new Food(300, "black",R.drawable.chocolate,"chocolate",200,0, Food.FoodType.Sweet));
        foods.add(new Food(500, "black",R.drawable.cake,"cake",500,0, Food.FoodType.Sweet));}


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