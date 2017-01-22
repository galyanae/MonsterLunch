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

        foods.add(new Food(100, "black", R.drawable.coctal, "coctail", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.car, "car", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.earing, "earring", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.crown, "crown", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.crown2, "crown2", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.dollar, "dollar", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.diamond, "diamond", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.crown3, "crown3", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.euro, "euro", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.hat, "hat", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.tuxedo, "tuxedo", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.money, "money", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.money2, "money2", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.ring, "ring", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.shoe, "shoe", 100, 0, Food.FoodType.Luxury));
        foods.add(new Food(100, "black", R.drawable.money3, "money3", 100, 0, Food.FoodType.Luxury));


        foods.add(new Food(100, "black", R.drawable.sportshoe, "sportshoe", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.yoga, "yoga", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.socer, "socer", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.banana, "banana", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.cherry, "cherry", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.pepper, "pepper", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.tomato, "tomato", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.tennis, "tennis", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.tennisball, "tennisball", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.carrot, "carrot", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.glove, "glove", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.bike, "bike", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.orange, "orange", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.roller, "roller", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.jym, "jym", 100, 0, Food.FoodType.Healthy));
        foods.add(new Food(100, "black", R.drawable.jym2, "jym2", 100, 0, Food.FoodType.Healthy));


        foods.add(new Food(100, "black", R.drawable.baby, "baby", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.teddybear, "teddybear", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cake, "cake", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cookie, "cookie", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cruasson, "cruassson", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.icecream, "icecream", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.icecream2, "icecream2", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.icecream3, "icecream3", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.icecream4, "icecream4", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cat, "cat", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.tart, "tart", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.unicorn, "unicorn", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cupcake, "cupcake", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.cupcake2, "cupcake2", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.lolipop, "lolipop", 100, 0, Food.FoodType.Sweet));
        foods.add(new Food(100, "black", R.drawable.doughnut, "doughnut", 100, 0, Food.FoodType.Sweet));


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