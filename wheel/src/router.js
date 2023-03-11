import { createRouter, createWebHashHistory } from 'vue-router'

//lazy-load routes
const routes = [
  {
    path: '/',
    redirect: '/show'
  },
  {
    path: '/show',
    component: () => import('./views/ShowView.vue')
  },
  {
    path: '/login',
    component: () => import('./views/Login.vue')
  },

  {
    path: '/register',
    component: () => import('./views/RegisterView.vue')
  },
  {
    path: '/tabbarViews',
    component: () => import('./views/Tabbar.vue'),
    redirect:'/main',
    children: [
      { path: '/main', component: () => import('./views/MainView.vue') },//原有主页
      { path: '/more', component: () => import('./views/FindView.vue') },
      { path: '/me', component: () => import('./views/MeView.vue') },
      { path: '/home',component: () => import('./views/HomeView.vue')}//新飞牌主页
    ],
  },
  {
    path: '/result',
    component: () => import('./views/Result.vue'),
  },
  {
    path: '/liked',
    component: () => import('./views/LikedView.vue'),
  },
  {
    path: '/reviseUser',
    component: () => import('./views/UserRevisionView.vue'),
  },
  {
    path: '/evaluate',
    component: () => import('./views/Evaluate.vue')
  },
  {
    path: '/detail',
    component: () => import('./views/DetailView.vue')
  },
  {
    path: '/commentedit',
    component: () => import('./views/CommentEdit.vue')
  },
]

const router = createRouter({
  mode:'hash',
  history: createWebHashHistory(),
  routes
})

export default router
