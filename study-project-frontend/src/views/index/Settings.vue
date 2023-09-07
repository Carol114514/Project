<template>
  <div style="display: flex;padding: 20px 30px">
    <div style="flex: 1">
      <el-tabs v-model="activeName">
        <el-tab-pane label="个人信息设置" name="info">
          <info-settings/>
        </el-tab-pane>
        <el-tab-pane label="账号安全设置" name="security">
          <security-settings/>
        </el-tab-pane>
        <el-tab-pane label="隐私设置" name="privacy">
          <privacy-settings/>
        </el-tab-pane>

      </el-tabs>
    </div>
    <div style="width: 300px">
      <div class="user-card">
        <div style="text-align: right;padding: 5px 0 0 30px">
          <el-avatar :size="70"
              src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"/>
              <div style="text-align: right;font-weight: bold;padding: 0 20px">{{store.auth.user.username}}</div>
        </div>
        <div>
          这是介绍
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive,ref} from "vue";
import {useStore} from "@/stores";
import InfoSettings from "@/components/settings/InfoSettings.vue";
import SecuritySettings from "@/components/settings/SecuritySettings.vue";
import PrivacySettings from "@/components/settings/PrivacySettings.vue";

const infoForm = reactive({
  username: '',
  desc: '',
  qq: '',
  wx: '',
  blog: '',
  sex: '',
  phone: ''
})
const store = useStore()
const activeName = ref('info')
</script>

<style scoped>

.user-card{
  margin-top: 15px ;
  margin-left: 30px;
  height: 300px;
  width: 260px;
  border-radius: 5px;
  border: solid 1px lightgrey;
}

.user-card > div {
  border-bottom: solid 1px lightgrey;
}
</style>