<template>
    <div id="app">
        <router-link to="/insurance" style="text-align: center">保险清单  </router-link>
        <router-link to="/transfer">  迁改清单</router-link>
        <router-view/>
    </div>
</template>

<style lang="scss" scoped>

</style>

<script>

export default {
    name: 'App',
}

</script>