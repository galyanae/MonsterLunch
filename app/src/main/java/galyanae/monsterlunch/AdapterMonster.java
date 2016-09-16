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

        monsters.add(new Monster(R.anim.steps, R.drawable.luxoreyesclose, R.raw.dontlikeit, R.raw.luxornom, "black", Food.FoodType.Luxury,
                R.drawable.luxorhappy,R.drawable.luxormounthclouse,
                R.drawable.luxorstand,R.drawable.luxoroneeyeclose, "Luxor",context.getString(R.string.LuxorStorie)));
        monsters.add(new Monster(R.anim.steps, R.drawable.yoggydead,R.raw.dontlikeit, R.raw.yoggynom, "black", Food.FoodType.Healthy,
                R.drawable.yoggyhappy,R.drawable.yoggymounthclose,
                R.drawable.yoggystand,R.drawable.yoggywinkle, "Yoggy", context.getString(R.string.YoggyStory)));
        monsters.add(new Monster(R.anim.steps, R.drawable.sweetydead, R.raw.dontlikeit, R.raw.sweetynom, "black", Food.FoodType.Sweet,
                R.drawable.sweetyhappy,R.drawable.sweetydead,
                R.drawable.sweetystand,R.drawable.sweetywinkles, "Sweety",context.getString(R.string.SweetyStorie)));
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
