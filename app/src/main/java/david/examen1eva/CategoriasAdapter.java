package david.examen1eva;

/**
 * Created by david.carabel on 20/12/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CategoriasAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> categorias;
    private LayoutInflater inflater;

    public CategoriasAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.categorias = categorias;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int position) {
        return categorias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.categorias_list_item, parent, false);

        return view;
    }
}