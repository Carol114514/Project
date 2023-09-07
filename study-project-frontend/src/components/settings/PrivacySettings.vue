<template>
  <div>
    <el-form
        label-position="top"
        label-width="100px"
        :model="privacyForm"
        style="max-width: 460px">
      <el-form-item>
        <el-checkbox v-model="privacyForm.email" label="是否公开展示邮箱"/>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="privacyForm.sex" label="是否公开展示性别"/>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="privacyForm.phone" label="是否公开展示电话号码"/>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="privacyForm.qq" label="是否公开展示QQ账号"/>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="privacyForm.wx" label="是否公开展示微信账号"/>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="privacyForm.sex" label="是否公开展示博客"/>
      </el-form-item>
    </el-form>
    <el-button type="success" :icon="Select">
      保存隐私设置
    </el-button>
  </div>
</template>

<script setup>

import {reactive} from "vue";
import {Select} from "@element-plus/icons-vue";

const privacyForm = reactive({
  email: false,
  qq: false,
  wx: false,
  blog: false,
  sex: false,
  phone: false

})
</script>

<style scoped>
::v-deep(.el-form-item){
  margin-bottom: 5px;
}
</style>