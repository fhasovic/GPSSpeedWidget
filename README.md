# GPS速度插件
## 功能列表
1. GPS车速显示（桌面插件，悬浮窗口）
2. 行车轨迹记录（可关闭）
3. 智能巡航（电子狗，语音提醒，实时路况，可关闭）
4. 悬浮窗口速度显示（可关闭）

## 使用方法
### 桌面插件
   1. 拖放GPS速度插件到桌面
   2. 在弹出的配置窗口，允许程序权限
   3. 按顺序勾选启动功能
   4. 点ok，
   5. 点桌面插件可以启动关闭程序功能
   
   桌面插件可以开机自动启动
   
 ### 只使用悬浮窗口
 1. 打开GPS速度插件主程序
 2. 点开配置 窗口，允许程序权限
 3. 按顺序勾选启动功能
 4. 关闭悬浮窗口到主程序配置窗口关闭
 悬浮窗口可以选择是否在桌面显示
 
 
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
5. 