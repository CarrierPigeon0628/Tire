<template>
    <div class="topBar">
        <nut-icon style="margin-right:10px" name="rect-left" size="30px" @click="JumpBack()"></nut-icon>
        <div style="font-size:25px">全部评价</div>
    </div>
    <van-tabs v-model:active="active">
        <van-tab title="全部">
            <ul class="infiniteUl">
          <nut-infinite-loading
              v-model="infinityValue"
              load-txt="Loading..."
              load-more-txt="没有啦~"
              :has-more="hasMore"
              @load-more="loadMore"
            >
              <li class="infiniteLi" v-for="(item, index) in defultList" :key="index">
              <Comment>
        </Comment>
              </li>
            </nut-infinite-loading>
        </ul>
  </van-tab>
  <van-tab title="好评">
  <ul class="infiniteUl">
          <nut-infinite-loading
              v-model="infinityValue"
              load-txt="Loading..."
              load-more-txt="没有啦~"
              :has-more="hasMore"
              @load-more="loadMore"
            >
              <li class="infiniteLi" v-for="(item, index) in defultList" :key="index">
              <Comment>
        </Comment>
              </li>
            </nut-infinite-loading>
        </ul>

  </van-tab>
  <van-tab title="中评">
  <ul class="infiniteUl">
          <nut-infinite-loading
              v-model="infinityValue"
              load-txt="Loading..."
              load-more-txt="没有啦~"
              :has-more="hasMore"
              @load-more="loadMore"
            >
              <li class="infiniteLi" v-for="(item, index) in defultList" :key="index">
              <Comment>
        </Comment>
              </li>
            </nut-infinite-loading>
        </ul>

  </van-tab>
  <van-tab title="差评">
  <ul class="infiniteUl">
          <nut-infinite-loading
              v-model="infinityValue"
              load-txt="Loading..."
              load-more-txt="没有啦~"
              :has-more="hasMore"
              @load-more="loadMore"
            >
              <li class="infiniteLi" v-for="(item, index) in defultList" :key="index">
              <Comment>
        </Comment>
              </li>
            </nut-infinite-loading>
        </ul>
  </van-tab>
  
</van-tabs>


</template>
<script>
import { reactive,ref} from 'vue';
import Comment from '@/components/Comment.vue'
export default {
    components:{
        Comment,

    },
    methods:{
        JumpBack(){
            this.$router.back();
        }
    },
    setup(props) {
        const active = ref(0);
        let cycle = 0;
      const tabsValue = ref(0)
      const infinityValue = ref(false)
      const hasMore = ref(true);
      const letter = ['A','B','C','D','E','F','G', 'H','IJ','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
      const defultList = ref(letter);
      const loadMore = done => {  
        setTimeout(() => {

          defultList.value = defultList.value.concat(letter);
          cycle++;
          if (cycle > 2) hasMore.value = false;
          infinityValue.value = false;
        }, 1000); 
      };
      
      return { active,tabsValue, loadMore, hasMore, defultList, infinityValue };
    }
    
};
</script>
<style>
.topBar {
    display:flex;
    background-color:white;
    padding:10px;
    align-items:center;
}
.nut-tab-pane {
    padding: 0 !important;
    padding-left: 16px !important;
  }
.infiniteUl {
    width: 100%;
    height: calc(100vh - 120px);
}
.infiniteLi {
    font-size: 14px;
    color: #333;
    background-color:white;
    border-radius: 8px;
}
</style>
