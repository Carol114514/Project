<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top: 150px">
      <div style="font-size: 25px;font-weight: bold">登录</div>
      <div style="font-size: 14px;color: grey">在进入系统之前请先输入用户名和密码进行登录</div>
    </div>
    <div style="margin-top: 30px">
      <el-input v-model="form.username" type="text" placeholder="用户名或邮箱登录">
        <template #prefix>
          <el-icon><User /></el-icon>
        </template>
      </el-input>
      <el-input v-model="form.password" type="password" style="margin-top: 10px" placeholder="密码">
        <template #prefix>
          <el-icon><Lock /></el-icon>
        </template>
      </el-input>
    </div>
    <el-row style="margin-top: 5px">
      <el-col :span="12" style="text-align: left">
        <el-checkbox v-model="form.remember" label="记住我" size="large" />
      </el-col>
      <el-col :span="12" @click="router.push('/forget')" style="text-align: right">
        <el-link>忘记密码？</el-link>
      </el-col>
    </el-row>
    <div style="margin-top: 30px">
      <el-button @click="login()" style="width: 270px" type="success">立即登录</el-button>
    </div>
    <el-divider>
      <span style="color:grey;font-size: 12px">没有账号</span>
    </el-divider>
    <div style="margin-top: 30px">
      <el-button @click="router.push('/register')" style="width: 270px" type="warning">注册账号</el-button>
    </div>
  </div>
</template>

<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {reactive} from "vue";
import {ElMessage} from "element-plus";
import {me, post} from "@/net";
import router from "@/router";
import {useStore} from "@/stores";

const form = reactive({
  username:'',
  password:'',
  remember:false
})

const store = useStore()

const login = () => {
  if (!form.username || !form.password){
    ElMessage.warning("请填写用户名密码")
  } else {
    post('/api/auth/login',{
      username: form.username,
      password: form.password,
      remember: form.remember
    },(message) => {
      ElMessage.success(message)
      me(true)
    })
  }
}
</script>

<style scoped>

</style>