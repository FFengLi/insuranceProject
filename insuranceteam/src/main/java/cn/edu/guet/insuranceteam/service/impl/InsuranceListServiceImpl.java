package cn.edu.guet.insuranceteam.service.impl;

import cn.edu.guet.insuranceteam.common.ResponseData;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import cn.edu.guet.insuranceteam.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    @Override
    public ResponseData deleteInsurance(InsuranceList insuranceList) {

        int result = insuranceListMapper.deleteById(insuranceList.getInsuranceId());
        if (result==1){
            return ResponseData.ok("删除成功！");
        }
        else return ResponseData.fail("删除失败");
    }

    @Override
    public ResponseData updateInsurance(InsuranceList insuranceList) {
        int result = insuranceListMapper.updateInsurance(insuranceList);
        if (result==1){
            return ResponseData.ok("修改成功！");
        } else
            return ResponseData.fail("修改失败！");
    }


}




