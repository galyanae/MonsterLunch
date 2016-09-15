package galyanae.monsterlunch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Lia_2 on 13/09/2016.
 */
public class AdapterMonster extends BaseAdapter {
    ArrayList<Monster> monsters;
    private Context context;

    public AdapterMonster(Context context) {
        this.context = context;
        monsters = new ArrayList<>();

        monsters.add(new Monster(R.anim.steps, R.drawable.luxoreyesclose, "black", Food.FoodType.Luxury,
                R.drawable.luxorhappy,R.drawable.luxormounthclouse,
                R.drawable.luxorstand,R.drawable.luxoroneeyeclose, "Luxor", 0));
        monsters.add(new Monster(R.anim.steps, R.drawable.yoggydead, "black", Food.FoodType.Healthy,
                R.drawable.yoggyhappy,R.drawable.yoggymounthclose,
                R.drawable.yoggystand,R.drawable.yoggywinkle, "Yoggy",0));
        monsters.add(new Monster(R.anim.steps, R.drawable.sweetydead, "black", Food.FoodType.Sweet,
                R.drawable.sweetyhappy,R.drawable.sweetydead,
                R.drawable.sweetystand,R.drawable.sweetywinkles, "Sweety", 0));
    }

    @Override
    public int getCount() {
        return monsters.size();
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
