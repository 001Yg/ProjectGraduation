package java1234.agriculturalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java1234.agriculturalsystem.entity.ProductSwiperImage;
import java1234.agriculturalsystem.mapper.ProductSwiperImageMapper;
import java1234.agriculturalsystem.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**产品轮播图Service实现类*/
@Service("productSwiperImageService")
public class IProductSwiperImageServiceImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements IProductSwiperImageService {

    @Autowired
    private ProductSwiperImageMapper productSwiperImageMapper;
}
