<template>
    <div class="topBar">
            <nut-icon style="margin-right:10px" name="rect-left" size="30px" @click="JumpBack"></nut-icon>
            <div style="font-size:25px">商品简介</div>
    </div>
    <div style="padding:10px;height:80%">
    <div class="evaluate">
        <Comments>
        </Comments>
    </div>
    <div class="parameters">
        <Parameters :type=type :origin=origin :width=width :ratio=ratio :size=size :patterntype=patterntype :speed=speed :load=load
        :symmetry=symmetry :guide=guide>
        </Parameters>
    </div>
    <div class="details">
        <b style="margin:15px;font-size:18px">商品详情</b>
        <Introduce>
        </Introduce> 
    </div>
    
    </div>
    
</template>
<script>
import { reactive } from 'vue';
import Parameters from '@/components/Parameters.vue'
import Comments from '@/components/Comments.vue'
import Introduce from '@/components/Introduce.vue'
export default {
    components:{
        Parameters,
        Comments,
        Introduce
    },
    data() {
        return{
            type:'123',
            origin:'456',
            width:'789',
            ratio:'123',
            size:'456',
            patterntype:'789',
            speed:'753',
            load:'951',
            symmetry:'456',
            guide:'852',
        }

    },
    methods:{
        JumpBack(){
            this.$router.back();
        }
    },

}
</script>
<style>
.topBar {
    display:flex;
    background-color:white;
    padding:10px;
    align-items:center;
}
.details{
    width:100%;
    border-radius: 5px;
    padding-top:10px;
    background-color:white;
}
.evaluate{
    width:100%;
    border-radius: 5px;
    margin-bottom:10px;
    background-color:white;
}

.parameters{
    width:100%;
    border-radius: 5px;
    margin-bottom:10px;
    background-color:white;
}
</style>