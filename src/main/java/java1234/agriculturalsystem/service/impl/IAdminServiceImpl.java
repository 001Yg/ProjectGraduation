package java1234.agriculturalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java1234.agriculturalsystem.entity.Admin;
import java1234.agriculturalsystem.mapper.AdminMapper;
import java1234.agriculturalsystem.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员Service实现类
 */
@Service("adminService")
public class IAdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
}
