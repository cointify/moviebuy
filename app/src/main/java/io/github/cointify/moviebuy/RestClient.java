package io.github.cointify.moviebuy;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class RestClient {

    private static ImdbApi api = null;

    public static ImdbApi getApi() {
        if(api == null) {
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(MovieBuyUtil.IMDB_BASE_URL).setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addQueryParam("api_key", MovieBuyUtil.API_KEY);
                }
            }).build();

            api = restAdapter.create(ImdbApi.class);
        }

        return api;
    }
}
