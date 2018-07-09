package com.erkprog.zensofthrcrm.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.erkprog.zensofthrcrm.data.entity.Department;

public class SQLiteHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "HR_CRM";
  private static final int DB_VERSION = 1;

  private static final String INTERVIEWS = "INTERVIEWS";
  private static final String CRITERIAS = "CRITERIAS";
  private static final String CRITERIA = "CRITERIA";
  private static final String VACANCIES = "VACANCIES";
  private static final String REQUESTS = "REQUESTS";
  private static final String DEPARTMENT = "DEPARTMENT";
  private static final String REQUIREMENTS = "REQUIREMENTS";


  private static final String ID = "_id";
  private static final String TEMPLATES = "TEMPLATES";
  private static final String POSITION = "DATE";
  private static final String NAME = "NAME";
  private static final String URL = "URL";
  private static final String FIRST_NAME = "FIRST_NAME";
  private static final String LAST_NAME = "LAST_NAME";
  private static final String STATUS = "STATUS";
  private static final String COMMENT = "COMMENT";
  private static final String RATE = "RATE";
  private static final String EXPERIENCE = "EXPERIENCE";
  private static final String LEVEL = "LEVEL";
  private static final String PHONE = "PHONE";
  private static final String CREATED = "CREATED";
  private static final String EMAIL = "EMAIL";
  private static final String LAST_PUBLISHED = "LAST_PUBLISHED";
  private static final String SUBJECT = "SUBJECT";
  private static final String TYPE = "TYPE";
  private static final String CONTENT = "CONTENT";
  private static final String COUNT = "COUNT";
  private static final String DEPARTMENTS = "DEPARTMENTS";
  private static final String POSITIONS = "POSITIONS";
  private static final String CANDIDATE = "CANDIDATE";
  private static final String DATE = "DATE";
  private static final String INTERVIEWERS = "INTERVIEWERS";
  private static final String CANDIDATES = "CANDIDATES";
  private static final String EVALUATIONS = "EVALUATIONS";
  private static final String CVS = "CVS";
  private static final String USERS = "USERS";
  private static final String USER = "USER";


  private static final String CREATE_TABLE_REQUESTS = "CREATE TABLE IF NOT EXISTS " +
      REQUESTS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      POSITION + ID + " TEXT, " +
      REQUIREMENTS + ID + " TEXT, " +
      COUNT + " INTEGER, " +
      STATUS + " STATUS, " +
      CREATED + " TEXT);";

  private static final String CREATE_TABLE_POSITIONS = "CREATE TABLE IF NOT EXISTS " +
      POSITIONS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      DEPARTMENT + ID + " TEXT, " +
      NAME + " TEXT);";


  private static final String CREATE_TABLE_DEPARTMENTS = "CREATE TABLE IF NOT EXISTS " +
      DEPARTMENTS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      NAME + " TEXT);";

  private static final String CREATE_TABLE_REQUIREMENTS = "CREATE TABLE IF NOT EXISTS " +
      REQUIREMENTS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      DEPARTMENT + ID + " TEXT, " +
      NAME + " TEXT);";

  private static final String CREATE_TABLE_CVC = "CREATE TABLE IF NOT EXISTS " +
      CVS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      URL + " TEXT, " +
      CREATED + " TEXT);";


  private static final String CREATE_TABLE_INTERVIEWS = "CREATE TABLE IF NOT EXISTS " +
      INTERVIEWS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      DATE + " TEXT, " +
      INTERVIEWERS + ID + " TEXT, " +
      CANDIDATE + ID + " TEXT, " +
      STATUS + " TEXT);";


  private static final String CREATE_TABLE_INTERVIEWERS = "CREATE TABLE IF NOT EXISTS " +
      INTERVIEWERS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      USER + ID + " TEXT, " +
      COMMENT + " TEXT, " +
      EVALUATIONS + ID + " TEXT, " +
      CANDIDATE + ID + " TEXT);";

  private static final String CREATE_TABLE_EVALUATIONS = "CREATE TABLE IF NOT EXISTS " +
      EVALUATIONS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      RATE + " INTEGER, " +
      COMMENT + " TEXT, " +
      CRITERIA + ID + " TEXT);";


  private static final String CREATE_TABLE_CANDIDATES = "CREATE TABLE IF NOT EXISTS " +
      CANDIDATES + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      FIRST_NAME + " TEXT, " +
      LAST_NAME + " TEXT, " +
      EMAIL + " TEXT, " +
      LEVEL + " TEXT, " +
      PHONE + " TEXT, " +
      CVS + ID + " TEXT, " +
      EXPERIENCE + " TEXT, " +
      INTERVIEWERS + ID + " TEXT, " +
      CANDIDATE + ID + " TEXT, " +
      INTERVIEWS + ID + " TEXT, " +
      STATUS + " TEXT);";

  private static final String CREATE_TABLE_VACANCIES = "CREATE TABLE IF NOT EXISTS " +
      VACANCIES + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      CREATED + " TEXT, " +
      LAST_PUBLISHED + " TEXT, " +
      NAME + " TEXT);";

  private static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " +
      USERS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      FIRST_NAME + " TEXT, " +
      LAST_NAME + " TEXT, " +
      DEPARTMENT + ID + " TEXT, " +
      CREATED + " TEXT);";


  private static final String CREATE_TABLE_CRITERIAS = "CREATE TABLE IF NOT EXISTS " +
      CRITERIAS + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      NAME + " TEXT, " +
      DEPARTMENT + ID + " TEXT)";


  private static final String CREATE_TABLE_TEMPLATES = "CREATE TABLE IF NOT EXISTS " +
      TEMPLATES + "(" +
      ID + " INTEGER_PRIMARY_KEY, " +
      SUBJECT + " TEXT, " +
      TYPE + " TEXT, " +
      CONTENT + " TEXT, " +
      CREATED + " TEXT)";


  public SQLiteHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }


  @Override
  public void onCreate(SQLiteDatabase db) {

    db.execSQL(CREATE_TABLE_CANDIDATES);
    db.execSQL(CREATE_TABLE_CRITERIAS);
    db.execSQL(CREATE_TABLE_DEPARTMENTS);
    db.execSQL(CREATE_TABLE_EVALUATIONS);
    db.execSQL(CREATE_TABLE_INTERVIEWERS);
    db.execSQL(CREATE_TABLE_INTERVIEWS);
    db.execSQL(CREATE_TABLE_POSITIONS);
    db.execSQL(CREATE_TABLE_REQUESTS);
    db.execSQL(CREATE_TABLE_REQUIREMENTS);
    db.execSQL(CREATE_TABLE_VACANCIES);
    db.execSQL(CREATE_TABLE_USERS);
    db.execSQL(CREATE_TABLE_TEMPLATES);
    db.execSQL(CREATE_TABLE_CVC);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL("DROP TABLE IF EXISTS " + CANDIDATES);
    db.execSQL("DROP TABLE IF EXISTS " + CRITERIAS);
    db.execSQL("DROP TABLE IF EXISTS " + DEPARTMENTS);
    db.execSQL("DROP TABLE IF EXISTS " + EVALUATIONS);
    db.execSQL("DROP TABLE IF EXISTS " + INTERVIEWERS);
    db.execSQL("DROP TABLE IF EXISTS " + INTERVIEWS);
    db.execSQL("DROP TABLE IF EXISTS " + POSITIONS);
    db.execSQL("DROP TABLE IF EXISTS " + REQUESTS);
    db.execSQL("DROP TABLE IF EXISTS " + REQUIREMENTS);
    db.execSQL("DROP TABLE IF EXISTS " + VACANCIES);
    db.execSQL("DROP TABLE IF EXISTS " + USERS);
    db.execSQL("DROP TABLE IF EXISTS " + TEMPLATES);
    db.execSQL("DROP TABLE IF EXISTS " + CVS);
    onCreate(db);

  }
}
