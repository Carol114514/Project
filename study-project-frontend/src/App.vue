<script setup>

import {useStore} from "@/stores";

const store = useStore()
const user = localStorage.getItem('user')

if (user != null){
  store.auth.user = JSON.parse(user)
}


</script>

<template>
  <router-view/>
</template>

<style scoped>

</style>
