
## Screenshot - Take Screenshot Programmatically

This library helps you to take screenshot of the complete screen or any specific view. This is a very lite library to be integrated.

### Add Screenshot in your library
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency
```groovy
dependencies {
	        implementation 'com.github.MindorksOpenSource:screenshot:v0.0.1'
	}
```

### Usage of the library,
Type 1 : Basic Implementation. It will take the screenshot of the complete view of the activity and returns a bitmap
```kotlin
Screenshot.with(activityReference).getScreenshot()
```

Type 2 :  You can customise the screenshot by adding the features like,
```kotlin
Screenshot.with(this)  
    .setView(/** the view **/)  
    .setQuality(Quality.HIGH)  
    .setFlip(Flip.HORIZONTALLY)  
    .getScreenshot()
```
You can set the quality by using,
```kotlin
setQuality(/**Quality**/)
```
> Quality can be Quality.LOW, Quality.AVERAGE, Quality.MEDIUM, Quality.HIGH

You can also flip the bitmap by using,
```kotlin
setFlip(/** Flip **/)
```
> Flip can be Flip.VERTICAL, Flip.HORIZONTAL, Flip.NOTHING

and at last, you can also Rotate the bitmap as well by using,
```kotlin
setRotation(/** Rotate **/)
```
> Rotation can be of, Rotate.DEGREE_0, Rotate.DEGREE_90, Rotate.DEGREE_180, Rotate.DEGREE_270
