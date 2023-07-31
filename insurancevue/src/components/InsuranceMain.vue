<template>
    <div style="height: auto;width: auto;">
        <div style=" border: 5px solid #409EFF;width: 200px;background-color: #409EFF;"><span
                style="color: white;font-size: small"><i style="height: 8px;
		width: 8px;background-color: white;border-radius: 50%;
		display:inline-block;"></i> 保险清单</span></div>
          <p style="border: 0;border-top: 3px double #d0d0d5;"></p>
          <div class="text">
            <p><span>查询过滤</span></p>
          </div>
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="地州:" style="margin-left: 40px">
                <el-select placeholder="全部" style="width: 150px;" v-model="option" clearable>
                    <el-option
                            v-for="option in options"
                            :key="option.value"
                            :label="option.label"
                            :value="option.label">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="区县:">
                <el-select v-model="formInline.childPlace" placeholder="全部" style="width: 150px;" clearable>
                    <el-option>全部</el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="案件名称:">
                <el-input v-model="formInline.name" placeholder="请输入内容" style="width: 150px;"></el-input>
            </el-form-item>
            <el-form-item label="保险案件发生时间:">
              <el-date-picker
                  clearable
                  v-model="InDate"
                  type="daterange"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
              </el-date-picker>
            </el-form-item>

          </el-form>
          <el-form :inline="true" :model="formInline" class="demo-form-inline2">
            <el-form-item label="网络层级:" label-width="auto" style="margin-left: 40px">
                <el-select v-model="internet" placeholder="全部" style="width: 120px;"  clearable>
                    <el-option
                            v-for="internet in internets"
                            :key="internet.value"
                            :label="internet.label"
                            :value="internet.label">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="案件进展情况:">
                <el-select v-model="cas" placeholder="全部" style="width: 95px" clearable>
                    <el-option
                            v-for="cas in cases"
                            :key="cas.value"
                            :label="cas.label"
                            :value="cas.label">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="保险报案原因分类:" clearable>
                <el-select v-model="reason" placeholder="全部" style="width: 95px" clearable>
                    <el-option
                            v-for="reason in reasons"
                            :key="reason.value"
                            :label="reason.label"
                            :value="reason.label">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="赔付类型:" clearable>
                <el-select v-model="type" placeholder="全部" style="width: 120px" clearable>
                    <el-option
                            v-for="type in types"
                            :key="type.value"
                            :label="type.label"
                            :value="type.label">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="赔付进度:" style="margin-left: 25px" clearable>
                <el-select v-model="sch" placeholder="全部" style="width: 120px" clearable>
                    <el-option
                            v-for="sch in schedule"
                            :key="sch.value"
                            :label="sch.label"
                            :value="sch.label">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-form>
        <div class="button">
            <el-button type="primary" icon="el-icon-search" plain size="medium" style="margin-left: 40px" @click="viewInsurance">查询
            </el-button>
            <el-button type="primary" icon="el-icon-circle-plus-outline" size="medium" @click="addRouter1" >保险填报</el-button>
            <el-button type="primary" icon="el-icon-edit" size="medium">修改</el-button>
            <el-button type="primary" icon="el-icon-delete" size="medium">删除</el-button>
            <el-button type="primary" icon="el-icon-upload2" plain size="medium">导出Excel</el-button>
        </div>
      <div class="viewInsurance">
      <el-table
          ref="multipleTable"
          :data="insuranceList"
          tooltip-effect="dark"
          style="width: 100%"
          max-height="420">
        <el-table-column
            type="selection"
            width="45"
            align="center">
        </el-table-column>
        <el-table-column
            label="序号"
            type="index"
            width="50"
            align="center">
        </el-table-column>
        <el-table-column
            prop="prefecture"
            label="地州"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="county"
            label="区县"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="caseName"
            label="案件名称"
            width="120"
            align="center"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="caseOccurrenceTime"
            label="保险案发时间"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="networkHierarchy"
            label="网络层级"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="caseProgressSituation"
            label="案件进度情况"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="reportingReasons"
            label="保险报案原因分类"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="caseReporter"
            label="现场报案人"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="maintenanceManager"
            label="自维人员负责人"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="estimatedLossAmount"
            label="预估损失金额(元)"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="compensationType"
            label="赔付类型"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="compensationReceivedAmount"
            label="赔付已到账金额(元)"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="compensationReceivedTime"
            label="赔付到账具体时间"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="icLedgerRegistrationName"
            label="保险公司台账登记名称"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="icInsuranceReportNo"
            label="保险公司报案号"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="icEstimatedReparationAmount"
            label="保险公司估损赔付金额(元)"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="compensationProgress"
            label="赔付进度"
            width="120"
            align="center">
        </el-table-column>
        <el-table-column
            prop="caseCompletionConfirm"
            label="案件完结确认"
            width="120"
            align="center">
        </el-table-column>

      </el-table>
      </div>
    </div>
</template>


<script>

import axios from "axios";

export default {
    name: "InsuranceMain",
    data() {
      return {
        formInline: {
          place: '',
          childPlace: '',
          name: '',
          time: ''
        },
        InDate:'',
        input1:'',
        options: [
          {
            value: '选项1',
            label: '乌鲁木齐'
          }, {
            value: '选项2',
            label: '克拉玛依'
          }, {
            value: '选项3',
            label: '吐鲁番'
          }, {
            value: '选项4',
            label: '哈密'
          }, {
            value: '选项5',
            label: '阿克苏'
          }, {
            value: '选项6',
            label: '喀什'
          }, {
            value: '选项7',
            label: '和田'
          }, {
            value: '选项8',
            label: '昌吉'
          }, {
            value: '选项9',
            label: '博尔塔拉'
          }, {
            value: '选项10',
            label: '巴音郭楞'
          }, {
            value: '选项11',
            label: '克孜勒苏柯尔克孜'
          }, {
            value: '选项12',
            label: '伊犁'
          }, {
            value: '选项13',
            label: '塔城'
          }, {
            value: '选项14',
            label: '阿勒泰'
          }

        ],
        option:'',
        internets: [
          {
            value: '选项1',
            label: '国际政企'
          }, {
            value: '选项2',
            label: '一干'
          }, {
            value: '选项3',
            label: '二干'
          }, {
            value: '选项4',
            label: '干线OP'
          },
          {
            value: '选项5',
            label: '本地网核心'
          }, {
            value: '选项6',
            label: '本地网汇聚'
          }, {
            value: '选项7',
            label: '本地网接入'
          },
          {
            value: '选项8',
            label: '其他全部'
          },
        ],
        internet: '',
        cases: [
          {
            value: '选项2',
            label: '已到账'
          }, {
            value: '选项3',
            label: '资料完成待赔付'
          }, {
            value: '选项4',
            label: '资料收集发送中'
          },
          {
            value: '选项5',
            label: '第三方赔付协商中'
          }
        ],
        cas: '',
        reasons: [
          {
            value: '选项2',
            label: '被盗案件'
          }, {
            value: '选项3',
            label: '自然灾害'
          }, {
            value: '选项4',
            label: '火灾'
          },
          {
            value: '选项5',
            label: '第三方责任市政施工挖断'
          },
          {
            value: '选项6',
            label: '第三方责任市政施工剪断'
          },
          {
            value: '选项7',
            label: '第三方责任大车挂断'
          },
          {
            value: '选项8',
            label: '第三者责任其他'
          }
        ],
        reason: '',
        types: [
            {
            value: '选项2',
            label: '保险公司赔付'
          }, {
            value: '选项3',
            label: '第三方或个人赔付'
          }
        ],
        type:'',
        schedule: [
          {
            value: '选项2',
            label: '已赔付'
          }, {
            value: '选项3',
            label: '待赔付'
          }, {
            value: '选项4',
            label: 'PICC不予赔付'
          }
        ],
        sch:'',
        insuranceList: [],

      }
    },




    methods:{

      formatDate(date) {
        if (date) {
          const day = date.getDate().toString().padStart(2, '0'); // 获取日期并补零
          const month = (date.getMonth() + 1).toString().padStart(2, '0'); // 获取月份并补零
          const year = date.getFullYear(); // 获取年份
          return `${year}-${month}-${day}`; // 将日期格式设置为yyyy-mm-dd
        } else {
          return '';
        }
      },
        addRouter1(){
            this.$router.push("/createInsurance");
        },
      viewInsurance(){
        // console.log("开始时间"+this.formatDate(this.InDate[0])+"\n结束时间"+this.formatDate(this.InDate[1]))
         var param={
           prefecture:this.option,
           county:this.formInline.childPlace,
           caseName:this.formInline.name,
           startDate:this.formatDate(this.InDate[0]),
           endDate:this.formatDate(this.InDate[1]),
           networkHierarchy:this.internet,
           caseProgressSituation:this.cas,
           reportingReasons:this.reason,
           compensationType:this.type,
           compensationProgress:this.sch
         }
        console.log(param)
        axios.post("http://localhost:9000/viewInsurance",param)
            .then(res => {
              this.insuranceList=res.data.data
              console.log(res);
            })
            .catch(err => {
              console.log("查询保险出错啦！")
            });
      }
    },

    mounted() {
      axios.get("http://localhost:9000/insuranceSummary")
          .then(res => {
            this.insuranceList = res.data.data
          })
          .catch(err => {
            console.log("初始化数据出错啦！"+err);
          });
    }

}
</script>


<style>
.demo-form-inline2 {
    .el-form-item {
        margin-left: 50px;
    }
}

.demo-form-inline {
    .el-form-item {
        margin-top: -5px;
        margin-left: 50px;
    }
}

.button {
    .el-button {
        margin-top: 10px;
        margin-right: 20px;
    }
}
.text{
    font-family: "Microsoft YaHei",sans-serif;
    font-weight:1000;
    font-size: 20px;
    color: #409EFF;
    margin-left: 30px;
}
.viewInsurance {
  position: relative;
  background-color: black;
  margin-top: 1%;
  border: 1px solid #DCDFE6 ;
  height: 100%;
  width: 100%;
}
</style>