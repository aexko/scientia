# SQLite  
Week 5
## Serializable VS Parcelable
## Class SQLiteOpenHelper  
https://developer.android.com/training/data-storage/sqlite
- `onCreate()` and `onUpgrade()` are not abstract classes, true or false? False. They are abstract classes, so we have to define them: our constructor will need to call super() and specify our database name and its version  
- What can we call when using this class to read and write in our database? `getReadableDatabase()` and `getWritableDatabase()`  
- If we update our database version, what do we have to remember? To use `onUpgrade()`  
- What could be the reasons of your app crashing? You might have incorrectly specified the name of the database or forgotten to update the database version  
