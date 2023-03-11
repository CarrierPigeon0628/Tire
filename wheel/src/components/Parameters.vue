<template>
    <div>
        <nut-form>
            <nut-form-item label="参数">
            </nut-form-item>
            <nut-form-item label="车辆类型">
                <b>{{type}}</b>
            </nut-form-item>
            <nut-form-item label="国产/进口">
                <b>{{origin}}</b>
            </nut-form-item>
            <nut-form-item label="胎面宽度">
                <b>{{width}}</b>
            </nut-form-item>
            <nut-form-item label="扁平比">
                <b>{{ratio}}</b>
            </nut-form-item>
            <nut-form-item label="尺寸">
                <b>{{size}}</b>
            </nut-form-item>
            <nut-form-item label="花纹类型">
                <b>{{patterntype}}</b>
            </nut-form-item>
            <nut-form-item label="速度级别">
                <b>{{speed}}</b>
            </nut-form-item>
            <nut-form-item label="载重指数">
                <b>{{load}}</b>
            </nut-form-item>
            <nut-form-item label="花纹对称性">
                <b>{{symmetry}}</b>
            </nut-form-item>
            <nut-form-item label="花纹导向">
                <b>{{guide}}</b>
            </nut-form-item>
        </nut-form>
    </div>
</template>

<script>
import { ref,reactive } from 'vue';
export default {
  props:{
    type:String,
    origin:String,
    width:String,
    ratio:String,
    size:String,
    patterntype:String,
    speed:String,
    load:String,
    symmetry:String,
    guide:String,
  }
}
</script>

<style>
</style>