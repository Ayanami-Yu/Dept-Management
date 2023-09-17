# 项目使用指南
## 版本说明
MySQL 8.0.33
Spring Boot 3.1.0
Vue 2.7.14

## 部门管理系统
1. 创建数据库
MySQL在官网选择community downloads中的server，为了使用方便直观可以下载图形用户界面workbench。直接在MySQL Workbench中创建schema（数据库）即可，也可以在命令行输入`CREATE DATABASE myProject`创建，这里myProject是自定义的库名。

1. 修改application.yml
主要修改datasource和port：username改为自己MySQL的用户名（一般为root），password改为自己MySQL的登录密码，url配置`jdbc:mysql://localhost:3306/myProject?useSSL=false&allowPublicKeyRetrieval=true`中将3306和myProject分别改为MySQL运行在的端口号及数据库名称；`port: 8081`改为希望后端运行在的端口号。

1. 修改前端请求地址
可以看到DeptManager.vue DeptUpdate.vue AddDept.vue中的axios请求都以`http://localhost:8081`开头，将该地址与后端运行在的地址对应即可。

1. 启动项目
后端运行MyProjectApplication，随后在终端进入前端项目的文件夹执行`npm run dev`，前端便默认运行在本地8080端口上（注意：如果更改了前端的运行地址，在后端CorsConfig.java中`.allowedOrigins("http://localhost:8080")`所对应的地址应修改为前端运行的地址），接着打开 http://localhost:8080 即可看到项目页面了。