package io.pivotal.labsboot;

import java.util.List;

public class ProductsResponse {
    List<Booze> result;

    public List<Booze> getResult() {
        return result;
    }

    public void setResult(List<Booze> result) {
        this.result = result;
    }
}
