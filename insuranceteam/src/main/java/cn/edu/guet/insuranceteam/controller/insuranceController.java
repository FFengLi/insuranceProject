package cn.edu.guet.insuranceteam.controller;

import cn.edu.guet.insuranceteam.bean.Insurance;
import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.bean.InsuranceSummaryModel;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RestController
public class insuranceController {
    @Autowired
    private InsuranceListService insuranceListService;

    @GetMapping("/getList")
    public ResponseData getList(int id) {
        InsuranceList insuranceList = insuranceListService.getById(id);
        return ResponseData.ok(insuranceList);
    }

    @GetMapping("/insuranceSummary")
    public ResponseData insuranceSummary() {
        return insuranceListService.insuranceSummary();
    }

    @PostMapping("/exportExcel")
    public ResponseData exportExcel(@RequestBody InsuranceSummaryModel summaryModel) {
//        List<Insurance> insuranceList = (List<Insurance>) insuranceInfo.get("insuranceList");
//        Insurance insurance = new Insurance();
        System.out.println(summaryModel.getDecember());


//        InsuranceSummaryModel insuranceList = (InsuranceSummaryModel) insuranceInfo.get("insuranceList");
//        int year = (int) insuranceInfo.get("year");
//        System.out.println(insuranceList+"\n");
//        for (int i = 0; i < insuranceList.size(); i++) {
//            System.out.println(insuranceList.get(i).getTotalAmount());
//        }

//        String fileName = "F:\\desktop\\235.xlsx";
//        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        EasyExcel.write(fileName, InsuranceSummaryModel.class).sheet("所有年份").doWrite(insuranceList);
        return ResponseData.ok("ok");
    }
}
