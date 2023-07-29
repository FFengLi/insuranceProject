package cn.edu.guet.insuranceteam.controller;

import cn.edu.guet.insuranceteam.common.ResponseData;
import cn.edu.guet.insuranceteam.service.ModifyBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: fanFengLi
 * @Date: 2023/07/23/16:21
 * @Description:
 */
@RestController
@RequestMapping("/modify")
public class ModifyController {
    @Autowired
    private ModifyBasicInfoService modifyBasicInfoService;
    @GetMapping("/getListSummary")
    public ResponseData getModifyListSummary(String year,String timeType){
       ResponseData responseData = modifyBasicInfoService.getModifyListSummary(year,timeType);
       return responseData;
    }
}
