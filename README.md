# GPS速度插件
## 功能列表
1. GPS车速显示（桌面插件，悬浮窗口）
2. 行车轨迹记录，回放，备份（可关闭）
3. 智能巡航（电子狗，语音提醒，实时路况，可关闭）
4. 悬浮窗口速度显示（可关闭）
5. 辅助开机启动其它程序
6. 导航信息悬浮窗口,当高德车机在导航状态下进入后台时，自动弹出导航信息悬浮窗口

## 使用方法
### 桌面插件
   1. 打开桌面小程序窗口，拖放GPS速度插件到桌面
   2. 弹出的配置窗口，允许程序权限
   3. 按顺序勾选启动功能
   4. 点ok，
   5. 点桌面插件可以启动关闭程序功能
   
   桌面插件可以开机自动启动
   
 ### 只使用悬浮窗口
 1. 打开GPS速度插件主程序，允许程序权限
 2. 点开配置打开配置窗口
 3. 按顺序勾选启动功能，开启顶层显示和程序交互功能
 4. 关闭悬浮窗口需要到主程序配置窗口关闭
 
### 开启导航信息悬浮窗口
1. 打开 
 
 ## GPS轨迹记录后台服务
 
 ###程序： 
后台源码文件位置：
/sdcard/GPS/GPSHistory.js

部署方法：
1. 在服务器安装 nodejs，项目依赖项
2. 使用nodejs 启动服务
3. 服务器开放8090端口
4. 在主窗口的配置窗口设置 后台服务器地址

### 后台服务启动方法
```$bash
npm install express querystring node-cache sqlite3 moment -y
npm install pm2 -y -g 
pm2 start GPSHistory.js 
pm2 startup systemd
pm2 save
```
## 行车记录FTP备份方法：
1. 在主界面打开行车记录备份窗口
2. 输入FTP服务信息
3. 点 保存并备份 
4. 在手机上可以下载备份记录 查询历史行车轨迹
5. 如果需要开机自动上传备份 可以勾选自动备份历史数据

## 改动记录
### 20180313
1. 增加配置后台服务器地址
2. 增加在桌面也显示悬浮窗口选项
3. 在apk上传后台服务器程序
4. 桌面插件超速时数字变红色
5. 语音改为3G，4G，wifi使用在线，其它使用离线
6. 配置窗口bug修复 @%飞翔%
7. 改桌面插件界面 只显示kmh 

### 20180314 1.2
1. 增加新的桌面插件 数字显示
2. 新增悬浮窗口设置项
3. 完善仪表插件效果
4. 修改后台服务，在主窗口可以输入机器ID查询其它设备的行车轨迹
5. 优化轨迹显示逻辑
6. 没有启动数据上传功能时，轨迹数据从本机数据库提取   

### 20180315 1.3
1. 增加速度调整设置
2. 悬浮窗口支持自由移动,记忆窗口位置
3. 悬浮窗口可以选择否显限速或速度窗口
4. 超速单独语音提醒：超速每分钟提醒一次
5. 修复语音重复的bug
6. 语音支持压低音乐功能
7. 数字表插件美化
8. 修复两个插件开机启动异常

### 20180316 1.4
1. 适配导航压低音乐功能
2. 增加语音音量设置
3. 完善数字表插件
4. 悬浮窗口增加功能说明

###20180318 1.5
1. 调整语音音量控制，0122版本压低音乐不成功，原因定制ROM声音通道不能独立控制，语音音量设成0，正常工作模式
2. 取消悬浮窗口说明文件，数字不醒目
3. 修改配置窗口布局
4. 修改插件开关显示逻辑
5. 有电子狗提示声时取消限速
6. 提示当前道路名称（待测）（测试无数据）
7. 点桌面插件关闭时同时取消gps记录上传线程
8. 增加在无网络情况下禁止智能巡航启动，网络连通后再开启，解决长时间无网络桌面假死问题
9. 无gps信号30秒速度回0
10. 适配版本改回android6.0

### 20180319 
1. 悬浮窗口支持横排显示
2. 减小悬浮窗口圆环的厚度
3. 增加开机启动其它程序的功能，部署桌面插件时有效
4. 开启桌面插件，关闭速度表时同时关闭悬浮窗功能，不开启桌面插件时 对悬浮窗功能不影响 

### 20180321 1.6.1
1. 增加语音音乐混合开关，并在启动语音服务时自动检测是否可以使用压低音乐的功能
2. 完善开机启动程序功能，支持在不启用桌面插件时也可以启动其它程序
3. 修复bug：操作其它桌面插件时导致插件不更新数据问题
4. 优化界面
5. 在不能启用2程序交互功能的机器上，选择悬浮窗 一直开着的模式，支持开机自动打开悬浮窗
6. 桌面插件开关同时控制悬浮窗口

### 20180325 1.6.3
1. 修复bug；轨迹记录后台服务器地址不能保存
2. 优化桌面插件刷新逻辑
3. 恢复语音音量设置功能
4. 优化语音压低功能，不勾选语音混合，自动检测是否支持语音压低功能

### 20180329 1.6.5
1. 轨迹查询ID增加记忆功能
2. 增加摄像头距离显示
3. 增加行车方向显示
4. 仪表增加限速红圈显示，在有限速信息时
5. 解决桌面插件内存溢出Bug 

### 20180410 1.6.8
1. 增加FTP备份行车轨迹数据功能
2. 优化行车轨迹显示
3. 增加行车里程显示
4. 监控高德地图状态，接收高德地图广播信息
5. 修改后台程序优化查询数据逻辑
6. 优化限速信息清除算法

### 20180412 1.6.9
1. 增加当前道路名称提示(需安装高德车机版)
2. 增加高德导航进入后台时导航提示悬浮窗口
3. 优化路况信息提示
4. 轨迹数据后台查询算法优化
5. 完善本地数据轨迹查询显示

### 20180420 
1. 增加轨迹数据下载，用于手机查询车机轨迹
2. 删除暂时不用的平台包，只保留v7a平台
3. 支持摄像头类型显示

### 20180424 1.7.0
1. 增加自动更新功能
2. 增加问题反馈功能
3. 完善道路设施提示
4. 稳定性增强和问题修复

### 20180426 1.7.1
1. 根据车机美化桌面插件大小
2. 支持开机后台记录行车轨迹
3. 配置窗口增加滚动条适配低分辨率车机
4. 更换程序图标 

### 20180427 1.7.2
1. 增加高德样式悬浮窗
2. 优化界面
3. 高德样式增加限速提示
4. 修复行车轨迹批量上传异常
5. 增加异常保护
6. 增加仪表样式悬浮窗
7. 支持开机延时启动第三方应用
8. 增加固定悬浮窗口功能
9. 异常日志上传功能
10. 导航悬浮窗半透明化
11. 显示问题调整

### 20180505 1.7.3
1. 解决不能使用桌面插件时自启问题
2. 使用固定字体，防止窗口内容随系统字体调整变化
3. 长按悬浮窗口2秒以上取消位置固定功能
4.  增加只在导航时显示悬浮窗口选项
5. 不支持程序交互功能时默认选择一直显示
6， 修复不选择语音音乐混合时 设置音量无效的问题
7. 后台导航悬浮窗增加GPS当前速度显示

### 打赏列表
|打赏好友|方式|金额 |
|:---:|:---:|:---:|
|QQ: any|微信|10元|
|QQ: 都市外乡人|微信|8.88元|




## 捐赠
如果感觉此软件好用 能在行车过程帮到你，使行车安全，欢迎捐助本软件更好的维护开发，多少随意

![QR](https://github.com/laihui0207/GPSSpeedWidget/blob/master/app/src/main/res/drawable/qrcode_wechat.png "微信")
![QR](https://github.com/laihui0207/GPSSpeedWidget/blob/master/app/src/main/res/drawable/qrcode_alipay.jpg "支付宝")

