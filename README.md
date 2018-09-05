# smart-dialog
### Smart, customized and easy to be implemented dialog for Android.

* Implement your preferred dialog anywhere you want with few lines of code.
* Consists of: image, title, message, dismiss button, and action button.
* Only title is required.
* Custom as you want: colors, text size, dialog action, dialog background, buttons background.


![alt text](https://i.imgur.com/OHT9Ds6.gif)
![alt text](https://i.imgur.com/bXvJzaf.gif)
![alt text](https://i.imgur.com/rZSktNp.gif)
![alt text](https://i.imgur.com/1x4DIJ8.gif)



## Installation: Gradle

```
implementation 'com.github.MohamedGamalFci:smart-dialog:1.1'
```


## Usage

### Basic

``` java
new SmartDialog(this)
                .setDialogTitle("Smart Dialog")
                .setMessage("Smart Dialog Sample")
                .setDismissBtnText("Ok")
                .disableActionBtn()
                .showDialog();
```

### Custom

``` java
new SmartDialog(this)
                .setDialogTitle("Smart Dialog")
                .setMessage("Smart Dialog Sample")
                .setMessageTextSize(20)
                .setMessageTextColorResId(getResources().getColor(libs.mohamedgamal.smartdialog.R.color.black))
                .setDismissBtnText("dismiss")
                .setActionBtnText("Ok")
                .setActionBtnClickAction(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        // implement your action here
                        return null;
                    }
                })
                .setCanceledOnTouchOutsideDialog(false) // cancel dismissing dialog when touch out side
                .setDialogImageDrawable(getResources().getDrawable(R.drawable.android)) // set dialog image here
                .setDialogImageDimensions(100, 100) // custom image size
                .setDialogImageScaleType(ImageView.ScaleType.FIT_CENTER) // custom image scale type
                .showDialog();
```

## More features


* Use one of below functions to use a ready made animation (first direction refers to the entry direction, and the second refers to the exit one).

``` java
applyUpUpAnimation()
applyUpDownAnimation() 
applyDownDownAnimation()
applyDownUpAnimation()
applyLeftLeftAnimation()
applyLeftRightAnimation()
applyRightRightAnimation()
applyRightLeftAnimation()
```

or use the below function to use your custom animation

``` java
setAnimationStyle(R.style.customAnimation)
```

styles.xml

``` xml
<style name="customAnimation">
    <item name="android:windowEnterAnimation">@anim/slide_in_up</item>
    <item name="android:windowExitAnimation">@anim/slide_out_up</item>
</style>
```

* Use one of below functions to choose your Dialog position

``` java
bottom()
top()
center()
```

* Change Dialog background color or background drawable

``` java
setDialogBackgroundColorResId(getResources().getColor(R.color.light_gray))
setDialogBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_background))
```

* Custom background color for dismiss / action buttons

``` java
setDismissBtnBackgroundColorResId(getResources().getColor(R.color.green))
setActionBtnBackgroundColorResId(getResources().getColor(R.color.green))
```
