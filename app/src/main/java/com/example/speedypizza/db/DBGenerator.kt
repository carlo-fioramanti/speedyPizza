package com.example.speedypizza.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.speedypizza.entity.Constraints
import com.example.speedypizza.entity.Days
import com.example.speedypizza.entity.Exchanges
import com.example.speedypizza.entity.Message
import com.example.speedypizza.entity.Shifts
import com.example.speedypizza.entity.User

@Database(
    entities = [User::class, Constraints::class, Shifts::class, Days::class, Message::class, Exchanges::class],
    version = 10,
    /*autoMigrations = [AutoMigration(3,5, spec = DBGenerator.MigrazioneConstraints::class)],
    exportSchema = true*/
)

abstract class DBGenerator: RoomDatabase() {

    abstract fun speedyPizzaDao(): SpeedyPizzaDAO

    companion object{
        private var db: DBGenerator? = null

        fun getInstance(context: Context): DBGenerator{
            if(db==null){
                db = databaseBuilder(
                    context,
                    DBGenerator::class.java,
                    "speedypizza.db"
                )
                    .fallbackToDestructiveMigration()
                    .createFromAsset("speedypizza.db")
                    //.addAutoMigrationSpec()
                    .build()
            }
            return db as DBGenerator
        }
    }

    /* @RenameColumn(tableName = "Constraints", fromColumnName = "cc", toColumnName = "max")
     @DeleteColumn(tableName = "Constraints", columnName = "cc")
     class MigrazioneConstraints: AutoMigrationSpec{
         @Override
         override fun onPostMigrate(db: SupportSQLiteDatabase) {
             super.onPostMigrate(db)
         }
     }*/


}