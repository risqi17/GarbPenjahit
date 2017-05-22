package com.risqi17.garbpenjahit.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.risqi17.garbpenjahit.R;

/**
 * Created by Risqi17 on 19/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    // ViewHolder akan mendeskripisikan item view yang ditempatkan di dalam RecyclerView.
    TextView tv1,tv2; //deklarasi textview
    ImageView imageView;  //deklarasi imageview

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.daftar_judul);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv2= (TextView) itemView.findViewById(R.id.daftar_deskripsi);
        //menampilkan text deskripsi dari widget CardView pada id daftar_deskripsi
        imageView= (ImageView) itemView.findViewById(R.id.daftar_icon);
        //menampilkan gambar atau icon pada widget Cardview pada id daftar_icon
    }
}