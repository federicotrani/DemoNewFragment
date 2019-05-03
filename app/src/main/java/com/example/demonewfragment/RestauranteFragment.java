package com.example.demonewfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurante;
    List<Restaurante> restauranteList;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // lista de elementos (restaurante)
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Restaurant San Carlos","http://lorempixel.com/output/food-q-c-400-200-1.jpg",4.0f,"Las Heras 335, Santa Rosa"));
            restauranteList.add(new Restaurante("Restaurant Los Caldenes","http://lorempixel.com/output/food-q-c-400-200-2.jpg",4.2f,"Belgrano 851, Toay"));
            restauranteList.add(new Restaurante("Cantina Los Hermanos","http://lorempixel.com/output/food-q-c-400-200-3.jpg",3.6f,"Bartolome Mitre 177, Santa Rosa"));
            restauranteList.add(new Restaurante("Fonda La Cumparsita","http://lorempixel.com/output/food-q-c-400-200-4.jpg",2.2f,"Honduras 543, Anguil"));
            restauranteList.add(new Restaurante("Restaurant Hunderwolff","http://lorempixel.com/output/food-q-c-400-200-5.jpg",4.7f,"Avenida Lavalle 932, Santa Rosa"));

            // asociamos adaptador al restaurante
            adapterRestaurante = new MyRestauranteRecyclerViewAdapter(restauranteList, mListener);
            recyclerView.setAdapter(adapterRestaurante);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurante item);
    }
}
