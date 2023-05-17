package java1234.agriculturalsystem.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java1234.agriculturalsystem.entity.PageBean;
import java1234.agriculturalsystem.entity.R;
import java1234.agriculturalsystem.entity.WxUserInfo;
import java1234.agriculturalsystem.service.IWxUserInfoService;
import java1234.agriculturalsystem.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台管理-用户Controller控制器
 * */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private IWxUserInfoService wxUserInfoService;

    /**
     * 根据条件分页查询用户信息
     * @param pageBean
     * @return
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        String query=pageBean.getQuery().trim();
        Page<WxUserInfo> page=new Page<>(pageBean.getPageNum(),pageBean.getPageSize());
        Page<WxUserInfo> pageResult = wxUserInfoService.page(page, new QueryWrapper<WxUserInfo>().like(StringUtil.isNotEmpty(query), "nickName", query));
        Map<String,Object> map=new HashMap<>();
        map.put("userList",pageResult.getRecords());
        map.put("total",pageResult.getTotal());
        return R.ok(map);
    }

}