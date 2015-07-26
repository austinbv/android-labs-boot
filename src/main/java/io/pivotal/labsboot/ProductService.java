package io.pivotal.labsboot;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Booze> list() {
        ArrayList<Booze> boozes = new ArrayList<Booze>();
        boozes.add(new Booze("Talisker 18", 99.99f));
        return boozes;
    }
}
