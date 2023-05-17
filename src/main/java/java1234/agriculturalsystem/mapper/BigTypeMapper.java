package java1234.agriculturalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java1234.agriculturalsystem.entity.BigType;

/**商品大类mapper接口**/
public interface BigTypeMapper extends BaseMapper<BigType> {

    public BigType findById(Integer id);
}
