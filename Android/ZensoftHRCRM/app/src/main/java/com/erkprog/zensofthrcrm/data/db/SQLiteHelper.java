package com.erkprog.zensofthrcrm.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.data.entity.Criteria;
import com.erkprog.zensofthrcrm.data.entity.Cv;
import com.erkprog.zensofthrcrm.data.entity.Department;
import com.erkprog.zensofthrcrm.data.entity.Evaluation;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import com.erkprog.zensofthrcrm.data.entity.Interviewer;
import com.erkprog.zensofthrcrm.data.entity.Position;
import com.erkprog.zensofthrcrm.data.entity.Request;
import com.erkprog.zensofthrcrm.data.entity.Requirement;
import com.erkprog.zensofthrcrm.data.entity.Template;
import com.erkprog.zensofthrcrm.data.entity.User;
import com.erkprog.zensofthrcrm.data.entity.Vacancy;

import java.util.ArrayList;
import java.util.List;

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
      CRITERIAS + ID + " TEXT);";


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
      NAME + " TEXT);";

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

  public void saveRequests(List<Request> requests) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < requests.size(); i++) {
      Request request = requests.get(i);
      cv.put(ID, request.getId());
      if(request.getPosition() != null)
      cv.put(POSITION+ID, request.getPosition().getId());
      cv.put(COUNT, request.getStatus());
      cv.put(CREATED, request.getCreated());
      // push requirements IDs to list as string type
      List<String> reqIds = new ArrayList<String>();
      if(request.getRequirementList() != null) {
        List<Requirement> requirements = request.getRequirementList();
        for (int j = 0; j < requirements.size(); j++) {
          reqIds.add(requirements.get(j).getId().toString());
        }
        // convert from List to String
        String stringReqList = Converter.convertListToString(reqIds);
        cv.put(REQUIREMENTS + ID, stringReqList);
      }
      int conflict = (int) db.insertWithOnConflict(REQUESTS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(REQUESTS,cv, ID + " = ?",new String[] {
            request.getId().toString() });
    }

    db.close();
  }

  public void saveDepartments(List<Department> departments) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < departments.size(); i++) {
      Department department = departments.get(i);

      cv.put(ID, department.getId());
      cv.put(NAME, department.getName());

      int conflict = (int) db.insertWithOnConflict(DEPARTMENTS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(DEPARTMENTS,cv, ID + " = ?",new String[] {
            department.getId().toString() });
    }

    db.close();
  }

  public void savePositions(List<Position> positions) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < positions.size(); i++) {
      Position position = positions.get(i);

      cv.put(ID, position.getId());
      cv.put(NAME, position.getName());
      if(position.getDepartment() != null)
      cv.put(DEPARTMENT+ID, position.getDepartment().getName());

      int conflict = (int) db.insertWithOnConflict(POSITIONS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(POSITIONS,cv, ID + " = ?",new String[] {
            position.getId().toString() });
    }

    db.close();
  }

  public void saveRequirements(List<Requirement> requirements) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < requirements.size(); i++) {
      Requirement requirement = requirements.get(i);

      cv.put(ID, requirement.getId());
      cv.put(NAME, requirement.getName());
      if(requirement.getDepartment() != null)
        cv.put(DEPARTMENT+ID, requirement.getDepartment().getName());

      int conflict = (int) db.insertWithOnConflict(REQUIREMENTS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(REQUIREMENTS,cv, ID + " = ?",new String[] {
            requirement.getId().toString() });
    }

    db.close();
  }

  public void saveCvs(List<Cv> cvs) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    for (int i = 0; i < cvs.size(); i++) {
      Cv cv = cvs.get(i);

      contentValues.put(ID, cv.getId());
      contentValues.put(CREATED, cv.getCreated());
      contentValues.put(URL, cv.getLink());

      int conflict = (int) db.insertWithOnConflict(CVS, null,
          contentValues,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(CVS,contentValues, ID + " = ?",new String[] {
            cv.getId().toString() });
    }

    db.close();
  }

  public void saveInterviews(List<Interview> interviews) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < interviews.size(); i++) {
      Interview interview = interviews.get(i);

      cv.put(ID, interview.getId());
      cv.put(DATE, interview.getDate());
      cv.put(STATUS, interview.getStatus());
      if(interview.getCandidate() != null)
        cv.put(CANDIDATE+ID, interview.getCandidate().getId());
      // push inteviewers IDs to list as string type
      List<String> interviewersIds = new ArrayList<String>();
      if(interview.getInterviewersList() != null) {
        List<Interviewer> interviewers = interview.getInterviewersList();
        for (int j = 0; j < interviewers.size(); j++) {
          interviewersIds.add(interviewers.get(j).getId().toString());
        }
        // convert from List to String
        String stringInterviewersList = Converter.convertListToString(interviewersIds);
        cv.put(INTERVIEWERS + ID, stringInterviewersList);
      }
      int conflict = (int) db.insertWithOnConflict(INTERVIEWS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(INTERVIEWS,cv, ID + " = ?",new String[] {
            interview.getId().toString() });
    }

    db.close();
  }

  public void saveInterviewers(List<Interviewer> interviewers) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < interviewers.size(); i++) {
      Interviewer interviewer = interviewers.get(i);

      cv.put(ID, interviewer.getId());
      if(interviewer.getUser() != null)
        cv.put(USER+ID, interviewer.getUser().getId());
      cv.put(COMMENT, interviewer.getComment());
      // push evaluations IDs to list as string type
      List<String> evaluationsIds = new ArrayList<String>();
      if(interviewer.getEvaluaionList() != null) {
        List<Evaluation> evaluations = interviewer.getEvaluaionList();
        for (int j = 0; j < evaluations.size(); j++) {
          evaluationsIds.add(evaluations.get(j).getId().toString());
        }
        // convert from List to String
        String stringEvaluationsList = Converter.convertListToString(evaluationsIds);
        cv.put(EVALUATIONS + ID, stringEvaluationsList);
      }
      int conflict = (int) db.insertWithOnConflict(INTERVIEWERS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(INTERVIEWERS,cv, ID + " = ?",new String[] {
            interviewer.getId().toString() });
    }

    db.close();
  }

  public void saveEvaluations(List<Evaluation> evaluations) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < evaluations.size(); i++) {
      Evaluation evaluation = evaluations.get(i);

      cv.put(ID, evaluation.getId());
      cv.put(RATE, evaluation.getRate());

      List<String> criteriasIds = new ArrayList<String>();
      if(evaluation.getCriterias() != null) {
        List<Criteria> criterias = evaluation.getCriterias();
        for (int j = 0; j < criterias.size(); j++) {
          criteriasIds.add(criterias.get(j).getId().toString());
        }
        String stringCriteriaList = Converter.convertListToString(criteriasIds);
        cv.put(CRITERIAS + ID, stringCriteriaList );
      }

      int conflict = (int) db.insertWithOnConflict(EVALUATIONS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);

      if(conflict < 0)
        db.update(CVS,cv, ID + " = ?",new String[] {
            evaluation.getId().toString() });
    }

    db.close();
  }

  public void saveCandidates(List<Candidate> candidates) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < candidates.size(); i++) {
      Candidate candidate = candidates.get(i);

      cv.put(ID, candidate.getId());
      cv.put(FIRST_NAME, candidate.getFirstName());
      cv.put(LAST_NAME, candidate.getLastName());
      cv.put(EMAIL, candidate.getEmail());
      cv.put(LEVEL, candidate.getLevel());
      cv.put(PHONE, candidate.getPhone());
      cv.put(STATUS, candidate.getStatus());
      cv.put(EXPERIENCE, candidate.getExperience());

      // CVS
      List<String> cvsIds = new ArrayList<String>();
      if(candidate.getCvs() != null) {
        List<Cv> cvs = candidate.getCvs();
        for (int j = 0; j < cvs.size(); j++) {
          cvsIds.add(cvs.get(j).getId().toString());
        }
        // convert from List to String
        String stringCvsList = Converter.convertListToString(cvsIds);
        cv.put(EVALUATIONS + ID, stringCvsList);
      }
      //
      // Interviews
      List<String> interviewsIds = new ArrayList<String>();
      if(candidate.getInterviews() != null) {
        List<Interview> interviews = candidate.getInterviews();
        for (int j = 0; j < interviews.size(); j++) {
          interviewsIds.add(interviews.get(j).getId().toString());
        }
        // convert from List to String
        String stringInterviewsList = Converter.convertListToString(interviewsIds);
        cv.put(EVALUATIONS + ID, stringInterviewsList);
      }
      //

      int conflict = (int) db.insertWithOnConflict(CANDIDATES, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);

      if(conflict < 0)
        db.update(CANDIDATES,cv, ID + " = ?",new String[] {
            candidate.getId().toString() });
    }

    db.close();
  }

  public void saveVacancies(List<Vacancy> vacancies) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < vacancies.size(); i++) {
      Vacancy vacancy = vacancies.get(i);

      cv.put(ID, vacancy.getId());
      cv.put(NAME, vacancy.getName());
      cv.put(LAST_PUBLISHED, vacancy.getDateLastPublished());
      cv.put(CREATED, vacancy.getDateCreated());

      int conflict = (int) db.insertWithOnConflict(VACANCIES, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(VACANCIES,cv, ID + " = ?",new String[] {
            vacancy.getId().toString() });
    }

    db.close();
  }

  public void saveUsers(List<User> users) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < users.size(); i++) {
      User user = users.get(i);

      cv.put(ID, user.getId());
      cv.put(FIRST_NAME, user.getFirstName());
      cv.put(LAST_NAME, user.getLastName());
      cv.put(CREATED, user.getCreated());

      if(user.getDepartment() != null)
        cv.put(DEPARTMENT+ID, user.getDepartment().getId());


      int conflict = (int) db.insertWithOnConflict(USERS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(USERS,cv, ID + " = ?",new String[] {
            user.getId().toString() });
    }

    db.close();
  }

  public void saveCriterias(List<Criteria> criterias) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < criterias.size(); i++) {
      Criteria criteria = criterias.get(i);

      cv.put(ID, criteria.getId());
      cv.put(NAME, criteria.getName());

      int conflict = (int) db.insertWithOnConflict(CRITERIAS, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(CRITERIAS,cv, ID + " = ?",new String[] {
            criteria.getId().toString() });
    }

    db.close();
  }

  public void saveTemplates(List<Template> templates) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    for (int i = 0; i < templates.size(); i++) {
      Template template = templates.get(i);

      cv.put(ID, template.getId());
      cv.put(SUBJECT, template.getSubject());
      cv.put(TYPE, template.getType());
      cv.put(CONTENT, template.getContent());
      cv.put(CREATED, template.getCreated());


      int conflict = (int) db.insertWithOnConflict(TEMPLATES, null,
          cv,
          SQLiteDatabase.CONFLICT_IGNORE);
      // if row is existed then update by id
      if(conflict < 0)
        db.update(TEMPLATES,cv, ID + " = ?",new String[] {
            template.getId().toString() });
    }

    db.close();
  }

}
