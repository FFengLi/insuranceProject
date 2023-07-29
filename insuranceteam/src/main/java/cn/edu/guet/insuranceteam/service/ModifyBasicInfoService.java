package cn.edu.guet.insuranceteam.service;

import cn.edu.guet.insuranceteam.bean.ModifyBasicInfo;
import cn.edu.guet.insuranceteam.common.ResponseData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 罗云之
* @description 针对表【modify_basic_info】的数据库操作Service
* @createDate 2023-07-23 01:46:11
*/
public interface ModifyBasicInfoService extends IService<ModifyBasicInfo> {

    ResponseData getModifyListSummary(String year,String timeType);
}
