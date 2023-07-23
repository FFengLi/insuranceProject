package cn.edu.guet.insuranceteam.controller;

import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class insuranceController {
    @Autowired
    private InsuranceListService insuranceListService;

    @GetMapping("/getList")
    public ResponseData getList(int id) {
        InsuranceList insuranceList = insuranceListService.getById(id);
        return ResponseData.ok(insuranceList);
    }

    @GetMapping("/getList1")
    public ResponseData getList1(int id){
        InsuranceList insuranceList=insuranceListService.getById(id);
        return ResponseData.ok(insuranceList);


    @GetMapping("insuranceSummary")
    public ResponseData insuranceSummary(int id) {
        return null;
    }
}
