<template>
  <div class="insuranceSummary">
    年份:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <el-select v-model="value" placeholder="请选择">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.label">
      </el-option>
    </el-select>
    <el-button type="primary" class="searchButton" @click="GetYearSummary(value)">
      <i class="el-icon-search"></i>&nbsp;&nbsp;查询
    </el-button>
    <el-button type="primary" plain class="exportButton" @click="ExportExcel()"><i class="el-icon-upload2"></i>导出Excel</el-button>
    <el-table
        class="el-table"
        :data="tableData"
        border
        height="500"
        :summary-method="getSummaries"
        show-summary
        style="width: 100%; margin-top: 20px">
      <el-table-column>
          <template #header>
            <label class="titleLabel" v-if="year=='所有年份'">{{ year }}的保险类</label>
            <label class="titleLabel" v-else>{{ year }}年保险类</label>
          </template>
        <el-table-column
            align="center"
            prop="prefecture"
            label="地州"
            width="150">
        </el-table-column>
        <el-table-column
            align="center"
            prop="total"
            label="总数量"
            width="70">
        </el-table-column>
        <el-table-column
            v-for="month in months"
            align="center"
            :prop="month.value"
            :label="month.num+'月'"
            width="60">
        </el-table-column>
        <el-table-column
            align="center"
            prop="totalAmount"
            label="合计金额（万元）">
        </el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: 'insuranceSummary',
  components: {
  },

  data() {
    return {
      tableData: [],
      options:[{
        value:'选项1',
        label: '所有年份',
      },{
        value:'选项2',
        label: '2019',
      },{
        value:'选项3',
        label: '2020',
      },{
        value:'选项4',
        label: '2021',
      },{
        value:'选项5',
        label: '2022',
      },{
        value:'选项6',
        label: '2023',
      },{
        value:'选项7',
        label: '2024',
      },
      ],
      value: '所有年份',
      year:this.value,

      months: [{
        num: '1',
        value: 'january',
      },{
        num: '2',
        value: 'february',
      },{
        num: '3',
        value: 'march',
      },{
        num: '4',
        value: 'april',
      },{
        num: '5',
        value: 'may',
      },{
        num: '6',
        value: 'june',
      },{
        num: '7',
        value: 'july',
      },{
        num: '8',
        value: 'august',
      },{
        num: '9',
        value: 'september',
      },{
        num: '10',
        value: 'october',
      },{
        num: '11',
        value: 'november',
      },{
        num: '12',
        value: 'december',
      }
      ],
      totalRows:[],

    };
  },
  methods: {

    // 获取总数量的值
    // getNum()
    // 获取合计数量
    getSummaries(param) {
      console.log("合计函数")
      const { columns, data } = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = '合计';
          return;
        }

        const values = data.map(item => Number(item[column.property]));
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr);
            if (!isNaN(value)) {
              return prev + curr;

            } else {
              return prev;
            }
          }, 0);

        } else {
          sums[index] = 0;
        }
      });
      // console.log(sums)
      this.totalRows = sums;
      return sums;
    },

    // 获取月份得函数
    GetMonth(insurance){
      // 对数组tableData中有该保险名称的数据获取其创建月份，month为该保险月份
      const date = new Date(insurance.caseOccurrenceTime); // 创建日期对象
      // 该函数得到的月份从0开始计算，所以要+1
      const month = date.getMonth() + 1;
      // console.log("读取到的月份", month);

      // 从months数组中找到月份对应的prop，以便进行DOM操作,mon中的数据就是对应的月份的英文缩写
      const mon = (this.months.find(result => result.num === String(month))).value;
      return mon;
    },

    InsuranceSummary(insuranceList){
      this.tableData=[],
      // console.log(insuranceList);
      // 循环遍历保险清单，拿到单个保险的内容insurance
      insuranceList.forEach(insurance => {

        // 寻找数组tableData中与保险内容相同名称的数据，并存在existingData中，如果没有值，则为空
        const existingData = this.tableData.find(data => insurance.prefecture === data.prefecture);

        // 如果找到了符合条件的对象，则进行修改
        if (existingData) {
          // 调用获取月份的函数
          const mon = this.GetMonth(insurance);

          // 如果存在该对象，每次执行时total+1
          existingData.total = String(Number(existingData.total) + 1);
          // 金额相加
          existingData.totalAmount = (Number(existingData.totalAmount) + Number(insurance.compensationReceivedAmount)).toFixed(2);

          if (existingData.hasOwnProperty(mon)) {
            // 如果数据属性中有mon，则将该值+1
            existingData[mon] = String(Number(existingData[mon]) + 1);
          } else {
            // 如果数据属性中没有mon，则添加一个属性名为mon的属性，值为1
            this.$set(existingData, mon, '1');
          }
        } else {
          // 调用获取月份的函数
          const mon = this.GetMonth(insurance);
          const rowData={
            prefecture:insurance.prefecture,
            total:'1',
            [mon]:'1',
            totalAmount:Number(insurance.compensationReceivedAmount).toFixed(2),
          }
          this.tableData.push(rowData);
        }
      });
      console.log("最后的数据label:", this.tableData);

    },

    GetYearSummary(year) {
      this.year=year
      axios.get("http://localhost:9000/insuranceSummary")
          .then(res => {
            const insuranceList = res.data.data;
            if (year == "所有年份") {
              this.InsuranceSummary(insuranceList);
            } else {
              console.log(year)
              const rowData=[]
              insuranceList.forEach(insurance => {
                // 对数组tableData中有该保险名称的数据获取其创建年份，option为该保险年份
                const date = new Date(insurance.caseOccurrenceTime); // 创建日期对象
                const option = date.getFullYear();
                if (Number(year)==option) {
                  rowData.push(insurance);
                }
              });
              this.InsuranceSummary(rowData);
            }
          })
          .catch(err => {
            console.log("出错啦！");
          });

    },

    ExportExcel() {
      const tableData = [];
      this.tableData.forEach(data => {
        tableData.push(data)
      });

      const totalRows = this.totalRows;
      const newTotalRows =  {
        prefecture:totalRows[0],
        total:totalRows[1],
        january:totalRows[2],
        february:totalRows[3],
        march:totalRows[4],
        april:totalRows[5],
        may:totalRows[6],
        june:totalRows[7],
        july:totalRows[8],
        august:totalRows[9],
        september:totalRows[10],
        october:totalRows[11],
        november:totalRows[12],
        december:totalRows[13],
        totalAmount:totalRows[14],
      }
      tableData.push(newTotalRows)
      console.log(tableData);
      console.log(this.tableData)
      axios.post("http://localhost:9000/exportExcel",(newTotalRows,this.year))
      .then(res=> {
        console.log(res);
      })
      .catch(err=>{
        console.log(err);
      });

    }

  },




  mounted() {
      this.GetYearSummary(this.value)
  }
}
</script>

<style scoped>
  .searchButton{
    margin-left: 50px;
  }
  .exportButton{
    margin-left: 492px;
  }

  .titleLabel {
    display: block;
    text-align: center;
    font-size: 20px;
  }

  .insuranceSummary {
    position: absolute;
    top: 5%;
    left: 7%;
    width: 70%;
  }
</style>