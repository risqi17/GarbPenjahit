package com.risqi17.garbpenjahit.JSON;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.risqi17.garbpenjahit.R;

/**
 * Created by Risqi17 on 30/05/2017.
 */


public class CustomListPesanan extends ArrayAdapter<String> {
    private String[] ids;
    private String[] models;
    private String[] ukurans;
    private Activity context;

    public CustomListPesanan(Activity context, String[] ids, String[] models, String[] ukurans) {
        super(context, R.layout.item_list_pesanan, ids);
        this.context = context;
        this.ids = ids;
        this.models = models;
        this.ukurans = ukurans;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_list_pesanan, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewUkuran = (TextView) listViewItem.findViewById(R.id.textViewUkuran);

        textViewId.setText(ids[position]);
        textViewName.setText(models[position]);
        textViewUkuran.setText(ukurans[position]);

        return listViewItem;
    }
}

