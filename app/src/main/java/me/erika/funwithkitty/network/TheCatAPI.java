package me.erika.funwithkitty.network;

//https://docs.thecatapi.com/api-reference/categories/categories-list

import java.util.List;

import me.erika.funwithkitty.model.CatCategoriesDO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TheCatAPI {

    //Define headers
    @Headers({
            "X-Api-Key: a41ea186-be5c-4cd1-8db5-a47f70fa4606"
    })

    //Define endpoint, call type, no parameters needed
    //Response type (a list of categories)
    @GET("/v1/categories")
    Call<List<CatCategoriesDO>> catCategories();
}
