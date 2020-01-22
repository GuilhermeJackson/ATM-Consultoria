package com.example.RecycleViewAndJsonParsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atmempresadeconsultoria.R;

import java.util.ArrayList;

public class FavoritosAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private ArrayList<FavoritosItem> listaFavoritos;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListiner(OnItemClickListener listener) {
        mListener = listener;
    }

    public FavoritosAdapter(Context context, ArrayList<FavoritosItem> listaFavoritos){
        context = context;
        listaFavoritos = listaFavoritos;
    }

    @NonNull
    @Override
    public FavoritosAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.favoritos_card_view, parent, false);
        return new FavoritosAdapter.FavoritosAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FavoritosItem favoritosItem = listaFavoritos.get(position);
    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public class FavoritosAdapterViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private ImageView mImageDelete;
        private TextView mTxtNomeFavorito;
            public FavoritosAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.mImgFavorito);
            mImageDelete = itemView.findViewById(R.id.imgDelete);
            mTxtNomeFavorito = itemView.findViewById(R.id.mTxtNomeFavorito);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
