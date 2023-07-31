<template>
    <div>
        <el-container direction="vertical1">
            <el-header>
                <Header></Header>
            </el-header>

        </el-container>
      <el-container direction="vertical2">
        <el-header>
          <Header></Header>
        </el-header>

      </el-container>
    </div>

</template>


<script>

import {defineComponent} from "vue";
import Header from "@/components/Header.vue";

export default defineComponent({
    name: "Transfer",
    components: {
        Header
    },
})
</script>


<style scoped>
.el-header {
    /*    background-color: #B3C0D1;*/
    color: #333;
    height: 200px;
}
</style>