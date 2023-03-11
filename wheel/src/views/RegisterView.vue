<template>
  <div class="framebox">
    <div class="login-box">
      <h1 class="title" style="font-size:60px;color:white;margin-bottom: 100px;">注册</h1>
        <div class="user-box">
            <input type="text" v-model="userName" name="" required="">
            <label>昵称</label>
        </div>
        <div class="user-box">
            <input type="password" v-model="passwordId1" name="" required="">
            <label>密码</label>
        </div>
        <div class="user-box" style="margin-bottom: 100px;">
            <input type="password" v-model="passwordId2" name="" required="">
            <label>确认密码</label>
            
        </div>
        <div class="button">
        <nut-button  style="width:30%;margin-right:10px;" size="large" type="primary" color="#3843C4" @click="JumpLogin">取消返回</nut-button>
        <nut-button  style="width:30%;margin-left:10px;" size="large" type="primary" color="#3843C4" @click="Register">立即注册</nut-button>
        </div>
    </div>
    
  </div>
</template>

<script>
import { Notify } from '@nutui/nutui';
import axios from 'axios'
export default {
  data(){
    return{
      userId:'',
      passwordId1:'',
      passwordId2:'',
      userName:'',
    }
  },
  methods: {
    JumpLogin(){
      this.$router.push('/login');
    },
    Register() {
      if(this.userName==''||this.passwordId1==''||this.passwordId2=='')
      {
      }
      else if(this.passwordId1 != this.passwordId2) {
        Notify.danger('两次输入密码不一致！')
      }
      else {
        axios({
          method: 'post',
          data: {
            userName: this.userName,
            userPassword: this.passwordId1,
          },
          headers: { 'Content-Type': 'multipart/form-data' },
          url: 'http://127.0.0.1:7000/register/',
        }).then(res => {
          console.log('result', res)
          if(res.data.code == 0) {
            Notify.danger('用户名已存在！')
          }
          else if(res.data.code == 1) {
            localStorage.setItem("userId", res.data.userId)
            Notify.success('注册成功！')
            this.$router.push('/home')
          }
        })
      }
    },
  },
}
</script>
<style scoped>
.framebox {
  background: linear-gradient(180deg, #3843c4, #4193c1, #2bb3d3);
  width: 100%;
  height: 100%;
  justify-content: center;
  display: flex;
  flex-direction: column;
}
.login-box {
  display:flex;
  flex-direction:column;
  justify-content:flex-start;
  margin-left:10px;
  margin-right:10px;
}
.login-box .button{
  padding:10px;
  text-align:center;
}
.login-box .user-box {
  position:relative;
}

.login-box .user-box input {
  width:90%;
  padding: 10px;
  font-size: 20px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  left:0;
  top:0;
  padding: 10px;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus~label,
.login-box .user-box input:valid~label {
  top: -20px;
  left: 0;
  color: #ffffff;
  font-size: 12px;
}

.title {
  justify-content: center;
  display: flex;
}
</style>