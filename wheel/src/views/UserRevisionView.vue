<template>
    <div class="topBar">
        <nut-icon name="rect-left" style="margin-right:10px" size="25px" @click="JumpBack()"></nut-icon>
        <div style="font-size:25px">个人信息管理</div>
    </div>
    <div class="form">
        <nut-form>
            <nut-form-item label="更换头像">
                <nut-uploader url="uploadUrl"></nut-uploader>
            </nut-form-item>
            <nut-form-item label="新昵称">
                <input class="nut-input-text" v-model="userName" placeholder="请输入新昵称" type="text" />
            </nut-form-item>
            <nut-form-item label="新密码">
                <input class="nut-input-text" v-model="passwordA" placeholder="请输入新密码" type="password" />
            </nut-form-item>
            <nut-form-item label="确认密码">
                <input class="nut-input-text" v-model="passwordB" placeholder="请再次输入密码" type="password" />
            </nut-form-item>
            <nut-form-item label="">
                <div style="display:flex;justify:end">
              <nut-button type="primary" @click="Save()" color="#3843C4">保存</nut-button>
            </div>
            </nut-form-item>
            
        </nut-form>
        

    </div>
</template>

<script>
import { reactive, ref } from 'vue';
import axios from 'axios';
import { Notify } from '@nutui/nutui';
export default {
    mounted() {
    },
    data() {
        return {
            userName: '',
            passwordA: '',
            passwordB: '',
        }
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Save() {
            if (this.passwordA != this.passwordB) {
                Notify.danger('两次输入密码不一致！')
            } else if (this.passwordA != '' && this.userName != '') {
                axios({
                    method: 'put',
                    data: {
                        userName: this.userName,
                        userPassword: this.passwordA
                    },
                    headers: {'Content-Type': 'multipart/form-data'},
                    url: `http://127.0.0.1:7000/reviseUser/${localStorage.userId}/`
                }).then(res => {
                    console.log('result', res)
                    if (res.data.code==0) {
                        Notify.danger('用户不存在！')
                    }
                    else if (res.data.code==-1) {
                        Notify.danger('个人信息无需修改！')
                    }
                    else {
                        Notify.success('个人信息修改成功！')
                        this.$router.back()
                    }
                })
            }
        }
    }
}
</script>

<style>
.topBar {
    display: flex;
    align-items: center;
    background-color: white;
    padding:10px;


}

</style>