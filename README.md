

# toutiao

目标： 搭建一个模仿头条的站点

## 技术栈

- SpringBoot
- Maven
- Redis
- Velocity

## 项目进度

- [x] SpringBoot初始化
- [x] 用户注册登录模块
- [ ] 发布资讯，上传图片
- [ ] 点赞点踩功能
- [ ] 评论中心，站内信
- [ ] 异步通知
- [ ] 资讯排序算法
- [ ] 结项，部署工程

## 模块

### 1. 用户注册登录

（1）对于用户的密码加盐之后使用MD5加密方式存入数据库

（2）用户登录涉及到邮箱激活的方式

### 2. 新闻页面

1. 对所有用户显示一个共同的页面
2. 对于不同的用户登录之后显示不同的页面

### TODO NEXT：

- [ ] 使用Redis实现用户点赞点踩的功能

 

### 展示

### 1. 首页

![1546780680971](https://github.com/mio4/MyToutiao/blob/master/readme_image/index.png)



































