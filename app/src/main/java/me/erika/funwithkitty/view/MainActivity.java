package me.erika.funwithkitty.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import me.erika.funwithkitty.R;
import me.erika.funwithkitty.model.CatCategoriesDO;
import me.erika.funwithkitty.network.TheCatAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            ShowCategoriesFragment firstFragment = new ShowCategoriesFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }



    }
}
