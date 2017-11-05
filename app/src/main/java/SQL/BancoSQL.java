package SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bruno on 03/11/2017.
 */

public class BancoSQL extends SQLiteOpenHelper{

    ContentValues cv;

    public BancoSQL(Context context) {
        super(context, "dbJoinService", null, 5);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE USUARIO (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "NOME TEXT NOT NULL, "+
                        "EMAIL TEXT NOT NULL, "+
                        "SENHA TEXT NOT NULL, "+
                        "CELULAR TEXT)");

        sqLiteDatabase.execSQL(
                "CREATE TABLE SERVICO (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "DESCRICAO TEXT NOT NULL, "+
                        "PRAZO INTEGER NOT NULL, "+
                        "LONGITUDE TEXT NOT NULL, "+
                        "LATITUDE TEXT NOT NULL, "+
                        "USUARIO_ID INTEGER NOT NULL," +
                        "CATEGORIA_ID INTEGER NOT NULL,"+
                        "FOREIGN KEY(USUARIO_ID) REFERENCES USUARIO(ID)," +
                        "FOREIGN KEY(CATEGORIA_ID) REFERENCES CATEGORIA(ID))");

        sqLiteDatabase.execSQL(
                "CREATE TABLE CATEGORIA_SERVICO (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "DESCRICAO TEXT NOT NULL, "+
                        "CAMINHO_IMAGEM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch(oldVersion) {
            case 1:
                //INSERT USUÁRIO ADMINISTRADOR
                cv = new ContentValues();
                cv.put("NOME", "A");
                cv.put("SENHA","A");
                cv.put("EMAIL", "A");
                cv.put("CELULAR", "81995782171");
                db.insert("USUARIO", null, cv);

                //INSERT DE 5 CATEGORIAS DE SERVIÇO
                cv = new ContentValues();
                cv.put("DESCRICAO", "Saúde e bem-estar");
                db.insert("CATEGORIA_SERVICO", null, cv);

                cv = new ContentValues();
                cv.put("DESCRICAO", "Celulares e Telefones");
                db.insert("CATEGORIA_SERVICO", null, cv);

                cv = new ContentValues();
                cv.put("DESCRICAO", "Eletrodomésticos");
                db.insert("CATEGORIA_SERVICO", null, cv);

                cv = new ContentValues();
                cv.put("DESCRICAO", "Móveis e Decoração");
                db.insert("CATEGORIA_SERVICO", null, cv);

                cv = new ContentValues();
                cv.put("DESCRICAO", "Administrativo");
                db.insert("CATEGORIA_SERVICO", null, cv);

                cv = new ContentValues();
                cv.put("DESCRICAO", "Reforma");
                db.insert("CATEGORIA_SERVICO", null, cv);
            case 2:
                //INSERT USUÁRIO SERVICO
                cv = new ContentValues();
                cv.put("DESCRICAO", "CONSERTO DE CHUVEIRO ELÉTRICO");
                cv.put("PRAZO","2 SEMANAS");
                cv.put("LONGITUDE", "60");
                cv.put("LATITUDE", "30");
                cv.put("USUARIO_ID", "1");
                cv.put("CATEGORIA_ID", "1");
                db.insert("SERVICO", null, cv);
            case 3:
                //INSERT USUÁRIO SERVICO
                cv = new ContentValues();
                cv.put("DESCRICAO", "REFORMA DE QUARTO");
                cv.put("PRAZO","5");
                cv.put("LONGITUDE", "99");
                cv.put("LATITUDE", "152");
                cv.put("USUARIO_ID", "1");
                cv.put("CATEGORIA_ID", "1");
                db.insert("SERVICO", null, cv);
            case 4:
                //INSERT USUÁRIO SERVICO
                cv = new ContentValues();
                cv.put("DESCRICAO", "CONCERTO DE NOTEBOOK");
                cv.put("PRAZO","99");
                cv.put("LONGITUDE", "52");
                cv.put("LATITUDE", "175");
                cv.put("USUARIO_ID", "1");
                cv.put("CATEGORIA_ID", "1");
                db.insert("SERVICO", null, cv);
            case 5:
                //upgrade logic from version 5 to 6
            case 6:
                //upgrade logic from version 6 to 7
                break;
            default:
                throw new IllegalStateException(
                        "onUpgrade() with unknown oldVersion " + oldVersion);
        }
    }
}