package io.pivotal.labsboot;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                BoozeListFragment.class
        },
        library = true,
        complete = false
)
public class ServicesModule {
    @Provides
    BoozeListFragment providesBoozeListFragment() {
        return new BoozeListFragment();
    }

    @Provides
    ProductService providesProductService() {
        try {
            return new ProductService(new URL("http://lcboapi.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}