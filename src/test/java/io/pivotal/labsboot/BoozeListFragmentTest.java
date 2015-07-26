package io.pivotal.labsboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.FragmentTestUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants=BuildConfig.class)
public class BoozeListFragmentTest {
    @Inject
    ProductService productService;

    @Before
    public void setup() {
        final TestAndroidBootApplication application = (TestAndroidBootApplication) RuntimeEnvironment.application;
        application.inject(this);
    }

    @Test
    public void createsFilledAdapter(){
        Booze talisker10 = new Booze("Talisker 10", 69.99f);
        List<Booze> boozes = new ArrayList<Booze>();
        boozes.add(talisker10);
        doReturn(boozes).when(productService).list();

        BoozeListFragment boozeListFragment = new BoozeListFragment();

        FragmentTestUtil.startVisibleFragment(boozeListFragment);

        assertThat(boozeListFragment.getListAdapter()).hasCount(1);
        assertEquals(boozeListFragment.getListAdapter().getItem(0), talisker10);
    }
}