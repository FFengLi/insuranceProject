package cn.edu.guet.insuranceteam.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 保险查询封装实例类
 * @author LGL
 */
@Data
public class InsuranceDTO {

    /**
     * 地州
     */
    private String prefecture;

    /**
     * 区县
     */
    private String county;

    /**
     * 案件名称
     */
    private String caseName;

    /**
     * 案件时间范围的开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 案件时间范围的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 网络层级
     */
    private String networkHierarchy;

    /**
     * 案件进展情况
     */
    private String caseProgressSituation;

    /**
     * 保险报案原因分类
     */
    private String reportingReasons;

    /**
     * 赔付类型
     */
    private String compensationType;

    /**
     * 赔付进度
     */
    private String compensationProgress;

}
