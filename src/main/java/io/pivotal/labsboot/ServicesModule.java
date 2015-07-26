package io.pivotal.labsboot;

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
        return new ProductService();
    }
}