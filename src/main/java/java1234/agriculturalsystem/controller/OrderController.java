package java1234.agriculturalsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java1234.agriculturalsystem.constant.SystemConstant;
import java1234.agriculturalsystem.entity.Order;
import java1234.agriculturalsystem.entity.OrderDetail;
import java1234.agriculturalsystem.entity.R;
import java1234.agriculturalsystem.service.IOrderDetailService;
import java1234.agriculturalsystem.service.IOrderService;
import java1234.agriculturalsystem.util.DateUtil;
import java1234.agriculturalsystem.util.JwtUtils;
import io.jsonwebtoken.Claims;
import javafx.scene.input.TouchEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 订单Controller控制器
 * */
@RestController
@RequestMapping("/my/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 创建订单，返回订单号
     * @param token
     * @return
     */
    @RequestMapping("/create")
    @Transactional
    public R create(@RequestBody Order order, @RequestHeader(value = "token")String token){
        // 通过token获取openid
        System.out.println("token="+token);
        System.out.println("order="+order);
        // 添加订单到数据库
        Claims claims = JwtUtils.validateJWT(token).getClaims();
        if(claims!=null){
            System.out.println("openid="+claims.getId());
            order.setUserId(claims.getId());
        }
        order.setOrderNo("JAVA"+DateUtil.getCurrentDateStr());  //订单号
        order.setCreateDate(new Date());

        OrderDetail[] goods = order.getGoods();
        orderService.save(order);
        // 添加订单详情到数据库
        for(int i=0;i<goods.length;i++){
            OrderDetail orderDetail=goods[i];
            orderDetail.setMId(order.getId());
            orderDetailService.save(orderDetail);
        }
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("orderNo",order.getOrderNo());
        return R.ok(resultMap);
        //return R.ok();
    }

    /**
     * 订单查询 type值 0 全部订单  1 待付款  2 待收货 3 退款/退货
     * @param type
     * @return
     */
    @RequestMapping("/list")
    public R list(Integer type,Integer page,Integer pageSize){
        System.out.println("type="+type);

        List<Order> orderList=null;
        Map<String,Object> resultMap=new HashMap<>();

        Page<Order> pageOrder=new Page<>(page,pageSize);

        if(type==0){ // 全部订单查询
            // orderList=orderService.list(new QueryWrapper<Order>().orderByDesc("id"));
            Page<Order> orderResult = orderService.page(pageOrder, new QueryWrapper<Order>().orderByDesc("id"));
            System.out.println("总记录数"+orderResult.getTotal());
            System.out.println("总页数"+orderResult.getPages());
            System.out.println("当前页数据"+orderResult.getRecords());
            orderList=orderResult.getRecords();
            resultMap.put("total",orderResult.getTotal());
            resultMap.put("totalPage",orderResult.getPages());

        }else{
            // orderList=orderService.list(new QueryWrapper<Order>().eq("status",type).orderByDesc("id"));
            Page<Order> orderResult = orderService.page(pageOrder, new QueryWrapper<Order>().eq("status",type).orderByDesc("id"));
            System.out.println("总记录数"+orderResult.getTotal());
            System.out.println("总页数"+orderResult.getPages());
            System.out.println("当前页数据"+orderResult.getRecords());
            orderList=orderResult.getRecords();
            resultMap.put("total",orderResult.getTotal());
            resultMap.put("totalPage",orderResult.getPages());
        }

        resultMap.put("orderList",orderList);
        return R.ok(resultMap);
    }

}
