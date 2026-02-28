package id.tunas.coffee.dto.api;

import java.util.List;

import id.tunas.coffee.dto.Product;

public class GetProductsResponse {
    private List<Product> data;
    private int recordsTotal;
    private int recordsFiltered;

    public GetProductsResponse(List<Product> data, int recordsTotal, int recordsFiltered) {
        this.data = data;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
