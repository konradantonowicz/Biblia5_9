package com.example.biblia59.Rozne;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.biblia59.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
public class Obsluga_Bazy_Danych_TablicaFTS3 extends SQLiteOpenHelper
    {
        public static final String DBNAME = "Tabela.db";
        @SuppressLint("SdCardPath") public static final String DBLOCATION = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/";
        private Context mContext;
        private SQLiteDatabase mDatabase;
        public Obsluga_Bazy_Danych_TablicaFTS3(Context context)
            {
                super(context, DBNAME, null, 1);
                this.mContext = context;
            }
        @Override public void onCreate(SQLiteDatabase db)            {
            }
        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)            {
            }
        public void openDatabase()
            {
                String dbPath = mContext.getDatabasePath(DBNAME).getPath();
                if (mDatabase != null && mDatabase.isOpen()) {
                    return;
                }
                mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
            }
        public boolean sprawdz()
            {
                boolean czyjest = true;
                File database = mContext.getDatabasePath(Obsluga_Bazy_Danych_TablicaFTS3.DBNAME);
                if (!database.exists()) {
                    getReadableDatabase();
                    close();
                    copyDatabase(mContext);
                    czyjest = false;
                }
                return czyjest;
            }
        private void copyDatabase(Context context)
            {
                try {
                    InputStream inputStream = context.getAssets().open(Obsluga_Bazy_Danych_TablicaFTS3.DBNAME);
                    String outFileName = Obsluga_Bazy_Danych_TablicaFTS3.DBLOCATION + Obsluga_Bazy_Danych_TablicaFTS3.DBNAME;
                    OutputStream outputStream = new FileOutputStream(outFileName);
                    byte[] buff = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buff)) > 0) {
                        outputStream.write(buff, 0, length);
                    }
                    outputStream.flush();
                    outputStream.close();
                    Log.w("AktywnoscGlowna", "DB copied");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        public Cursor PokaszWyszukaneSlowa(String SzukaneSlowo)
            {
                openDatabase();
                String[] ksiegi = {SzukaneSlowo};
                String MySQL = "select numer_ksiegi,numer_rozdzialu,numer_wersetu,tresc_wersetu from Tabela_slownik Where tresc_wersetu MATCH ? ;";
                return mDatabase.rawQuery(MySQL, ksiegi);
            }
        public List<String> pokaz_slownik()
            {
                List<String> ListaWersetow = new ArrayList<>();
                openDatabase();
                Cursor k = mDatabase.rawQuery("select tresc_wersetu from Tabela_slownik", null);
                k.moveToFirst();
                while (!k.isAfterLast()) {
                    String trescwersu_cur = k.getString(0);
                    ListaWersetow.add(trescwersu_cur);
                    k.moveToNext();
                }
                k.close();
                return ListaWersetow;
            }
    }