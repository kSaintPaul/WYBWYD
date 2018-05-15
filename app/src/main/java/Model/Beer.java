package Model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    public String Id;
    public String Nom;
    public String Desc;
    public Float Alc;
    public Float Price;

    public Beer() {
    }

    public Beer(String nom, String desc, Float alc, Float price) {
        Nom = nom;
        Desc = desc;
        Alc = alc;
        Price = price;
    }

    public static ArrayList<Beer> GetBeersByCursor(Cursor cursor){
        ArrayList<Beer> beers = new ArrayList<>();
        Beer beer;
        while(cursor.moveToNext()){
            beer = new Beer();

            beer.Id = cursor.getString(cursor.getColumnIndex("id"));
            beer.Nom = cursor.getString(cursor.getColumnIndex("nom"));
            beer.Desc = cursor.getString(cursor.getColumnIndex("desc"));
            beer.Alc = cursor.getFloat(cursor.getColumnIndex("alc"));
            beer.Price = cursor.getFloat(cursor.getColumnIndex("price"));

            beers.add(beer);
        }


        return beers;
    }

    public static Beer GetBeerByCursor(Cursor cursor){
        Beer beer = new Beer();

        while(cursor.moveToNext()){
            beer = new Beer();

            beer.Id = cursor.getString(cursor.getColumnIndex("id"));
            beer.Nom = cursor.getString(cursor.getColumnIndex("nom"));
            beer.Desc = cursor.getString(cursor.getColumnIndex("desc"));
            beer.Alc = cursor.getFloat(cursor.getColumnIndex("alc"));
            beer.Price = cursor.getFloat(cursor.getColumnIndex("price"));

        }

        return beer;
    }

    public static ContentValues ToContentValues(Beer beer){
        ContentValues contentValues = new ContentValues();

        if(beer.Id != null) {contentValues.put("id", beer.Id);}
        if(beer.Nom != null) {contentValues.put("nom", beer.Nom);}
        if(beer.Desc != null) {contentValues.put("desc", beer.Desc);}
        if(beer.Alc != null) {contentValues.put("alc", beer.Alc);}
        if(beer.Price != null) {contentValues.put("price", beer.Price);}

        return contentValues;
    }



    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Float getAlc() {
        return Alc;
    }

    public void setAlc(Float alc) {
        Alc = alc;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

}
