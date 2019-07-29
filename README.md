
## Screenshot - Take Screenshot Programmatically

This library helps you to take screenshot of the complete screen or any specific view. This is a very lite library to be integrated.

[![Mindorks](https://img.shields.io/badge/mindorks-opensource-blue.svg)](https://mindorks.com/open-source-projects)
[![Mindorks Community](https://img.shields.io/badge/join-community-blue.svg)](https://mindorks.com/join-community)

<p align="center">
<img alt="screenshot" src="https://raw.githubusercontent.com/MindorksOpenSource/screenshot/master/images/screenshot-banner.png">
</p>

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

### Found this project useful :heart:
* Support by clicking the :star: button on the upper right of this page. :v:


### Created & Maintained By
[Himanshu Singh](https://github.com/hi-manshu)

License
=======

    Copyright 2019 MindorksOpenSource

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.