package DbModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Beer;
import smartbookmarks.kevinsaintpaul.diiage.org.wybwyd.DbHelper;

public class BeerModel {
    private DbHelper dbHelper;
    SQLiteDatabase db;

    public BeerModel(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Beer> GetAllBeers(){

        Cursor cursor = db.query(DbHelper.Table_Beer,
                new String[]{"id", "nom", "desc", "alc", "price"},
                null,
                null,
                null,
                null,
                null);

        return Beer.GetBeersByCursor(cursor);
    }

    public ArrayList<Beer> GetBeers(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String groupBy, @Nullable String having, @Nullable String orderBy){
        Cursor cursor = db.query(DbHelper.Table_Beer,
                new String[]{"id", "nom", "desc", "alc", "price"},
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);

        return Beer.GetBeersByCursor(cursor);
    }

    public long AddBeer(Beer beer, @Nullable String nullColumnHack){
        ContentValues contentValues = Beer.ToContentValues(beer);

        return db.insert(DbHelper.Table_Beer
                ,nullColumnHack
                ,contentValues);
    }
}
