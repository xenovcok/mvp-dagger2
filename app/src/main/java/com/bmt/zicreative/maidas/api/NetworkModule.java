package com.bmt.zicreative.maidas.api;

import android.content.Context;

import com.bmt.zicreative.maidas.Utils.AuthenticationUtil;
import com.bmt.zicreative.maidas.Utils.Constant;
import com.bmt.zicreative.maidas.api.config.ApiConfig;
import com.bmt.zicreative.maidas.login.AuthInteceptor;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Set<Interceptor> interceptors) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        for (Interceptor interceptor: interceptors) {
            httpClient.addInterceptor(interceptor);
        }

        return httpClient.build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(ApiConfig.GSON);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    Set<Interceptor> providesRetrofitInterceptors(Context context, AuthInteceptor authInterceptor) {
        Set<Interceptor> interceptors = new LinkedHashSet<>();
        interceptors.add(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY));
        interceptors.add(authInterceptor);
        return interceptors;
    }

    @Provides
    @Singleton
    AuthInteceptor provideAuthInterceptor(AuthenticationUtil authenticationUtils) {
        return new AuthInteceptor(authenticationUtils);
    }

    @Provides
    @Singleton
    AuthenticationUtil provideAuthenticationUtils() {
        return new AuthenticationUtil();
    }

}
