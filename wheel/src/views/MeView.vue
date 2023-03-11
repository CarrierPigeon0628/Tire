<template>
    <div class="container">
        <div style="margin:15px">
            <nut-avatar
                size="large"
                :icon=avatar
                shape="square"
            ></nut-avatar>
        </div>
        <div style="width:180px">
            <div style="margin-bottom: 3px;">昵称： {{userName}}</div>
            <div style="margin-bottom: 3px;">账号： {{userId}}</div>
        </div>
    </div>
    <nut-cell-group title="个人信息">
        <nut-cell title="个人信息管理" @click="JumpInforRevision" size="large" is-link>
            <template v-slot:icon>
                <My2 style="margin-right:10px"/>
            </template>
        </nut-cell>
    </nut-cell-group>
        <nut-cell title="我的收藏" @click="JumpLiked" size="large" is-link>
            <template v-slot:icon>
                <Star style="margin-right:10px"/>
            </template>
        </nut-cell>
        <nut-cell title="我的喜好" :desc=this.written @click="pop" size="large">
            <template v-slot:icon>
                <Order style="margin-right:10px"/>
            </template>
        </nut-cell>
        <nut-popup position="bottom" :style="{ height: '80%' }" v-model:visible="showBottom"></nut-popup>
        <nut-cell title="帮助与反馈" size="large" is-link>
            <template v-slot:icon>
                <Ask style="margin-right:10px"/>
            </template>
        </nut-cell>
        <nut-cell title="版本" desc="v1.0.1" size="large">
            <template v-slot:icon>
                <Tips style="margin-right:10px"/>
            </template>
        </nut-cell>
    <!-- </nut-cell-group> -->
    <div style="text-align:center">
        <nut-button shape="square" type="primary" @clivk="JumpLogin" color="#3843C4">退出登录</nut-button>
    </div>
</template>

<script>
import { reactive, toRefs } from 'vue';
import axios from 'axios';
import { My2,Star,Order,Ask,Setting,Tips } from '@nutui/icons-vue';
import { Notify } from 'vant';
export default {
    components:{
        My2,Star,Order,Ask,Setting,Tips 
    },
    data() {
        return{
            userName:'',
            userId:'',
            userStatus:'',
            avatar:'',
            lightTheme: false,
            written:'未填写'
        }
    },
    setup() {
        const state = reactive({
            showTop: false,
            showBottom: false,
            showLeft: false,
            showRight: false,
        });
        return { ...toRefs(state) };
    },
    methods: {
        pop(){
            if (this.userStatus == 'User') {
                this.showBottom = true;
            }
        },
        JumpInforRevision(){
            this.$router.push('/reviseUser')
        },
        JumpLiked(){
            this.$router.push('/liked')
        },
        JumpLogin(){
            this.$router.push('/login')
        },
    },
    created(){

        axios({
            method: 'get',
            headers: { 'Authorization': 'Bearer ' + localStorage.token },
            url: `http://127.0.0.1:7000/user/${localStorage.userId}/`,
        }).then((res) => {
            console.log(res)
            if (res.data.code==0) {
                Notify.danger('用户不存在！')
            }
            else if (res.data.code==1) {
                console.log('user info:',  res.data)
                this.userId = res.data.user_id;
                this.userName = res.data.user_name;
                this.userStatus = res.data.user_status;
                if (this.userStatus=='User') {
                    this.written = '未填写'
                }else {
                    this.written = '已填写'
                }
            }
        }, error => {
            console.log('错误', error.message)
        })

        // // get preference--------------------------------------------------
        // axios({
        //     method: 'get',
        //     headers: { 'Authorization': 'Bearer ' + localStorage.token },
        //     url: `http://124.220.158.211:7000/users/${localStorage.userId}/preference/`,
        // }).then((res) => {
        //     console.log('user info:',  res.data)
        // }, error => {
        //     console.log('错误', error.message)
        // })
    }
}
</script>
<style>
:root{
    --nut-avatar-large-width:100px;
    --nut-avatar-large-height:100px;
}
.container {
    height:100px;

    background-color: white;
    border-radius: 8px;
    display: flex;
    justify-content: space-around;
    align-items: center;
}
</style>
