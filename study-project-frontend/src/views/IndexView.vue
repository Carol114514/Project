<template>
  <div style="height: 100vh">
    <el-container style="height: 100%">
      <el-aside style="border-right: solid 1px #d3d3d3;transition: 0.5s" :width="isCollapse ? '220px' : '60px'">
        <div style="text-align: center;padding: 15px 0;margin-left: -35px">
          <el-image src="https://th.wallhaven.cc/small/vg/vgvxm5.jpg"
                    style="width: 150px"/>
        </div>
        <el-menu
            :default-active="router.currentRoute.value.path"
            router
            :collapse="!isCollapse"
            style="border: none">
          <el-menu-item index="/index">
            <el-icon><Comment /></el-icon>
            <span slot="title">帖子列表</span>
          </el-menu-item>
          <el-menu-item index="2" disabled>
            <el-icon><document /></el-icon>
            <span slot="title">表白墙</span>
          </el-menu-item>
          <el-menu-item index="3">
            <el-icon><setting /></el-icon>
            <span slot="title">帖子管理</span>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon><star /></el-icon>
            <span slot="title">我的收藏</span>
          </el-menu-item>
          <el-menu-item index="/index/settings">
            <el-icon><Edit /></el-icon>
            <span slot="title">个人设置</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header style="border-bottom: solid 1px #d3d3d3;padding: 0 20px 0 0">
          <div style="display: flex;padding: 5px 0">
            <div>
              <el-button :icon="isCollapse ? Expand : Fold" text @click="isCollapse = !isCollapse"
                         style="font-size: 25px;margin-top: 6px"/>
            </div>
            <div style="flex: 1;text-align: center">
              <el-input
                  placeholder="搜索论坛内容..."
                  style="width: 400px;margin-top: 7px">
                <template #prefix>
                  <el-icon><Search /></el-icon>
                </template>
              </el-input>
            </div>
            <div style="display: flex;margin-top: 5px;">
              <div style="text-align: right;margin-right: 10px">
                <div style="font-weight: bold">{{store.auth.user?.username}}</div>
                <div style="font-size: 15px">{{store.auth.user?.email}}</div>
              </div>
            <el-dropdown trigger="click">
              <el-avatar class="avatar" :size="45" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"/>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>
                    <el-icon><setting /></el-icon>
                    个人设置
                  </el-dropdown-item>
                  <el-dropdown-item @click="logout" style="color: tomato">
                    <el-icon><Back /></el-icon>
                    退出登录
                  </el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
            </div>
          </div>
        </el-header>
        <el-main style="padding: 0">
          <el-scrollbar style="height: 100% ">
            <router-view />
          </el-scrollbar>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import {logout} from "@/net"
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";
import {Back, Comment, Document, Edit, Expand, Fold, Search, Setting, Star} from "@element-plus/icons-vue";
import {ref} from "vue";

const store = useStore()
const isCollapse = ref(true)


</script>

<style scoped>
.avatar:hover{
  cursor: pointer;
}
</style>