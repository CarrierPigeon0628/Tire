<template>
  <div class="framebox">
    <nut-navbar style="height:80px;line-height: 20px;margin-bottom: 0%;padding-left: 0%;">
      <template #content>
        <div style="color:#3843C4;font-size:40px"><b>车轮滚滚</b></div>
      </template>
    </nut-navbar>
    <nut-image class="takepic" src="//img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png" 
    width="100" height="100" fit="cover" position="center" round>
    </nut-image>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  data() {
    
  },
  methods: {
    
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
  height: 100%;
}

.takepic {
  align-self: center;
  height: 100%;
  width: 100%;
  display: flex;
  justify: center;
  background-color:#0000ff;
  align-items: flex-center;
  margin-left:60px;
  margin-right:60px;
  margin-top:200px;
  margin-bottom:50px;
}

</style>