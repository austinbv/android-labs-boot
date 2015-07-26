package io.pivotal.labsboot;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module(
        injects = {
                BoozeListFragment.class,
                BoozeListFragmentTest.class
        },
        library = true,
        complete = false,
        overrides = true
)
public class TestServicesModule {
    @Provides
    @Singleton
    ProductService providesProductService() {
        return mock(ProductService.class);
    }
}
