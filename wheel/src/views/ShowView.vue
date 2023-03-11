<template>
    <div class="flexbox">
        <div class="top">
            <h1 style="font-size:60px;color:white;">车轮滚滚</h1>
        </div>
        <div class="bottom">
            <nut-button color="#3843C4" size="large" type="primary" @click="JumpLogin">立即进入</nut-button>
        </div>
    </div>
</template>

<script>
export default {
    data() {

    },
    methods: {
        JumpLogin(){
            this.$router.push('/login');
        },
    }
}
</script>

<style scoped>
.flexbox {
    background: linear-gradient(180deg, #3843c4, #4193c1, #2bb3d3);
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
}
.top {
    width: 100%;
    height: 40%;
    display: flex;
    justify-content: center;
    align-self: flex-start;
    padding-top: 30%;
}
.bottom {
    width: 80%;
    height: 20%;
    margin-left: 10%;
    align-self: flex-end;
    padding-bottom: 10%;
}
</style>
