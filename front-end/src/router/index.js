import {createRouter, createWebHashHistory } from 'vue-router'

const routes = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      name: 'defaultLayout',
      component: () => import('@/router/layouts/DefaultLayout'),
      children: [
        {
          path: '/',
          name: 'home',
          component: ()=> import('@/router/views/TheHome'),
        }
      ]
    },
    {
      path: '/',
      name: 'emptyLayout',
      component: () => import('@/router/layouts/EmptyLayout'),
      children: [
        {
          path: '/login',
          name: 'login',
          component: ()=> import('@/router/views/TheLogin'),
        }
      ]
    }
  ]
});

export default routes;