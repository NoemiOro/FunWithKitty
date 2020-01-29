package me.erika.funwithkitty.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.erika.funwithkitty.R;
import me.erika.funwithkitty.model.CatCategoriesDO;

public class ShowCategoriesAdapter extends RecyclerView.Adapter<ShowCategoriesAdapter.ItemViewHolder> {

    private List<CatCategoriesDO> mCategoriesDOS = new ArrayList<>();


    public ShowCategoriesAdapter showCategoriesAdapter(List<CatCategoriesDO> mCategoriesDOS){
        this.mCategoriesDOS = mCategoriesDOS;
        return null;
    }



    //Called when the Recycler needs a new ViewHolder to represent data of a given type
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_category_view,parent,false));
    }

    //To display data in certain position, updates the content of the view
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CatCategoriesDO term = mCategoriesDOS.get(position);
        holder.name.setText(term.getName());
        holder.id.setText(String.valueOf(term.getId()));
    }

    //Number of items that recycler is displaying
    @Override
    public int getItemCount() {
        return mCategoriesDOS.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView id;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            id = itemView.findViewById(R.id.idTextView);
        }
    }
}
