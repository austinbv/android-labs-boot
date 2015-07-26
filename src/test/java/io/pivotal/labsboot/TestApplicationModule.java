package io.pivotal.labsboot;

import android.content.Context;

import org.robolectric.RuntimeEnvironment;

import dagger.Module;
import dagger.Provides;
import io.pivotal.labsboot.example.TestAndroidBootModule;

@Module(
        includes = {
                TestAndroidBootModule.class,
                TestServicesModule.class
        },
        library = true,
        complete = false
)
public class TestApplicationModule {
    @Provides
    Context providesApplicationContext() {
        return RuntimeEnvironment.application;
    }
}
