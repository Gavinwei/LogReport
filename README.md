# 日志保存与上报系统

## 初始化
1. 支持设置日志保存的路径，不设置会使用默认的路径
2. 支持日志信息加密，包括AES加密，DES加密方式，自定义加密方式等，默认不加密
3. 支持设置上传的方式，目前支持HTTP上传和邮件发送
4. 设置缓存文件夹的大小，当文件超过对应大小的时候，会清空内容。

## 日志的保存方式
1. 逐个保存崩溃日志。此种保存方式非常适合用于GitHub的个人开源项目，崩溃发生后，会通过发送邮件形式在GitHub的开源项目上自动提交一个issue，然后可以通过GitHub的issue系统来追踪管理Bug
2. 按天保存崩溃日志，当天发生的崩溃都保存在一个文件中，此种方式适合拥有自己服务器的企业级App。
3. 你还可以通过LogWriter，在打Log的同时，把Log写入到文件中，上传的时候，会一并把Log作为附件上传，更好的帮助开发者还原用户的操作路径

## 日志的上传方式
崩溃发生后，会在下一次App启动的时候上传崩溃信息。你可以选择你想要的时机启动发送的Service，当发送成功后，Service会自动退出。  
1. 邮件发送
指定收件人邮件，发件人邮箱和密码，还有发送的SMTP地址，即可完成邮件的发送。请不要使用QQ邮箱作为发件人的邮箱，因为QQ邮箱还有一重独立密码需要验证，普通的SMTP发送模式对于QQ有限是失败的。另外，刚注册不久的邮箱，比如说163邮箱，也不会给SMTP发送模式这种权限，也。一定要使用你经常用的邮箱，而且时间比较长的
2. Http请求




