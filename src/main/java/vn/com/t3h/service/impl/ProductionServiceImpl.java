package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.model.response.PageResponse;
import vn.com.t3h.service.ProductionService;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    @Qualifier("productionHibernateDaoImpl")
    private ProductionDao productionDao;

    @Override
    public PageResponse<List<ProductionEntity>> getProductionPaging(Long pageIndex, Long pageSize, String title, String author, Integer publicYear, String categoryName) {
        return null;
    }

    @Override
    public List<ProductionEntity> getProductions() {
        return productionDao.getProduction();
    }

    @Override
    public ProductionEntity findById(Integer id) {
        return productionDao.findById(id);
    }

    public static void main(String[] args) {

        List<ProductionModel> models = new ArrayList<ProductionModel>();
        for (ProductionModel product: models) {
            System.out.printf(product.getTitle());
            System.out.println(product.getPrice());
            System.out.println(product.getId());
        }

    }

    public List<ProductionEntity> getProduction() {
        return getProductions();
    }
}