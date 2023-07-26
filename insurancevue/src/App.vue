<template>
    <div id="app">
        <router-link to="/insurance">保险清单  </router-link>
        <router-link to="/transfer">  迁改清单</router-link>
        <router-view/>
    </div>
</template>

<style lang="scss">


</style>

<script>

export default {
    name: 'App',
}

</script>