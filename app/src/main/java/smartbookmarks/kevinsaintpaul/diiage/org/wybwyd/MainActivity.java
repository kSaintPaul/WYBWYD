package smartbookmarks.kevinsaintpaul.diiage.org.wybwyd;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Model.Beer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Beer beer = new Beer();
        beer.Nom = "Leffe";
        beer.Desc = "Biere blonde";
        beer.Alc = 6.0F;
        beer.Price = 2.5F;



        //Ajout biere
        ContentValues content = new ContentValues();
        content.put("nom", beer.Nom);
        content.put("desc", beer.Desc);
        content.put("alc", beer.Alc);
        content.put("price", beer.Price);

        long idBiere = db.insert(DbHelper.Table_Beer, null, content);


        //Modification bière
        ContentValues newContent = new ContentValues();
        newContent.put("desc", "Biere blonde basique");
        db.update(DbHelper.Table_Beer, newContent, "nom = ?", new String[]{("Leffe")});

        db.beginTransaction();

        //Delete Bières
        db.delete(DbHelper.Table_Beer, "nom = ?", new String[]{"Leffe"});

        db.endTransaction();



    }
}
