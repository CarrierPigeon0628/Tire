<template>
  <div @click="JumpDetail">
    <nut-card :img-url="imgUrl" :title="title" :price="price" :shopDesc="shopDesc" :delivery="delivery">
    </nut-card>
  </div>  
</template>
<script>
  import { reactive } from 'vue';
  export default{
    props:{
      imgUrl:String,
      title:String,
      price:String,
      shopDesc:String,
      delivery:String,
    },
    methods:{
      JumpDetail(){
        this.$router.push('/detail');
      },
    }
  }
</script>
<style lang="scss">
  .search_prolist_attr {
  margin: 3px 0 1px;
  height: 15px;
  overflow: hidden;
  > span {
    float: left;
    padding: 0 5px;
    border-radius: 1px;
    font-size: 10px;
    height: 15px;
    line-height: 15px;
    color: #999;
    background-color: #f2f2f7;
    margin-right: 5px;
  }
}
</style>

