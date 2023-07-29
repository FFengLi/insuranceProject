package cn.edu.guet.insuranceteam.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: fanFengLi
 * @Date: 2023/07/23/16:07
 * @Description:
 */

@Data
@TableName(value ="modify_basic_info")
public class ModifyListSummaryVo{
    // 地州
    private String prefecture;
    // 改赔补数
    private Integer changeCompensateAmount;
    // 1月改赔补数
    private Integer januaryAmount;
    // 2月改赔补数
    private Integer februaryAmount;
    // 3月改赔补数
    private Integer marchAmount;
    // 4月改赔补数
    private Integer aprilAmount;
    // 5月改赔补数
    private Integer mayAmount;
    // 6月改赔补数
    private Integer juneAmount;
    // 7月改赔补数
    private Integer julyAmount;
    // 8月改赔补数
    private Integer augustAmount;
    // 9月改赔补数
    private Integer septemberAmount;
    // 10月改赔补数
    private Integer octoberAmount;
    // 11月改赔补数
    private Integer novemberAmount;
    // 12月改赔补数
    private Integer decemberAmount;
    // 合计金额（万元）
    private Integer totalAmount;
}
