package cn.edu.guet.insuranceteam.service.impl;

import cn.edu.guet.insuranceteam.bean.InsuranceSummaryModel;
import cn.edu.guet.insuranceteam.common.ResponseData;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import cn.edu.guet.insuranceteam.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
* @author 罗云之
* @description 针对表【t_insurance_list】的数据库操作Service实现
* @createDate 2023-07-23 01:47:57
*/
@Service
public class InsuranceListServiceImpl extends ServiceImpl<InsuranceListMapper, InsuranceList>
    implements InsuranceListService{


    @Autowired
    private InsuranceListMapper insuranceListMapper;

    @Override
    public ResponseData insuranceSummary() {
        List<InsuranceList> insuranceListList = insuranceListMapper.selectList(null);

        return ResponseData.ok(insuranceListList);
    }

    @Override
    public ResponseData summaryExportExcel(List<InsuranceSummaryModel> summaryModelList) {
        //获取当前项目目录地址
        String projectDir = System.getProperty("user.dir");
        System.out.println(projectDir);
        String fileName = projectDir+"\\保险汇总.xlsx";
        //String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        //导出excel表格
        EasyExcel.write(fileName, InsuranceSummaryModel.class).sheet().doWrite(summaryModelList);
        return ResponseData.ok("导出成功！");
    }


}




