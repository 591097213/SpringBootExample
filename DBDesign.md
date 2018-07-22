# 数据表设计

<!-- cacheput

cacheable -->

* image_cdoe

| 属性     | 类型   |
| -------- | ------ |
| id       | Long   |
| uuid     | String |
| code     | String |
| end_time | Long   |
| app_id   | Long   |

* user

| 属性    | 类型   |
| ------- | ------ |
| id      | Long   |
| name    | String |
| sex     | boolen |
| email   | String |
| pho_num | String |
| address | String |
| age     | int    |

* address

| 属性        | 类型   |
| ----------- | ------ |
| id          | Long   |
| addressname | String |

* user_account

| 属性       | 类型 |
| ---------- | ---- |
| user_id    | Long |
| account_id | Long |

* account

| 属性         | 类型   |
| ------------ | ------ |
| id           | Long   |
| account_name | String |
| pwd          | String |

* app

| 属性      | 类型   |
| --------- | ------ |
| id        | Long   |
| appid     | String |
| appsecret | String |
| appname   | String |

* sms_code

| 属性     | 类型   |
| -------- | ------ |
| id       | Long   |
| code     | String |
| end_time | Long   |
| app_id   | Long   |
| pho_num  | String |

* log

