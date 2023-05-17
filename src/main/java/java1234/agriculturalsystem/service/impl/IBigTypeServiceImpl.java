package java1234.agriculturalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java1234.agriculturalsystem.entity.BigType;
import java1234.agriculturalsystem.mapper.BigTypeMapper;
import java1234.agriculturalsystem.service.IBigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**商品大类Service实现类*/
@Service("BigTypeService")
public class IBigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType> implements IBigTypeService {

    @Autowired
    private BigTypeMapper BigTypeMapper;
}
