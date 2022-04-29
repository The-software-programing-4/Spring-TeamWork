## API接口文档

### api路径总览

- api/admin/
- api/user/
  - api/user/login
  - api/user/logout
  - api/user/message
- api/book/
- api/movie/
- api/group/
- api/topic/
- api/search/

### api接口详情

|     条目     |                内容                 |
| :----------: | :---------------------------------: |
|    根路径    |        http://127.0.0.1:8080        |
|   api路径    |           api/user/login            |
|   请求方式   |                POST                 |
| 携带数据示例 | {username:"Tom", password:"123456"} |
| 返回数据示例 | {success:true} or {success: false}  |

