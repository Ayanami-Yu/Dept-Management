<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="deptNo"
        label="编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="dname"
        label="部门名称"
        width="150">
      </el-table-column>
      <el-table-column
        prop="loc"
        label="地址"
        width="150">
      </el-table-column>
      <el-table-column
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteDept(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next"
                   :page-size="pageSize"
                   :total="total"
                   @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    page (currentPage) {
      this.$http.get('http://localhost:8081/dept/findAll/' + (currentPage - 1) + '/6').then(resp => {
        console.log(resp)
        this.tableData = resp.data.content
        this.pageSize = resp.data.size
        this.total = resp.data.totalElements
      })
    },
    edit (row) {
      this.$router.push({
        path: '/update',
        query: {
          deptNo: row.deptNo
        }
      })
    },
    deleteDept (row) {
      this.$http.delete('http://localhost:8081/dept/delete/' + row.deptNo).then(resp => {
        this.$alert('删除成功！', '消息', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()
          }
        })
      })
    }
  },
  data () {
    return {
      pageSize: '',
      total: '',
      tableData: []
    }
  },
  created () {
    this.$http.get('http://localhost:8081/dept/findAll/0/6').then(resp => {
      console.log(resp)
      this.tableData = resp.data.content
      this.pageSize = resp.data.size
      this.total = resp.data.totalElements
    })
  }
}
</script>
