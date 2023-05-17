package java1234.agriculturalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java1234.agriculturalsystem.entity.SmallType;

import java.util.List;
import java.util.Map;

/**商品小类mapper接口**/
public interface SmallTypeMapper extends BaseMapper<SmallType> {
    List<SmallType> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    SmallType findById(Integer id);
}
