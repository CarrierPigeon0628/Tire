<template>
  <div class="framebox">
    <div class="title"><b>车轮滚滚</b></div>
    <nut-image  class="takepic" src="//img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png" 
    width="200" height="200" position="center" @click="JumpResult" round>
    </nut-image>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  data() {
  },
  methods: {
    JumpDetail() {
      this.$router.push('/detail')
    },
    JumpResult(){
      this.$router.push('/result')
    },
  },
  setup() {
    const value = ref(4.8);
    return { value }
  }
}
</script>

<style scoped>
.framebox {
  background: linear-gradient(180deg, #3843c4, #4193c1, #2bb3d3);
  display: flex;
  flex-direction: column;
  justify-content:flex-start;
  align-items:center;
  height: 100%;
}
.title{
  margin:50px;
  color:white;

  font-size:60px;
}
.takepic {
  height: 100%;
  width: 100%;
  background-color:#0000ff;
  margin-top:80px;

}
</style>

