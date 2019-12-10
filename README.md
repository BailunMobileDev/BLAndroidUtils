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
	  implementation 'com.github.BailunMobileDev:BLAndroidUtils:v0.0.3'
}
```

### Utils简介


 [![](https://jitpack.io/v/BailunMobileDev/BLAndroidUtils.svg)](https://jitpack.io/#BailunMobileDev/BLAndroidUtils)

|No|工具类名称|简介|
|---|---|---|
|1|BLCollectionUtils|封装集合相关操作|
|2|BLPermissionUtils|权限判断库|
|3|BLSpUtils|SharedPreferences库|
