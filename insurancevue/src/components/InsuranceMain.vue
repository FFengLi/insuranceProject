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
                <el-select v-model="value" placeholder="全部" style="width: 125px;">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="区县:">
                <el-select v-model="formInline.childplace" placeholder="全部" style="width: 150px;">
                    <el-option>全部</el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="案件名称:">
                <el-input v-model="formInline.name" placeholder="请输入内容" style="width: 130px;"></el-input>
            </el-form-item>
            <el-form-item label="保险案件发生时间:">
                <el-input style="width: 250px;"
                          placeholder="开始时间~结束时间"
                          suffix-icon="el-icon-date"
                          v-model="input1">
                </el-input>
            </el-form-item>

        </el-form>
        <el-form :inline="true" :model="formInline" class="demo-form-inline2">
            <el-form-item label="网络层级:" label-width="auto" style="margin-left: 40px">
                <el-select v-model="value" placeholder="全部" style="width: 100px;">
                    <el-option
                            v-for="item in internets"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="案件进展情况:">
                <el-select v-model="value" placeholder="全部" style="width: 90px">
                    <el-option
                            v-for="item in cases"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="保险报案原因分类:">
                <el-select v-model="value" placeholder="全部" style="width: 80px">
                    <el-option
                            v-for="item in reasons"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="赔付类型:">
                <el-select v-model="value" placeholder="全部" style="width: 90px">
                    <el-option
                            v-for="item in types"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="赔付进度:" style="margin-left: 25px">
                <el-select v-model="value" placeholder="全部" style="width: 100px">
                    <el-option
                            v-for="item in schedule"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-form>
        <div class="button">
            <el-button type="primary" icon="el-icon-search" plain size="medium" style="margin-left: 40px">查询
            </el-button>
            <el-button type="primary" icon="el-icon-circle-plus-outline" size="medium">保险填报</el-button>
            <el-button type="primary" icon="el-icon-edit" size="medium">修改</el-button>
            <el-button type="primary" icon="el-icon-delete" size="medium">删除</el-button>
            <el-button type="primary" icon="el-icon-upload2" plain size="medium">导出Excel</el-button>
        </div>
    </div>
</template>


<script>

export default {
    name: "InsuranceMian",
    data() {
        return {
            formInline: {
                place: '',
                childplace: '',
                name: '',
                time: ''
            },
            options: [{
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
            cases: [
                {
                    value: '选项1',
                    label: '全部'
                }, {
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
            reasons: [
                {
                    value: '选项1',
                    label: '全部'
                }, {
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
                    value: '选项6',
                    label: '第三方责任市政施工挖断'
                },
                {
                    value: '选项7',
                    label: '第三方责任市政施工剪断'
                },
                {
                    value: '选项8',
                    label: '第三方责任大车挂断'
                },
                {
                    value: '选项5',
                    label: '第三者责任其他'
                },
                {
                    value: '选项5',
                    label: '第三方责任市政施工挖断'
                }
            ],
            types: [
                {
                    value: '选项1',
                    label: '全部'
                }, {
                    value: '选项2',
                    label: '保险公司赔付'
                }, {
                    value: '选项3',
                    label: '第三方或个人赔付'
                }
            ],
            schedule: [
                {
                    value: '选项1',
                    label: '全部'
                }, {
                    value: '选项2',
                    label: '已赔付'
                }, {
                    value: '选项3',
                    label: '待赔付'
                }, {
                    value: '选项4',
                    label: 'PICC不予赔付'
                }
            ]
        }
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
</style>