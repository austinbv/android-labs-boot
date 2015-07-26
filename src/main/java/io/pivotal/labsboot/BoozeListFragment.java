package io.pivotal.labsboot;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import javax.inject.Inject;


public class BoozeListFragment extends ListFragment {
    @Inject
    ProductService productService;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AndroidBootApplication) getActivity().getApplication()).inject(this);
        ArrayAdapter<Booze> boozeArrayAdapter = new ArrayAdapter<Booze>(getActivity(), android.R.layout.simple_list_item_1,
                productService.list()
        );

        setListAdapter(boozeArrayAdapter);
    }


}
