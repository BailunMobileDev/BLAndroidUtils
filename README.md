# BLAndroidUtils

致力于提高开发效率，提升稳定性，减少Android适配问题。

### How to

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
	
**Step 2.** Add the dependency
```java
dependencies {
	  implementation 'com.github.BailunMobileDev:BLAndroidUtils:v0.1.6'
}
```


**使用AOP需要添加的配置**

在项目根目录的build.gradle里依赖AspectJX：
```dependencies {
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.8'
    }```


在app项目的build.gradle里应用插件
```apply plugin: 'android-aspectjx' 
```



### Utils简介


 [![](https://jitpack.io/v/BailunMobileDev/BLAndroidUtils.svg)](https://jitpack.io/#BailunMobileDev/BLAndroidUtils)

|No|工具类名称|简介|
|---|---|---|
|1|BLCollectionUtils|封装集合相关操作|
|2|BLPermissionUtils|权限判断库|
|3|BLSpUtils|SharedPreferences库|
|4|BLJsonUtils|解析json的工具类|
|5|BLBase64Utils|Base64加密|
|6|BLDispiayUtils|dp,sp,px转换|
|7|BLMD5Utils|MD5字符串加密|
|8|BLScreenInfoUtils|屏幕信息|
|9|BLFastClickLimit|基于AOP限制快速点击|
|10|BLResUtils|简化资源文件的调用|

### 注意
- v0.1.4版本为android support库版本

- BLFastClickLimit注解既可以使用在成员变量上也可以注解在方法上。建议优先使用注解在变量上，可以根据不同View单独设置时间间隔，但只针对onClick方法与ButterKnife的OnClick注解；
使用在方法上主要为了针对匿名内部类设置点击事件或其他类型的事件(如：onItemClickListener等)

- 依赖2.8.6版本的Gson会与AspectJX库冲突，运行时会报异常，建议使用2.8.5


