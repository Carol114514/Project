<template>
  <div>
    <el-form
        ref="form"
        :rules="rules"
        label-position="top"
        label-width="100px"
        :model="infoForm"
        style="max-width: 460px">
      <el-form-item prop="username" label="用户名">
        <el-input :maxlength="8" v-model="infoForm.username" />
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="infoForm.sex" class="ml-4">
          <el-radio label="male" size="large">男</el-radio>
          <el-radio label="female" size="large">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="phone" :maxlength="11" label="手机号">
        <el-input v-model="infoForm.phone" />
      </el-form-item>
      <el-form-item prop="qq" label="QQ账号">
        <el-input :maxlength="12" v-model="infoForm.qq" />
      </el-form-item>
      <el-form-item prop="wx" label="微信账号">
        <el-input :maxlength="20" v-model="infoForm.wx" />
      </el-form-item>
      <el-form-item prop="blog" label="博客">
        <el-input :maxlength="50" v-model="infoForm.blog" />
      </el-form-item>
      <el-form-item prop="desc" label="个人简介">
        <el-input :maxlength="200" type="textarea" v-model="infoForm.desc" :rows="6"/>
      </el-form-item>
    </el-form>
    <el-button type="success" :icon="Select" @click="save">
      保存个人信息设置
    </el-button>
  </div>

</template>

<script setup>
import {reactive, ref} from "vue";
import {Select} from "@element-plus/icons-vue";
import {post} from "@/net";
import {ElMessage} from "element-plus";
import {useStore} from "@/stores";

const store = useStore()
const form = ref()
const save = () => {
  form.value.validate((isValid) => {
    if (isValid){
      post('/api/user/save-info',infoForm, () => {
        ElMessage.success("保存成功")
      },'json')
    } else {
      ElMessage.warning('表单内容有误')
    }
  })

}


const infoForm = reactive({
  username: null,
  desc: '',
  qq: '',
  wx: '',
  blog: '',
  sex: 'male',
  phone: ''
})


const validateUsername = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请输入用户名'))
  } else if(!/^[a-zA-Z0-9\u4e00-\u9fa5]+$/.test(value)){
    callback(new Error('用户名不能包含特殊字符，只能是中文/英文'))
  } else {
    callback()
  }
}

const validatePhoneNumber = (rule, value, callback) => {
  if(value !== '' && !/^1[34578]\d{9}$/.test(value)){
    callback(new Error('手机号格式错误'))
  } else {
    callback()
  }
}

const validateBlogURL = (rule, value, callback) => {
  if(value !== '' && !/^(https?:\/\/)?(www\.)?[\w-]+\.\w+(\/[\w-./?%&=]*)?$/.test(value)){
    callback(new Error('地址格式错误'))
  } else {
    callback()
  }
}

const rules = {
  username: [
    { validator: validateUsername, trigger: ['blur', 'change'] },
    { min: 2, max: 8, message: '用户名的长度必须在2-8个字符之间', trigger: ['blur', 'change'] },
  ],
  phone: [
    { validator: validatePhoneNumber, trigger: ['blur', 'change'] },
    { min: 11, max: 11, message: '请输入正确的手机号', trigger: ['blur', 'change'] },
  ],
  qq: [
    { min: 8, max: 12, message: '请输入QQ账号', trigger: ['blur', 'change'] },
  ],
  wx: [
    { message: '请输入微信账号', trigger: ['blur', 'change'] },
  ],
  blog: [
    { validator: validateBlogURL, max: 50, message: '请输入博客地址', trigger: ['blur', 'change'] },
  ],
  desc: [
    {  message: '请输入简介', trigger: ['blur', 'change'] },
  ]
}


</script>

<style scoped>

</style>