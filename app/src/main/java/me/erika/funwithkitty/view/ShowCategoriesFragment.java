package me.erika.funwithkitty.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.erika.funwithkitty.R;
import me.erika.funwithkitty.model.CatCategoriesDO;
import me.erika.funwithkitty.network.TheCatAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowCategoriesFragment extends Fragment {

    ShowCategoriesAdapter mShowCategoriesAdapter;
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_show_categories,container,false);

        mRecyclerView = v.findViewById(R.id.recyclerView);


        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        //build service call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //API endpoint implementation
        TheCatAPI service = retrofit.create(TheCatAPI.class);

        final Call<List<CatCategoriesDO>> catCategories = service.catCategories();

        catCategories.enqueue(new Callback<List<CatCategoriesDO>>() {
            @Override
            public void onResponse(Call<List<CatCategoriesDO>> call, Response<List<CatCategoriesDO>> response) {
                Log.v("Erika - respone", response.body().toString());

               mShowCategoriesAdapter.showCategoriesAdapter(response.body());
               mShowCategoriesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<CatCategoriesDO>> call, Throwable t) {
                Log.e("Erika - respone", t.getMessage());
            }
        });

        mShowCategoriesAdapter = new ShowCategoriesAdapter();
        mRecyclerView.setAdapter(mShowCategoriesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

       return v;
    }

}
