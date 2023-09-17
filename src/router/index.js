import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/Index.vue'
import DeptManager from '../components/DeptManager.vue'
import AddDept from '../components/AddDept.vue'
import DeptUpdate from '../components/DeptUpdate.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '部门管理',
      component: Index,
      redirect: '/DeptManager',
      children: [
        {
          path: '/DeptManager',
          name: '部门查询',
          component: DeptManager
        },
        {
          path: '/AddDept',
          name: '添加部门',
          component: AddDept
        },
        {
          path: '/update',
          component: DeptUpdate
        }
      ]
    }
  ]
})
