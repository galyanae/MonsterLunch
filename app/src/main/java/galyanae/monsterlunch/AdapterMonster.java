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
    ArrayList<Monster> monster;
    private Context context;

    public AdapterMonster(ArrayList<Monster> monster, Context context) {
        this.monster = monster;
        this.context = context;
    }

    public AdapterMonster(ArrayList<Monster> monster){

    }
    @Override
    public int getCount() {
        return 0;
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
