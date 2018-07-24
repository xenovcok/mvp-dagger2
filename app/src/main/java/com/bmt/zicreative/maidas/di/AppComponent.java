package com.bmt.zicreative.maidas.di;

import android.app.Application;

import com.bmt.zicreative.maidas.PullmanApplication;
import com.bmt.zicreative.maidas.api.NetworkModule;
import com.bmt.zicreative.maidas.api.ServiceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ServiceModule.class,
        ActivityBuilder.class
})

public interface AppComponent {

    void inject(PullmanApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

}
