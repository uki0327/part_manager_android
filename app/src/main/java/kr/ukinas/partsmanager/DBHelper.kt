package kr.ukinas.partsmanager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "parts.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS parts ('id' PRIMARY KEY,'name' TEXT NOT NULL,'storage1_code' TEXT,'storage1_box' INTEGER, 'storage1_slot' INTEGER, 'storage2_code' TEXT, 'storage2_box' INTEGER,'storage2_slot' INTEGER,'type' TEXT, 'category' TEXT, 'description' TEXT, 'datasheet' TEXT)")
        db?.execSQL("insert into parts (name, storage1_code,storage1_box,storage1_slot,category,description,datasheet) values ('sample part','A',1,1,'Logic Gate','This is sample description','sample.pdf')")
        db?.execSQL("insert into parts (name, storage1_code,storage1_box,storage1_slot,category,description,datasheet) values ('sample part2','A',1,2,'Logic Gate2','This is sample description2','sample2.pdf')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}