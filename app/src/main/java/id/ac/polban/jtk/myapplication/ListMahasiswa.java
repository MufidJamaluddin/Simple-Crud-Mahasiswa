package id.ac.polban.jtk.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import id.ac.polban.jtk.adapter.MhsCursorAdapter;
import id.ac.polban.jtk.database.MhsDatabaseHelper;

/*
    @author Mufid Jamaluddin
 */
public class ListMahasiswa extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        SQLiteOpenHelper sqLiteOpenHelper = new MhsDatabaseHelper(ListMahasiswa.this);
        ListView listView = findViewById(R.id.list_mhs);

        SQLiteDatabase db = null;
        Cursor cursor = null;

        try
        {
            db = sqLiteOpenHelper.getReadableDatabase();

            cursor = db.query("MAHASISWA",
                    new String[]{"_id","NAME", "NIM"},
                    null, null, null, null,
                    "NIM ASC");

            MhsCursorAdapter adapter = new MhsCursorAdapter(ListMahasiswa.this, cursor);

            listView.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
        finally
        {
            if(cursor != null && cursor.isClosed())
                cursor.close();

            if(db != null && db.isOpen())
                db.close();
        }

    }
}
