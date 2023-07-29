<template>
    <div>
            <el-container direction="vertical">
                <el-header><Header></Header></el-header>
                <el-main style="margin-top: -25px;margin-left: -10px"><InsuranceMain></InsuranceMain></el-main>
            </el-container>
    </div>
</template>

<script>
import Header from "@/components/Header.vue";
import InsuranceMain from "@/components/InsuranceMain.vue";

export default {
    name: "Insurance",
    components:{
        Header,
        InsuranceMain
    }
}
</script>
<style scoped>
.el-header{
/*    background-color: #B3C0D1;*/
    color: #333;
    height: 200px;
}
.el-main {
/*    background-color: #E9EEF3;*/
    height: 800px;
}
.el-container{
    height: 100%;
}

</style>