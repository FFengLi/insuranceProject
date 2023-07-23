package cn.edu.guet.insuranceteam.service.impl;

import cn.edu.guet.insuranceteam.common.ResponseData;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import cn.edu.guet.insuranceteam.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 罗云之
 * @description 针对表【t_insurance_list】的数据库操作Service实现
 * @createDate 2023-07-23 01:47:57
 */
@Service
public class InsuranceListServiceImpl extends ServiceImpl<InsuranceListMapper, InsuranceList>
        implements InsuranceListService {
    @Autowired
    private InsuranceListMapper insuranceListMapper;

    @Override
    public ResponseData createInsurance(InsuranceList insuranceList) {
        int result = insuranceListMapper.insert(insuranceList);
        if (result == 1) {
            return ResponseData.ok("新增保险清单成功！");
        } else
            return ResponseData.fail("创建失败！");
    }
}




