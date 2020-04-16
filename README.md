![alt text](https://github.com/cheetahmail007/GoPlay/blob/master/art/master_exo_player_banner.svg)

# *** BETA VERSION***

# MasterExoPlayer for Recycler view (build with kotlin)
####  #3 Line code for playing video inside RecyclerView

#### MasterExoPlayer is lightweight utility for helping Play Video inside RecyclerView.

# Features
- ##### Easy to use (Just 3 line of code)
- ##### No Need to create different view holder to support playing video
- ##### Support for playing video inside horizontal recyclerview inside RecyclerView Item like instagram
- ##### Can handle autoplay, mute, logic to play by area(whether video is 75% visible then starts Play)
- ##### Just attach MasterExoPlayerHelper to recyclerview that's enought, player will play most visible video automatically based on your configuration

### Setup
Include the following dependency in your build.gradle files.
```
// Project level build.gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}


```


#### Whats New

- Added method to return playerview from MasterExoPlayerHelper, now we can customize player using getPlayer() on MasterExoPlayerHelper
Example:
masterExoPlayerHelper.getPlayerView().resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM


# How to use

#### Attach to RecyclerView

### 1. Add MasterExoPlayer inside RecyclerView Item
```
<com.master.exoplayer.MasterExoPlayer
    android:id="@+id/masterExoPlayer"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

### 2. Set url of your video view to MasterExoPlayer inside your RecyclerView Adapter onBindViewHolder
```kotlin
binding.frame.url = model.sources
```

### 3. Attach MasterExoPlayerHelper to RecyclerView
```kotlin
val recyclerView: RecyclerView = ....

val masterExoPlayerHelper = MasterExoPlayerHelper(mContext = this, id = R.id.masterExoPlayer)
masterExoPlayerHelper.makeLifeCycleAware(this)
masterExoPlayerHelper.attachToRecyclerView(recyclerView)

//Used to customize attributes
masterExoPlayerHelper.getPlayerView().apply {
    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM   
}
```

# Configuration
#### Constructor parameters for MasterExoPlayerHelper

```
1. id : Int 
   View id of ExoPlayerView used in item layout
```
```
2. autoPlay : Boolean 
    If you want to autoplay video once loaded
```
```
3. playStrategy : Float 
    Visible area from 0 to 1, Which matches to play video, default value = PlayStrategy.DEFAULT i.e 0.75 means 75% area visible to starts play
```
```
4. muteStrategy : Values from MuteStratagy.ALL or MuteStratagy.INDIVIDUAL 
    Defines whether mute/unmute affects all rows or individual
```
```
5. defaultMute : Boolean 
If default video should be muted or not
```
```
6. loop:Int 
    Defines if you want to loop the video, default is unlimited, if set to 1 it will play only 1 time then stoop.
```
```
7. useController : Boolean 
    Defines if you want use controller for exo player or not. if set true then controller will be visible else hide, default will be false.
```
```
8. thumbHideDelay : Long 
    Defines duration in millisecond, defines delay before hiding thumbnail image while video plays.
```

#### Listen for buffering or not
```
//Inside onBindViewHolder of your RecyclerViewAdapter

binding.masterExoPlayer.listener = object : ExoPlayerHelper.Listener {

    //Listen for buffering listener
    override fun onBuffering(isBuffering: Boolean) {
        super.onBuffering(isBuffering)
        Log.i("TAG", isBuffering.toString())
    }

    //Update mute/unmute icon on player ready callback.
    
    override fun onPlayerReady() {
        super.onPlayerReady()
        binding.ivVolume.visibility = View.VISIBLE
        if (binding.frame.isMute) {
            binding.ivVolume.setImageResource(R.drawable.ic_volume_off)
        } else {
            binding.ivVolume.setImageResource(R.drawable.ic_volume_on)
        }
    }

    override fun onStop() {
        super.onStop()
        binding.ivVolume.visibility = View.GONE
    }
}
``` 

### Special Thanks to
###### Exo Player by Google [(<u><i>link</i></u>)](https://github.com/google/ExoPlayer)
###### Coil Image Loading library for Kotlin [(<u><i>link</i></u>)](https://github.com/coil-kt/coil)

### My Other Libraries
###### Runtime Permission Helper [(<u><i>link</i></u>)](https://github.com/google/ExoPlayer)
###### ADB Input (Android Studio Plugin) [(<u><i>link</i></u>)](https://plugins.jetbrains.com/plugin/13758-adb-input/versions)
### License
```
Copyright 2020 Abhishek Pathak
###### Porfolio [(<u><i>link</i></u>)](https://medium.com/@cheetahmail007/abhishek-pathak-senior-android-dev-portfolio-23e5dbde3cda)

