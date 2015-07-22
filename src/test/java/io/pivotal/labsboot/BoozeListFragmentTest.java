package io.pivotal.labsboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.FragmentTestUtil;

import static org.fest.assertions.api.ANDROID.assertThat;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants=BuildConfig.class)
public class BoozeListFragmentTest {

    @Test
    public void createsFilledAdapter(){
        BoozeListFragment boozeListFragment = new BoozeListFragment();
        FragmentTestUtil.startVisibleFragment(boozeListFragment);

        assertThat(boozeListFragment.getListAdapter()).hasCount(1);
    }

}