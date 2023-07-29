package cn.edu.guet.insuranceteam.controller;

import cn.edu.guet.insuranceteam.bean.InsuranceList;
import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.service.InsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class insuranceController {
    @Autowired
    private InsuranceListService insuranceListService;

    @PostMapping("/createInsurance")
    public ResponseData createInsurance(@RequestBody InsuranceList insuranceList){
        return insuranceListService.createInsurance(insuranceList);
    }


    @PostMapping("/deleteInsurance")
    public ResponseData deleteInsurance(@RequestBody InsuranceList insuranceList){
        return insuranceListService.deleteInsurance(insuranceList);
    }

    @PostMapping("/updateInsurance")
    public ResponseData updateInsurance(@RequestBody InsuranceList insuranceList){
        System.out.println("这里走了吗？");
        return insuranceListService.updateInsurance(insuranceList);

    }

}

