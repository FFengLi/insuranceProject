package cn.edu.guet.insuranceteam.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName modify_basic_info
 */
@TableName(value ="modify_basic_info")
@Data
public class ModifyBasicInfo implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Integer id;

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
     * 市政迁改项目名称
     */
    @TableField(value = "modify_project_name")
    private Date modifyProjectName;

    /**
     * 预计管线维修总费用（不含税）万元
     */
    @TableField(value = "estimated_maintain_total_ cost")
    private String estimatedMaintainTotalCost;

    /**
     * 预计开工时间
     */
    @TableField(value = "scheduled_date")
    private Date scheduledDate;

    /**
     * 预计完工时间
     */
    @TableField(value = "expected_completion_time")
    private Date expectedCompletionTime;

    /**
     * 政府接口人
     */
    @TableField(value = "government_ interfacer")
    private String governmentInterfacer;

    /**
     * 政府接口人联系方式
     */
    @TableField(value = "government_interfacer_cif")
    private String governmentInterfacerCif;

    /**
     * 我方接口人
     */
    @TableField(value = "our_ interfacer")
    private String ourInterfacer;

    /**
     * 我方接口人联系方式
     */
    @TableField(value = "our_interfacer_cif")
    private String ourInterfacerCif;

    /**
     * 签谈进展
     */
    @TableField(value = "discuss_schedule")
    private String discussSchedule;

    /**
     * 实际完成时间
     */
    @TableField(value = "actual_completion_time")
    private Date actualCompletionTime;

    /**
     * 通过赔补解决的费用（不含税）万元
     */
    @TableField(value = "compensation_costs")
    private String compensationCosts;

    /**
     * 无法通过赔补解决需要通过管线维修解决的费用（不含税）万元
     */
    @TableField(value = "wire_maintain_costs")
    private String wireMaintainCosts;

    /**
     * 赔补对应的其他费用支出预算名称
     */
    @TableField(value = "other_budget_name")
    private String otherBudgetName;

    /**
     * 赔补对应的其他费用支出预算编号：
     */
    @TableField(value = "other_budget_id")
    private String otherBudgetId;

    /**
     * 管线维修费预算名称
     */
    @TableField(value = "maintain_budget_name")
    private String maintainBudgetName;

    /**
     * 赔补进度：
     */
    @TableField(value = "compensation_schedule")
    private String compensationSchedule;

    /**
     * 项目简介
     */
    @TableField(value = "item_describe")
    private String itemDescribe;

    /**
     * 无法通过赔补解决的原因分析
     */
    @TableField(value = "unresolved_result_analysis")
    private String unresolvedResultAnalysis;

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
        ModifyBasicInfo other = (ModifyBasicInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrefecture() == null ? other.getPrefecture() == null : this.getPrefecture().equals(other.getPrefecture()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getModifyProjectName() == null ? other.getModifyProjectName() == null : this.getModifyProjectName().equals(other.getModifyProjectName()))
            && (this.getEstimatedMaintainTotalCost() == null ? other.getEstimatedMaintainTotalCost() == null : this.getEstimatedMaintainTotalCost().equals(other.getEstimatedMaintainTotalCost()))
            && (this.getScheduledDate() == null ? other.getScheduledDate() == null : this.getScheduledDate().equals(other.getScheduledDate()))
            && (this.getExpectedCompletionTime() == null ? other.getExpectedCompletionTime() == null : this.getExpectedCompletionTime().equals(other.getExpectedCompletionTime()))
            && (this.getGovernmentInterfacer() == null ? other.getGovernmentInterfacer() == null : this.getGovernmentInterfacer().equals(other.getGovernmentInterfacer()))
            && (this.getGovernmentInterfacerCif() == null ? other.getGovernmentInterfacerCif() == null : this.getGovernmentInterfacerCif().equals(other.getGovernmentInterfacerCif()))
            && (this.getOurInterfacer() == null ? other.getOurInterfacer() == null : this.getOurInterfacer().equals(other.getOurInterfacer()))
            && (this.getOurInterfacerCif() == null ? other.getOurInterfacerCif() == null : this.getOurInterfacerCif().equals(other.getOurInterfacerCif()))
            && (this.getDiscussSchedule() == null ? other.getDiscussSchedule() == null : this.getDiscussSchedule().equals(other.getDiscussSchedule()))
            && (this.getActualCompletionTime() == null ? other.getActualCompletionTime() == null : this.getActualCompletionTime().equals(other.getActualCompletionTime()))
            && (this.getCompensationCosts() == null ? other.getCompensationCosts() == null : this.getCompensationCosts().equals(other.getCompensationCosts()))
            && (this.getWireMaintainCosts() == null ? other.getWireMaintainCosts() == null : this.getWireMaintainCosts().equals(other.getWireMaintainCosts()))
            && (this.getOtherBudgetName() == null ? other.getOtherBudgetName() == null : this.getOtherBudgetName().equals(other.getOtherBudgetName()))
            && (this.getOtherBudgetId() == null ? other.getOtherBudgetId() == null : this.getOtherBudgetId().equals(other.getOtherBudgetId()))
            && (this.getMaintainBudgetName() == null ? other.getMaintainBudgetName() == null : this.getMaintainBudgetName().equals(other.getMaintainBudgetName()))
            && (this.getCompensationSchedule() == null ? other.getCompensationSchedule() == null : this.getCompensationSchedule().equals(other.getCompensationSchedule()))
            && (this.getItemDescribe() == null ? other.getItemDescribe() == null : this.getItemDescribe().equals(other.getItemDescribe()))
            && (this.getUnresolvedResultAnalysis() == null ? other.getUnresolvedResultAnalysis() == null : this.getUnresolvedResultAnalysis().equals(other.getUnresolvedResultAnalysis()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrefecture() == null) ? 0 : getPrefecture().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getModifyProjectName() == null) ? 0 : getModifyProjectName().hashCode());
        result = prime * result + ((getEstimatedMaintainTotalCost() == null) ? 0 : getEstimatedMaintainTotalCost().hashCode());
        result = prime * result + ((getScheduledDate() == null) ? 0 : getScheduledDate().hashCode());
        result = prime * result + ((getExpectedCompletionTime() == null) ? 0 : getExpectedCompletionTime().hashCode());
        result = prime * result + ((getGovernmentInterfacer() == null) ? 0 : getGovernmentInterfacer().hashCode());
        result = prime * result + ((getGovernmentInterfacerCif() == null) ? 0 : getGovernmentInterfacerCif().hashCode());
        result = prime * result + ((getOurInterfacer() == null) ? 0 : getOurInterfacer().hashCode());
        result = prime * result + ((getOurInterfacerCif() == null) ? 0 : getOurInterfacerCif().hashCode());
        result = prime * result + ((getDiscussSchedule() == null) ? 0 : getDiscussSchedule().hashCode());
        result = prime * result + ((getActualCompletionTime() == null) ? 0 : getActualCompletionTime().hashCode());
        result = prime * result + ((getCompensationCosts() == null) ? 0 : getCompensationCosts().hashCode());
        result = prime * result + ((getWireMaintainCosts() == null) ? 0 : getWireMaintainCosts().hashCode());
        result = prime * result + ((getOtherBudgetName() == null) ? 0 : getOtherBudgetName().hashCode());
        result = prime * result + ((getOtherBudgetId() == null) ? 0 : getOtherBudgetId().hashCode());
        result = prime * result + ((getMaintainBudgetName() == null) ? 0 : getMaintainBudgetName().hashCode());
        result = prime * result + ((getCompensationSchedule() == null) ? 0 : getCompensationSchedule().hashCode());
        result = prime * result + ((getItemDescribe() == null) ? 0 : getItemDescribe().hashCode());
        result = prime * result + ((getUnresolvedResultAnalysis() == null) ? 0 : getUnresolvedResultAnalysis().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prefecture=").append(prefecture);
        sb.append(", county=").append(county);
        sb.append(", modifyProjectName=").append(modifyProjectName);
        sb.append(", estimatedMaintainTotalCost=").append(estimatedMaintainTotalCost);
        sb.append(", scheduledDate=").append(scheduledDate);
        sb.append(", expectedCompletionTime=").append(expectedCompletionTime);
        sb.append(", governmentInterfacer=").append(governmentInterfacer);
        sb.append(", governmentInterfacerCif=").append(governmentInterfacerCif);
        sb.append(", ourInterfacer=").append(ourInterfacer);
        sb.append(", ourInterfacerCif=").append(ourInterfacerCif);
        sb.append(", discussSchedule=").append(discussSchedule);
        sb.append(", actualCompletionTime=").append(actualCompletionTime);
        sb.append(", compensationCosts=").append(compensationCosts);
        sb.append(", wireMaintainCosts=").append(wireMaintainCosts);
        sb.append(", otherBudgetName=").append(otherBudgetName);
        sb.append(", otherBudgetId=").append(otherBudgetId);
        sb.append(", maintainBudgetName=").append(maintainBudgetName);
        sb.append(", compensationSchedule=").append(compensationSchedule);
        sb.append(", itemDescribe=").append(itemDescribe);
        sb.append(", unresolvedResultAnalysis=").append(unresolvedResultAnalysis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}