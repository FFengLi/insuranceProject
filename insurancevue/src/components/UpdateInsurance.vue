<template>
  <div>
    <el-container direction="vertical2">
      <el-header>
        <Header></Header>
      </el-header>
      <el-main ID="UPDATE" style="margin-top: -20px">

        <div style=" border: 5px solid #409EFF;width: 200px;background-color: #409EFF;"><span
            style="color: white;font-size: small"><i style="height: 8px;
		width: 8px;background-color: white;border-radius: 50%;
		display:inline-block;"></i> 新增保险填报</span></div>
        <p style="border: 0;border-top: 3px double #d0d0d5;margin-top: 3px"></p>
        <div class="text">
          <p><span>新增保险填报</span></p>
        </div>
        <div class="title">
          <p><span>一、案件信息</span></p>
        </div>
        <div>
          <el-form :label-position="labelPosition" label-width="200px" :model="formLabelAlign1" :inline="true">
            <el-form-item label="* 地州：" style="width: 600px;">
              <el-select v-model="formLabelAlign1.prefecture" placeholder="请选择活动区域">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="* 区县：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.county"></el-input>
            </el-form-item>
            <el-form-item label="* 案件名称：" style="width: 600px">
              <el-input v-model="formLabelAlign1.caseName"></el-input>
            </el-form-item>
            <el-form-item label="* 保险案件发生时间：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.caseOccurrenceTime"></el-input>
            </el-form-item>
            <el-form-item label="* 网络层级：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.networkHierarchy"></el-input>
            </el-form-item>
            <el-form-item label="* 案件进展情况：">
              <el-input v-model="formLabelAlign1.caseProgressSituation"></el-input>
            </el-form-item>
            <el-form-item label="* 保险报案原因分类：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.reportingReasons"></el-input>
            </el-form-item>
            <el-form-item label="* 现场报案人：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.caseReporter"></el-input>
            </el-form-item>
            <el-form-item label="* 自维人员负责人：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.maintenanceManager"></el-input>
            </el-form-item>
            <el-form-item label="* 预估损失金额（元）：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.estimatedLossAmount"></el-input>
            </el-form-item>
            <el-form-item label="* 赔付类型：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.compensationType"></el-input>
            </el-form-item>
            <el-form-item label="* 案件完结确认：">
              <el-input v-model="formLabelAlign1.caseCompletionConfirm"></el-input>
            </el-form-item>
            <el-form-item label="* 保险报案内容或事件详细说明：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.insuranceContentDescription"
                        type="textarea" :rows="7" style="margin-left: 160px;width: 900px"></el-input>
            </el-form-item>
            <div class="title">
              <p><span>二、赔付情况</span></p>
            </div>
            <el-form-item label="* 赔付已到账金额（元）：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.compensationReceivedAmount"></el-input>
            </el-form-item>
            <el-form-item label="* 赔付到账具体时间：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.compensationReceivedTime"></el-input>
            </el-form-item>
            <el-form-item label="* 赔付情况备注：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.compensationSituationRemark"
                        type="textarea" :rows="7" style="margin-left: 160px;width: 900px"></el-input>
            </el-form-item>
            <div class="title">
              <p><span>三、保险信息</span></p>
            </div>
            <el-form-item label="* 保险公司台账登记名称：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.icLedgerRegistrationName"></el-input>
            </el-form-item>
            <el-form-item label="* 保险公司报案号：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.icInsuranceReportNo"></el-input>
            </el-form-item>
            <el-form-item label="* 保险公司估损赔付金额（元）：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.icEstimatedReparationAmount"></el-input>
            </el-form-item>
            <el-form-item label="* 赔付进度：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.compensationProgress"></el-input>
            </el-form-item>
            <el-form-item label="* 保险备注：" style="width: 600px;">
              <el-input v-model="formLabelAlign1.insuranceRemarks"
                        type="textarea" :rows="7" style="margin-left: 160px;width: 900px"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div style="text-align: center  " >
          <el-button type="primary"  size="medium" @click="save()" >保存</el-button>
          <el-button type="primary"  size="medium" @click="save()" >保存并继续添加</el-button>
        </div>
      </el-main>
    </el-container>
  </div>
</template>


<script>

import {defineComponent} from "vue";
import Header from "@/components/Header.vue";
import InsuranceMain from "@/components/InsuranceMain.vue";
import axios from "axios";

export default defineComponent({
  name: "UpdateInsurance",
  components: {InsuranceMain, Header},
  data() {
    return {
      labelPosition: 'left',
      formLabelAlign1: {
        insuranceId:'27',
        prefecture: '乌鲁木齐',
        county: '水磨沟',
        caseName: '案件名称~*****',
        networkHierarchy: '一干',
        caseOccurrenceTime: '2023-04-03 10:30:14',
        caseProgressSituation: '资料收集中',
        reportingReasons: '火灾',
        caseReporter: '李四',
        maintenanceManager: '李四',
        estimatedLossAmount: '1320000.00',
        compensationType: '第三方或个人赔付',
        caseCompletionConfirm: '已结案并到账',
        insuranceContentDescription: '无',
        compensationReceivedAmount: '1320000.00',
        compensationReceivedTime:'2023-04-03 10:30:14',
        compensationSituationRemark:'无',
        icLedgerRegistrationName:'第**号案件(保险)',
        icInsuranceReportNo:'BX-PICC-001A',
        icEstimatedReparationAmount:'1320000.00',
        compensationProgress:'待赔付',
        insuranceRemarks:'无'
      },
    };
  },
  methods: {
    save() {
      axios({
        method: 'post',
        url: 'http://localhost:9000/updateInsurance',
        data: this.formLabelAlign1

      })
          .then(function(response) {
            // 更新成功的处理
            console.log(response.data);
          })
          .catch(function(error) {
            // 更新失败的处理
            console.error(error);
          });
    }
  }
})

</script>

<style scoped>
.text {
  font-family: "Microsoft YaHei", sans-serif;
  font-weight: 1000;
  font-size: 20px;
  color: #409EFF;
  margin-left: 5px;
}

.title {
  font-family: "Microsoft YaHei", sans-serif;
  font-weight: 1000;
  font-size: 20px;
  margin-left: 40px;
}

#UPDATE
.el-form-item {
  margin-left: 40px;

}
</style>