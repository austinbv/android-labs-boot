package io.pivotal.labsboot;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class BoozeListFragment extends ListFragment {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<Booze> boozeArrayAdapter = new ArrayAdapter<Booze>(getActivity(), android.R.layout.simple_list_item_1,
                Arrays.asList(new Booze("BOOOOOZE", 5.50f)));
        setListAdapter(boozeArrayAdapter);
    }
}
