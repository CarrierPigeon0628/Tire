<template>
    <ul class="infiniteUl">
        <nut-infinite-loading
            v-model="infinityValue"
            load-txt="Loading..."
            load-more-txt="没有啦~"
            :has-more="hasMore"
            @load-more="loadMore">
            <li class="infiniteLi" v-for="(item, index) in defultList" :key="index">{{ item }}</li>
        </nut-infinite-loading>
    </ul>
</template>

<script>
  import { ref } from 'vue';
  export default {
    setup(props) {
      let cycle = 0; 
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
      
      return { loadMore, hasMore, defultList, infinityValue };
    }
  }
</script>

<style>

.infiniteUl {
    width: 100%;
    height: calc(100vh - 120px);
    padding: 0;
    margin: 0;
    overflow-y: auto;
    overflow-x: hidden;
}
.infiniteLi {
    font-size: 14px;
    color: #333;
    padding: 12px;
    text-align:center;
    border-bottom: 1px solid #eee;
}
</style>


