import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/orders',
      component: () => import('../components/ui/OrderGrid.vue'),
    },
    {
      path: '/inventories',
      component: () => import('../components/ui/InventoryGrid.vue'),
    },
    {
      path: '/checkStocks',
      component: () => import('../components/CheckStockView.vue'),
    },
  ],
})

export default router;
