package cn.edu.guet.insuranceteam.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName t_insurance_list
 */
@TableName(value ="t_insurance_list")
@Data
public class InsuranceList implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "insurance_id", type = IdType.AUTO)
    private Integer insuranceId;

    /**
     * 地州
     */
    @TableField(value = "prefecture")
    private String prefecture;

    /**
     * 区县
     */
    @TableField(value = "county")
    private String county;

    /**
     * 案件名称
     */
    @TableField(value = "case_name")
    private String caseName;

    /**
     * 保险案件发生时间
     */
    @TableField(value = "case_occurrence_time")
    private Date caseOccurrenceTime;

    /**
     * 网络层级
     */
    @TableField(value = "network_hierarchy")
    private String networkHierarchy;

    /**
     * 案件进展情况
     */
    @TableField(value = "case_progress_situation")
    private String caseProgressSituation;

    /**
     * 保险报案原因分类
     */
    @TableField(value = "reporting_reasons")
    private String reportingReasons;

    /**
     * 现场报案人
     */
    @TableField(value = "case_reporter")
    private String caseReporter;

    /**
     * 自维人员负责人
     */
    @TableField(value = "maintenance_manager")
    private String maintenanceManager;

    /**
     * 预估损失金额（元）
     */
    @TableField(value = "estimated_loss_amount")
    private String estimatedLossAmount;

    /**
     * 赔付类型
     */
    @TableField(value = "compensation_type")
    private String compensationType;

    /**
     * 案件完结确认
     */
    @TableField(value = "case_completion_confirm")
    private String caseCompletionConfirm;

    /**
     * 保险报案内容或事件详细说明
     */
    @TableField(value = "insurance_content_description")
    private String insuranceContentDescription;

    /**
     * 赔付已到账金额（元）
     */
    @TableField(value = "compensation_received_amount")
    private String compensationReceivedAmount;

    /**
     * 赔付到账具体时间
     */
    @TableField(value = "compensation_received_time")
    private Date compensationReceivedTime;

    /**
     * 赔付情况备注
     */
    @TableField(value = "compensation_situation_remark")
    private String compensationSituationRemark;

    /**
     * 保险公司台账登记名称
     */
    @TableField(value = "IC_ledger_registration_name")
    private String icLedgerRegistrationName;

    /**
     * 保险公司报案号
     */
    @TableField(value = "IC_insurance_report_no")
    private String icInsuranceReportNo;

    /**
     * 保险公司估损赔付金额（元）
     */
    @TableField(value = "IC_estimated_reparation_amount")
    private String icEstimatedReparationAmount;

    /**
     * 赔付进度
     */
    @TableField(value = "compensation_progress")
    private String compensationProgress;

    /**
     * 保险备注
     */
    @TableField(value = "insurance_remarks")
    private String insuranceRemarks;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InsuranceList other = (InsuranceList) that;
        return (this.getInsuranceId() == null ? other.getInsuranceId() == null : this.getInsuranceId().equals(other.getInsuranceId()))
            && (this.getPrefecture() == null ? other.getPrefecture() == null : this.getPrefecture().equals(other.getPrefecture()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getCaseName() == null ? other.getCaseName() == null : this.getCaseName().equals(other.getCaseName()))
            && (this.getCaseOccurrenceTime() == null ? other.getCaseOccurrenceTime() == null : this.getCaseOccurrenceTime().equals(other.getCaseOccurrenceTime()))
            && (this.getNetworkHierarchy() == null ? other.getNetworkHierarchy() == null : this.getNetworkHierarchy().equals(other.getNetworkHierarchy()))
            && (this.getCaseProgressSituation() == null ? other.getCaseProgressSituation() == null : this.getCaseProgressSituation().equals(other.getCaseProgressSituation()))
            && (this.getReportingReasons() == null ? other.getReportingReasons() == null : this.getReportingReasons().equals(other.getReportingReasons()))
            && (this.getCaseReporter() == null ? other.getCaseReporter() == null : this.getCaseReporter().equals(other.getCaseReporter()))
            && (this.getMaintenanceManager() == null ? other.getMaintenanceManager() == null : this.getMaintenanceManager().equals(other.getMaintenanceManager()))
            && (this.getEstimatedLossAmount() == null ? other.getEstimatedLossAmount() == null : this.getEstimatedLossAmount().equals(other.getEstimatedLossAmount()))
            && (this.getCompensationType() == null ? other.getCompensationType() == null : this.getCompensationType().equals(other.getCompensationType()))
            && (this.getCaseCompletionConfirm() == null ? other.getCaseCompletionConfirm() == null : this.getCaseCompletionConfirm().equals(other.getCaseCompletionConfirm()))
            && (this.getInsuranceContentDescription() == null ? other.getInsuranceContentDescription() == null : this.getInsuranceContentDescription().equals(other.getInsuranceContentDescription()))
            && (this.getCompensationReceivedAmount() == null ? other.getCompensationReceivedAmount() == null : this.getCompensationReceivedAmount().equals(other.getCompensationReceivedAmount()))
            && (this.getCompensationReceivedTime() == null ? other.getCompensationReceivedTime() == null : this.getCompensationReceivedTime().equals(other.getCompensationReceivedTime()))
            && (this.getCompensationSituationRemark() == null ? other.getCompensationSituationRemark() == null : this.getCompensationSituationRemark().equals(other.getCompensationSituationRemark()))
            && (this.getIcLedgerRegistrationName() == null ? other.getIcLedgerRegistrationName() == null : this.getIcLedgerRegistrationName().equals(other.getIcLedgerRegistrationName()))
            && (this.getIcInsuranceReportNo() == null ? other.getIcInsuranceReportNo() == null : this.getIcInsuranceReportNo().equals(other.getIcInsuranceReportNo()))
            && (this.getIcEstimatedReparationAmount() == null ? other.getIcEstimatedReparationAmount() == null : this.getIcEstimatedReparationAmount().equals(other.getIcEstimatedReparationAmount()))
            && (this.getCompensationProgress() == null ? other.getCompensationProgress() == null : this.getCompensationProgress().equals(other.getCompensationProgress()))
            && (this.getInsuranceRemarks() == null ? other.getInsuranceRemarks() == null : this.getInsuranceRemarks().equals(other.getInsuranceRemarks()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInsuranceId() == null) ? 0 : getInsuranceId().hashCode());
        result = prime * result + ((getPrefecture() == null) ? 0 : getPrefecture().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getCaseName() == null) ? 0 : getCaseName().hashCode());
        result = prime * result + ((getCaseOccurrenceTime() == null) ? 0 : getCaseOccurrenceTime().hashCode());
        result = prime * result + ((getNetworkHierarchy() == null) ? 0 : getNetworkHierarchy().hashCode());
        result = prime * result + ((getCaseProgressSituation() == null) ? 0 : getCaseProgressSituation().hashCode());
        result = prime * result + ((getReportingReasons() == null) ? 0 : getReportingReasons().hashCode());
        result = prime * result + ((getCaseReporter() == null) ? 0 : getCaseReporter().hashCode());
        result = prime * result + ((getMaintenanceManager() == null) ? 0 : getMaintenanceManager().hashCode());
        result = prime * result + ((getEstimatedLossAmount() == null) ? 0 : getEstimatedLossAmount().hashCode());
        result = prime * result + ((getCompensationType() == null) ? 0 : getCompensationType().hashCode());
        result = prime * result + ((getCaseCompletionConfirm() == null) ? 0 : getCaseCompletionConfirm().hashCode());
        result = prime * result + ((getInsuranceContentDescription() == null) ? 0 : getInsuranceContentDescription().hashCode());
        result = prime * result + ((getCompensationReceivedAmount() == null) ? 0 : getCompensationReceivedAmount().hashCode());
        result = prime * result + ((getCompensationReceivedTime() == null) ? 0 : getCompensationReceivedTime().hashCode());
        result = prime * result + ((getCompensationSituationRemark() == null) ? 0 : getCompensationSituationRemark().hashCode());
        result = prime * result + ((getIcLedgerRegistrationName() == null) ? 0 : getIcLedgerRegistrationName().hashCode());
        result = prime * result + ((getIcInsuranceReportNo() == null) ? 0 : getIcInsuranceReportNo().hashCode());
        result = prime * result + ((getIcEstimatedReparationAmount() == null) ? 0 : getIcEstimatedReparationAmount().hashCode());
        result = prime * result + ((getCompensationProgress() == null) ? 0 : getCompensationProgress().hashCode());
        result = prime * result + ((getInsuranceRemarks() == null) ? 0 : getInsuranceRemarks().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", insuranceId=").append(insuranceId);
        sb.append(", prefecture=").append(prefecture);
        sb.append(", county=").append(county);
        sb.append(", caseName=").append(caseName);
        sb.append(", caseOccurrenceTime=").append(caseOccurrenceTime);
        sb.append(", networkHierarchy=").append(networkHierarchy);
        sb.append(", caseProgressSituation=").append(caseProgressSituation);
        sb.append(", reportingReasons=").append(reportingReasons);
        sb.append(", caseReporter=").append(caseReporter);
        sb.append(", maintenanceManager=").append(maintenanceManager);
        sb.append(", estimatedLossAmount=").append(estimatedLossAmount);
        sb.append(", compensationType=").append(compensationType);
        sb.append(", caseCompletionConfirm=").append(caseCompletionConfirm);
        sb.append(", insuranceContentDescription=").append(insuranceContentDescription);
        sb.append(", compensationReceivedAmount=").append(compensationReceivedAmount);
        sb.append(", compensationReceivedTime=").append(compensationReceivedTime);
        sb.append(", compensationSituationRemark=").append(compensationSituationRemark);
        sb.append(", icLedgerRegistrationName=").append(icLedgerRegistrationName);
        sb.append(", icInsuranceReportNo=").append(icInsuranceReportNo);
        sb.append(", icEstimatedReparationAmount=").append(icEstimatedReparationAmount);
        sb.append(", compensationProgress=").append(compensationProgress);
        sb.append(", insuranceRemarks=").append(insuranceRemarks);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}