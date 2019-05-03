package com.example.demonewfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.demonewfragment.RestauranteFragment.OnListFragmentInteractionListener;
import com.example.demonewfragment.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestauranteRecyclerViewAdapter(List<Restaurante> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        // holder.textViewNombre.setText(mValues.get(position).getNombre());

        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDomicilio.setText(holder.mItem.getDomicilio());
        holder.ratingBarValoracion.setRating(holder.mItem.getValoracion());
        // usamos libreria picasso para cargar imagen
        Picasso.get()
                .load(holder.mItem.getUrlFoto())
                .into(holder.imageViewFoto);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final TextView textViewDomicilio;
        public final ImageView imageViewFoto;
        public final RatingBar ratingBarValoracion;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewDomicilio = view.findViewById(R.id.textViewDomicilio);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            imageViewFoto = view.findViewById(R.id.imageViewFoto);
            ratingBarValoracion = view.findViewById(R.id.ratingBarValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombre.getText() + "'";
        }
    }
}
