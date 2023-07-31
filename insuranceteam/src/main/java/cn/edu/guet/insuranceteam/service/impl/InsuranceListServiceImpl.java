package cn.edu.guet.insuranceteam.service.impl;

import cn.edu.guet.insuranceteam.bean.InsuranceDTO;
import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.bean.InsuranceSummaryModel;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.mapper.InsuranceListMapper;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        } else {
            return ResponseData.fail("创建失败！");
        }
    }

    @Override
    public ResponseData deleteInsurance(InsuranceList insuranceList) {

        int result = insuranceListMapper.deleteById(insuranceList.getInsuranceId());
        if (result==1){
            return ResponseData.ok("删除成功！");
        }
        else {
            return ResponseData.fail("删除失败");
        }
    }

    @Override
    public ResponseData insuranceSummary() {
        List<InsuranceList> insuranceListList = insuranceListMapper.selectList(null);

        return ResponseData.ok(insuranceListList);
    }

    @Override
    public ResponseData summaryExportExcel(List<InsuranceSummaryModel> summaryModelList) {
        //获取当前项目目录地址
//        String projectDir = System.getProperty("user.dir");
//        System.out.println(projectDir);
        String fileName = "F:\\desktop\\保险汇总.xlsx";
        summaryModelList.forEach(summaryModel -> {
            System.out.println(summaryModel.getTotalAmount());
            System.out.println(summaryModel.getJanuary());
            System.out.println(summaryModel.getTotal());
        });
        //String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        //导出excel表格
            EasyExcel.write(fileName, InsuranceSummaryModel.class).sheet().doWrite(summaryModelList);
            return ResponseData.ok("导出成功！");
    }

    @Override
    public ResponseData viewInsurance(InsuranceDTO insuranceDTO) {
        LambdaQueryWrapper<InsuranceList> queryWrapper = new LambdaQueryWrapper<>();
        //地州
        System.out.println("地州："+insuranceDTO.getPrefecture());
        if (insuranceDTO.getPrefecture()!="") {
            queryWrapper.eq(InsuranceList::getPrefecture, insuranceDTO.getPrefecture());
        }
        //区县
        System.out.println("区县："+insuranceDTO.getCounty());
        if (insuranceDTO.getCounty() != "") {
            queryWrapper.eq(InsuranceList::getCounty, insuranceDTO.getCounty());
        }
        //案件名称
        System.out.println("案件名称："+insuranceDTO.getCaseName());
        if (insuranceDTO.getCaseName() != "") {
            queryWrapper.like(InsuranceList::getCaseName, insuranceDTO.getCaseName());
        }
        //查询案件时间范围
        System.out.println("开始时间："+insuranceDTO.getStartDate()+"\n结束时间："+insuranceDTO.getEndDate());
        if (insuranceDTO.getStartDate() !=null && insuranceDTO.getEndDate() !=null) {
            queryWrapper.between(InsuranceList::getCaseOccurrenceTime, insuranceDTO.getStartDate(),insuranceDTO.getEndDate());
        }
        //网络层级
        System.out.println("网络层级:"+insuranceDTO.getNetworkHierarchy());
        if (insuranceDTO.getNetworkHierarchy() != "") {
            queryWrapper.eq(InsuranceList::getNetworkHierarchy, insuranceDTO.getNetworkHierarchy());
        }
        //案件进展情况
        System.out.println("案件进展情况:"+insuranceDTO.getCaseProgressSituation());
        if (insuranceDTO.getCaseProgressSituation() != "") {
            queryWrapper.eq(InsuranceList::getCaseProgressSituation, insuranceDTO.getCaseProgressSituation());
        }
        //保险报案原因分类
        System.out.println("保险报案原因分类:"+insuranceDTO.getReportingReasons());
        if (insuranceDTO.getReportingReasons() != "") {
            queryWrapper.eq(InsuranceList::getReportingReasons, insuranceDTO.getReportingReasons());
        }
        //赔付类型
        System.out.println("赔付类型:"+insuranceDTO.getCompensationType());
        if (insuranceDTO.getCompensationType() != "") {
            queryWrapper.eq(InsuranceList::getCompensationType, insuranceDTO.getCompensationType());
        }
        //赔付进度
        System.out.println("赔付进度："+insuranceDTO.getCompensationProgress());
        if (insuranceDTO.getCompensationProgress() != "") {
            queryWrapper.eq(InsuranceList::getCompensationProgress, insuranceDTO.getCompensationProgress());
        }

        //创建mapper对象，传入查询条件
        return ResponseData.ok(insuranceListMapper.selectList(queryWrapper));
    }


}




