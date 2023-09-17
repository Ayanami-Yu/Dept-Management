<template>
  <div>
    <table>
      <tr>
        <td>编号</td>
        <td>部门名称</td>
        <td>地址</td>
      </tr>
        <!-- 遍历数据 -->
      <tr v-for = "item in depts" :key = "item">
        <td>{{ item.deptNo }}</td>
        <td>{{ item.dname }}</td>
        <td>{{ item.loc }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'Dept',
  data () {
    return {
      depts: []
    }
  },
  created () {
    this.$http.get('http://localhost:8081/dept').then(resp => {
      this.depts = resp.data
    })
  }
}
</script>

<style scoped>

</style>
