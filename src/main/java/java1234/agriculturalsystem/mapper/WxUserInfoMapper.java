package java1234.agriculturalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java1234.agriculturalsystem.entity.WxUserInfo;

/**
 * 微信用户Mapper接口

 */
public interface WxUserInfoMapper extends BaseMapper<WxUserInfo> {
    public WxUserInfo findByOpenId(String openId);
}
