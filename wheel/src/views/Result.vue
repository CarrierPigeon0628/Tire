<template>
<div class="topBar">
            <nut-icon style="margin-right:10px" name="rect-left" size="30px" @click="JumpBack"></nut-icon>
            <div style="font-size:25px">拍照分析</div>
    </div>
<nut-form>
    <nut-form-item label="图片上传">
        <nut-uploader url="http://服务地址" accept="image/*" v-model:file-list="formData2.defaultFileList" maximum="3" multiple>
        </nut-uploader>
    </nut-form-item>

</nut-form>
  <div v-if="formData2.unupload">
     <nut-empty description="未上传"></nut-empty>
  </div>
  <div v-if="!formData2.unupload">
  <b>分析结果</b>
  <nut-form>
      <nut-form-item label="轮胎类型">
      <b>{{type}}</b>

    </nut-form-item>
    <nut-form-item label="适用场景">
    <b>{{scene}}</b>

    </nut-form-item>
    <nut-form-item label="功能分析">
    <b>{{function}}</b>

    </nut-form-item>

  </nut-form>

  </div>   

</template>
<script>
import { ref,reactive } from 'vue';
export default {
  data(){
    return {
    type:'',
    scene:'',
    function:''}
  },
  methods:{
    JumpBack(){
      this.$router.back();
    }
  },
setup(){
    const formData2 = reactive({
      unupload:true,
      defaultFileList: [
        {
          name: '文件1.png',
          url: 'https://m.360buyimg.com/babel/jfs/t1/164410/22/25162/93384/616eac6cE6c711350/0cac53c1b82e1b05.gif',
          status: 'success',
          message: '上传成功',
          type: 'image'
        },
        {
          name: '文件2.png',
          url: 'https://m.360buyimg.com/babel/jfs/t1/164410/22/25162/93384/616eac6cE6c711350/0cac53c1b82e1b05.gif',
          status: 'uploading',
          message: '上传中...',
          type: 'image'
        }
      ]
    });

    return { formData2,};
    }
    }
</script>
<style>
.topBar {
    display:flex;
    background-color:white;
    padding:10px;
    align-items:center;
}
</style>