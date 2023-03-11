<template>
  <div class="framebox">
    <div class="login-box">
      <h1 style="text-align:center;font-size:60px;color:white;">车轮滚滚</h1>
      <nut-tabs v-model="loginChoice">
        <nut-tabpane title="请先登录" style="background-color:transparent;">
          <form>
            <div class="user-box" style="margin-bottom: 30px">
              <input type="text" v-model="userName" name="" required="">
              <label>昵称</label>
            </div>
            <div class="user-box">
              <input type="password" v-model="passwordName" name="" required="">
              <label>密码</label>
            </div>
          </form>
        </nut-tabpane>
        <!-- <nut-tabpane title="按账号" style="background-color:transparent;">
          <form>
            <div class="user-box" style="margin-bottom: 30px">
              <input type="text" v-model="studentId" name="" required="">
              <label>账号</label>
            </div>
            <div class="user-box">
              <input type="password" v-model="passwordId" name="" required="">
              <label>密码</label>
            </div>
          </form>
        </nut-tabpane> -->
      </nut-tabs>
      <nut-row type="flex" justify="end">
        <nut-col :span="12">
          <div class="flex-content" @click="Register">没有账户？立即注册</div>
        </nut-col>
      </nut-row>
      <div style="width:80%;display:block;margin:0 auto">
        <nut-button style="font-size:20px" size="large" type="primary" color="#3843C4" @click="ConfirmLogin">立即登录</nut-button>
      </div>
    </div>
  </div>
</template> 
<script>
import axios from 'axios'
import { Notify } from '@nutui/nutui'
export default {
  data(){
    return{
      studentId:'',
      passwordId:'',
      passwordName:'',
      userName:'',
      loginChoice:'0',
    }
  },
  methods: {
    Register(){
      this.$router.push('/register')
    },
    ConfirmLogin() {
      // this.$router.push('/home')
      // 注册或登录
      if(this.loginChoice=='0' && this.userName != '' && this.passwordName != '')
      {
        // 用username登录
        console.log('0 username 登录')
        axios({
          method: 'post',
          params: {
            filter: 'userName',
          },
          data: {
            userName: this.userName,
            userPassword: this.passwordName,
          },
          headers: {'Content-Type': 'multipart/form-data'},
          url: 'http://127.0.0.1:7000/login/',
        }).then((res) => {
          console.log('result', res)
          if(res.data.code==0){
            Notify.danger("登录失败！")
          }
          else if(res.data.code==1)
          {
            // 登录成功
            // localStorage.setItem("token", res.data.data.token)
            localStorage.setItem("userId", res.data.user_id)
            console.log(localStorage.getItem("userId"))
            Notify.success("登录成功！")
            this.$router.push('/home')
          }

        }, error => {
          console.log('错误', error.message)
        })
      }
      // else if(this.loginChoice == '1' && this.studentId != '' && this.passwordId != '') {
      //   // 用studentid登录
      //   console.log('1 userid 登录')
      //   axios({
      //     method: 'post',
      //     params: {
      //       filter: 'userId'
      //     },
      //     data: {
      //       userId: this.studentId - 0,
      //       userPassword: this.passwordId,
      //     },
      //     headers: { 'Content-Type': 'multipart/form-data' },
      //     url: 'http://127.0.0.1:7000/login',
      //   }).then((res) => {
      //     console.log('result', res.data.code)
      //     if (res.data.code == 0) {
      //       Notify.danger("登录失败！")
      //     }
      //     else if(res.data.code==1)
      //     {
      //       localStorage.setItem("userId", res.data.userId)
      //       Notify.success("登录成功！")
      //       this.$router.push('/home')
      //     }
      //   }, error => {
      //     console.log('错误', error.message)
      //   })
      // }
    }
  },

}
</script>
<style lang="scss" scoped>
.framebox {
  background: linear-gradient(180deg, #3843c4, #4193c1, #2bb3d3);
  width: 100%;
  height: 100%;
  display:flex;
  flex-direction: column;
}
.nut-row {
  overflow: hidden;
  &:not(:last-child) .nut-col {
    margin-bottom: 10px;
  }
  margin-bottom: 10px;
}
.bottom {
  width: 100%;
  height: 20%;
  margin-left: 10%;
  align-self: flex-end;
  padding-bottom: 10%;
}
.flex-content {
  line-height: 20px;
  background-color: transparent;
  text-align: center;
  margin-bottom: 20px;

}
.login-box {
  position: absolute;
  top: 35%;
  left: 50%;
  width: 100%;
  padding-top: 30px;
  padding-left:10PX;
  padding-right:10px;
  transform: translate(-50%, -50%);
  box-sizing: border-box;
}
.login-box .user-box {
  position: relative;
}
.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 20px;
  color: #fff;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
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
::v-deep .nut-tabs__titles{
  background-color: transparent;
}
::v-deep .nut-tabs__titles-item{
  color:#fff;
}
</style>