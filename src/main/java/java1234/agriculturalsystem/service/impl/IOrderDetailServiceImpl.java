package java1234.agriculturalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java1234.agriculturalsystem.entity.OrderDetail;
import java1234.agriculturalsystem.mapper.OrderDetailMapper;
import java1234.agriculturalsystem.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单详情Service实现类
 */
@Service("orderDetailService")
public class IOrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper,OrderDetail> implements IOrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;
}
