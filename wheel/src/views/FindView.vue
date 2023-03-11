<template>
  <div style="height:100%;width: 100%;">
    <div class="indextopbox">
      <div style="width: 60%;">
        <nut-searchbar v-model="searchValue" input-background="#d7d7d7" :clearable="false"
          :focus-style="{ 'background-color': 'white', 'border': 'solid' }" @keyup.enter="JumpSearch">
          <template v-slot:leftin>
            <nut-icon size="14" name="search2"></nut-icon>
          </template>
        </nut-searchbar>
      </div>
      <div style="color:#3843C4;font-size:40px;margin-left: 10px;margin-right: 20px;">
        <b>发现</b>
      </div>
    </div>
    
    <nut-menu>
      <nut-menu-item v-model="state.value1" :options="state.options1" />
      <nut-menu-item v-model="item.value1" :options="item.options1">
        <div :style="{display: 'flex', flex: 1, 'justify-content': 'space-between', 'align-items': 'center'}">
        </div>
      </nut-menu-item>
      <nut-menu-item v-model="band.value1" :options="band.options1" />
    </nut-menu>

    <ul class="infiniteUl" id="refreshScroll" style='height: 580px;'>
      <nut-infiniteloading pull-icon="JD" container-id="refreshScroll" :use-window="false" :is-open-refresh="true" 
      :has-more="refreshHasMore" @load-more="refreshLoadMore" @refresh="refresh">
        <li class="infiniteLi" v-for="(item, index) in refreshList" :key="index">
        <GoodsCard :imgUrl=item.imgUrl :title=item.title :price=item.price :shopDesc=item.shopDesc :delivery=item.delivery>
        </GoodsCard>
        </li>
      </nut-infiniteloading>
    </ul>
  </div>
</template>

<script>
import { ref,reactive,onMounted, toRefs } from 'vue';
import { Toast } from '@nutui/nutui';
import GoodsCard from '@/components/GoodsCard.vue'

export default {
  components:{
    GoodsCard,

  },
  data(){
    return{
      searchValue:'',
    }
  },
  methods: { 
    JumpSearch() {
      this.$router.push({ path: '/menu', query: { param: this.$data.searchValue, kind: 'name' } });
    },
  },
  setup(props) {
    const refreshHasMore = ref(true);
    const data = reactive({
      refreshList: []
    });
    const test=reactive({imgUrl:'//img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png',
            title: '活蟹】湖塘煙雨 阳澄湖大闸蟹公4.5两 母3.5两 4对8只 鲜活生鲜螃蟹现货水产礼盒海鲜水',
            price: '388',
            shopDesc: '自营',
            delivery: '厂商配送'});
    const refreshLoadMore = done => {
      setTimeout(() => {
        const curLen = data.refreshList.length;
        for (let i = curLen; i < curLen + 30; i++) {
          data.refreshList.push(test);
        }
        if (data.refreshList.length > 30) refreshHasMore.value = false;
        done()
      }, 500);
    };
    const refresh = (done) => {
      setTimeout(()=>{
        Toast.success('刷新成功');
        done()
      },1000)
    }
    const init = () => {
      for (let i = 0; i < 30; i++) {
        data.refreshList.push(test);
      }
    }
    onMounted(() => {
      init()
    });
    const state = reactive({
      options1: [
        { text: '全部商品', value: 0 },
        { text: '新款商品', value: 1 },
        { text: '活动商品', value: 2 }
      ],
      value1: 0
    });
    const item =reactive({
      options1: [
        { text: '综合', value: 0 },
        { text: '销量', value: 1 },
        { text: '评价', value: 2 }
      ],
      value1: 0
    });
    const band =reactive({
      options1: [
        { text: '不限', value: 0 },
        { text: '米其林', value: 1 },
        { text: '固特异', value: 2 },
        { text: '佳通', value: 3 },
        { text: '邓禄普', value: 4 },
        { text: '马牌', value: 5 },
        { text: '普利司通', value: 6 }
      ],
      value1: 0
    });
    return {
      state,
      item,
      band,refreshLoadMore, refreshHasMore, refresh, ...toRefs(data)
    }
  }
}
</script>

<style>
.indextopbox {
  padding: 10px;
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
}
.infiniteUl {
  height: 600px;
  width: 100%;
  padding: 0;
  margin: 0;
  overflow-y: auto;
  overflow-x: hidden;
  background:#eee
}
.infiniteLi {
  margin-top: 10px;
  font-size: 14px;
  color: rgba(100, 100, 100, 1);
  text-align: center;
}
</style>