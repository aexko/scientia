# SQLite  
Week 5
## Serializable VS Parcelable
## Class SQLiteOpenHelper  
https://developer.android.com/training/data-storage/sqlite
- `onCreate()` and `onUpgrade()` are not abstract classes, true or false? False. They are abstract classes, so we have to define them: our constructor will need to call super() and specify our database name and its version  
- What can we call when using this class to read and write in our database? `getReadableDatabase()` and `getWritableDatabase()`  
- If we update our database version, what do we have to remember? To use `onUpgrade()`  
- What could be the reasons of your app crashing? You might have incorrectly specified the name of the database or forgotten to update the database version  

# Implicit intents
Week 7
## Usages
- Photo takings
- Video recordings
- ...
  
### To create an alarm
```
public void createAlarm(String message, int hour, int minutes) {   
    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
            .putExtra(AlarmClock.EXTRA_HOUR, hour)
            .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }
}

// ADD IT TO THE MANIFEST FILE TO GIVE PERMISSION
<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
```
## Uri (Uniform resource identifier)
 "a unique sequence of characters that identifies a logical or physical resource used by web technologies." (Wikipedia)

### Take photos
https://developer.android.com/training/camera-deprecated/photobasics


