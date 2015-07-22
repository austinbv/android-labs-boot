package io.pivotal.labsboot;

import android.app.Fragment;
import android.app.FragmentManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants=BuildConfig.class)
public class BoozeActivityTest {
    @Test
    public void activityStartsTheFragment() {
        BoozeActivity boozeActivity = Robolectric.buildActivity(BoozeActivity.class).create().get();
        FragmentManager fragmentManager = boozeActivity.getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(android.R.id.content);

        assertThat(fragment, instanceOf(BoozeListFragment.class));

    }


}