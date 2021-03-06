package ru.univeralex.web.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.univeralex.web.dao.ProductDao;
import ru.univeralex.web.models.Product;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public class ProductDaoJdbcTemplateImpl implements ProductDao {
    private JdbcTemplate template;

    private Map<Integer, Product> productsMap = new HashMap<>();

    private RowMapper<Product> productRowMapper
            = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("product_id");

        if (!productsMap.containsKey(id)) {
            String name = resultSet.getString("name");
            Double cost = resultSet.getDouble("cost");
            Product product = new Product(id, name, cost);
            productsMap.put(id, product);
        }

        return productsMap.get(id);
    };

    public ProductDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Product> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Product model) {
        template.update("INSERT INTO product(name, cost) VALUES(?, ?)", model.getName(), model.getCost());
    }

    @Override
    public void update(Product model) {
        String sql = "UPDATE product SET name = ?, cost = ? WHERE product_id = ?";
        template.update(sql, model.getName(), model.getCost(), model.getId());
    }

    @Override
    public void delete(Integer id) {
        template.update("DELETE FROM product WHERE product_id = ?", id);
    }

    @Override
    public List<Product> findAll() {
        return template.query("SELECT * FROM product", productRowMapper);
    }
}
