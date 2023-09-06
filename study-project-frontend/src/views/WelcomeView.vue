<template>
  <div style="width: 100vw;height: 100vh;overflow: hidden;display: flex">
    <div style="flex: 1;background-color: beige">
      <el-image style="width: 100%;height: 100%;" fit="cover"
                src="https://w.wallhaven.cc/full/1p/wallhaven-1pd1o9.jpg"/>
    </div>
    <div class="welcome-title">
      <div style="font-weight: bold;font-size: 20px">欢迎来到我们的学习平台</div>
      <div>在这里你可以学习如何使用Java,如何搭建网站</div>
      <div>System.out.println("Hello World!")</div>
    </div>
    <div style="width: 400px;background-color: white">
      <router-view/>

    </div>
  </div>

</template>

<script setup>

</script>

<style scoped>
.welcome-title{
  position: absolute;
  bottom: 30px;
  left: 30px;
  color: yellow;
  text-shadow: 0 0 10px black;
}
</style>