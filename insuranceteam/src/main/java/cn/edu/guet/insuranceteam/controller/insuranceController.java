package cn.edu.guet.insuranceteam.controller;

import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.bean.InsuranceSummaryModel;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class insuranceController {
    @Autowired
    private InsuranceListService insuranceListService;

    @PostMapping("/createInsurance")
    public ResponseData createInsurance(@RequestBody InsuranceList insuranceList){
        return insuranceListService.createInsurance(insuranceList);
    }


    @GetMapping("/insuranceSummary")
    public ResponseData insuranceSummary() {
        return insuranceListService.insuranceSummary();
    }

    @PostMapping("/exportExcel")
    public ResponseData exportExcel(@RequestBody List<InsuranceSummaryModel> summaryModelList) {
        return insuranceListService.summaryExportExcel(summaryModelList);


    @PostMapping("/deleteInsurance")
    public ResponseData deleteInsurance(@RequestBody InsuranceList insuranceList){
        return insuranceListService.deleteInsurance(insuranceList);

    }

}

