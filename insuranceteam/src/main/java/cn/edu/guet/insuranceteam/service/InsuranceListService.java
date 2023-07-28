package cn.edu.guet.insuranceteam.service;

import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.common.ResponseData;
import com.baomidou.mybatisplus.extension.service.IService;
import sun.security.x509.RDN;

/**
* @author 罗云之
* @description 针对表【t_insurance_list】的数据库操作Service
* @createDate 2023-07-23 01:47:57
*/
public interface InsuranceListService extends IService<InsuranceList> {
    ResponseData insuranceSummary();
}
