package galyanae.monsterlunch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lia_2 on 13/09/2016.
 */
public class AdapterMonster extends BaseAdapter {
    ArrayList<Monster> monsters;
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    private Context context;

    TextView monsterName;
    TextView monsterStory;
    ImageView monsterImage;

    public AdapterMonster(Context context) {
        this.context = context;
        monsters = new ArrayList<>();

        monsters.add(new Monster(R.anim.steps, R.raw.luxorbackground,R.drawable.luxoreyesclose, R.raw.dontlikeit, R.raw.luxornom, "black", Food.FoodType.Luxury,
                R.drawable.luxorhappy,R.drawable.luxormounthclouse,
                R.drawable.luxorstand,R.drawable.luxoroneeyeclose, "Luxor",context.getString(R.string.LuxorStorie)));
        monsters.add(new Monster(R.anim.steps,R.raw.yoggybackground, R.drawable.yoggydead,R.raw.dontlikeit, R.raw.yoggynom, "black", Food.FoodType.Healthy,
                R.drawable.yoggyhappy,R.drawable.yoggymounthclose,
                R.drawable.yoggystand,R.drawable.yoggywinkle, "Yoggy", context.getString(R.string.YoggyStory)));
        monsters.add(new Monster(R.anim.steps, R.raw.sweetybackground, R.drawable.sweetydead, R.raw.dontlikeit, R.raw.sweetynom, "black", Food.FoodType.Sweet,
                R.drawable.sweetyhappy,R.drawable.sweetydead,
                R.drawable.sweetystand,R.drawable.sweetywinkles, "Sweety",context.getString(R.string.SweetyStorie)));
    }

    @Override
    public int getCount() {
        return monsters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(context,R.layout.adapter_monster_choise,null);
            monsterName = (TextView) linearLayout.findViewById(R.id.monsterName);
            monsterStory = (TextView) linearLayout.findViewById(R.id.monsterStory);
            monsterImage = (ImageView) linearLayout.findViewById(R.id.monsterImage);

        monsterImage.setBackgroundResource(monsters.get(position).getImageStand());
        monsterStory.setText(monsters.get(position).getStory());
        monsterName.setText(monsters.get(position).getName());

        return linearLayout;
    }


}
