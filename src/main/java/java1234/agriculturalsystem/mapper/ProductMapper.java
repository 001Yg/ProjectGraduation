package java1234.agriculturalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java1234.agriculturalsystem.entity.Product;

import java.util.List;
import java.util.Map;

/**商品mapper接口**/
public interface ProductMapper extends BaseMapper<Product> {
    List<Product> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);


    void add(Product product);

    void update(Product product);

    Product findById(Integer id);
}
