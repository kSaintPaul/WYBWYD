package smartbookmarks.kevinsaintpaul.diiage.org.wybwyd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static String DB_Name = "DbWYBWYD";

    public static String Table_Beer = "Beer";
    public static String Table_Gamme = "Gamme";
    public static String Table_Ingredient = "Ingredient";
    public static String Table_Beer_Ingredient = "Beer_Ingredient";

    public DbHelper(Context context){
        super(context, DB_Name,null, 2 );
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table_Beer +" (" +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "`nom` TEXT, " +
                "`desc` TEXT, " +
                "`alc` REAL, " +
                "`price` REAL " +
                ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion == 1 && newVersion == 2){
            db.execSQL("CREATE TABLE " + Table_Ingredient +" (" +
                    "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "`nom` TEXT" +
                    ");");

            db.execSQL("CREATE TABLE " + Table_Gamme +" (" +
                    "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                    "`nom` TEXT," +
                    "`desc` TEXT" +
                    ");");

            db.execSQL("CREATE TABLE "+Table_Beer_Ingredient+" (" +
                    "`idBeer` INTEGER," +
                    "`idIngredient` INTEGER," +
                    "PRIMARY KEY(`idBeer`,`idIngredient`)" +
                    ");");

            db.execSQL("ALTER TABLE "+ Table_Beer +
                    " ADD `idGame` INTEGER;");
        }
    }

}
