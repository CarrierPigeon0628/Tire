<template>
<nut-comment
imagesRows="multi"
    :images="cmt.images"
    :videos="cmt.videos"
    :info="cmt.info"
    @click="handleclick"
    @clickImages="clickImages"
    :operation="['replay','like','more']"

  >
    <template #comment-labels>
      <img
        class="nut-comment-header__labels--item"
        src="https://img11.360buyimg.com/imagetools/jfs/t1/211858/17/4258/12101/618e6f78Ed0edcadc/e83a673555edf59f.jpg"
      />
    </template>
</nut-comment>

</template>

<script>
import { reactive, ref,onMounted } from 'vue';
export default {
  methods:{
    JumpEvaluate(){
      this.$router.push('/evaluate');
    }
  },
  setup() {
    let cmt = ref({});
    onMounted(()=>{
      fetch('//storage.360buyimg.com/nutui/3x/comment_data.json')
        .then((response) => response.json())
        .then((res) => {
          cmt.value = res.Comment;
        }) 
        .catch((err) => console.log('Oh, error', err)); 
    })
    const handleclick = (info) => {
      console.log('进行跳转', info);
    };
    const clickImages = (imgs)=>{
      console.log('进行图片展示',imgs)
    }
    return {
      cmt,
      handleclick,
      clickImages
    };
  }
}
</script>
<style>
.comments{
    background-color:white;

}
</style>