package id.ac.polban.jtk.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import id.ac.polban.jtk.myapplication.R;

/*
    @author Mufid Jamaluddin
 */

public class MhsCursorAdapter extends CursorAdapter
{

    /**
     * Konstruktor
     * @param context konteks activity
     * @param cursor cursor dari query
     */
    public MhsCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor,0);
    }

    /**
     * Membuat view baru
     * @param context konteks activity
     * @param cursor cursor query
     * @param viewGroup viewGroup
     * @return View
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup)
    {
        return LayoutInflater.from(context).inflate(R.layout.item_mahasiswa,viewGroup,false);
    }

    /**
     * Bind view dengan data. Dijalankan dengan iterasi
     *
     * @param view view item
     * @param context Konteks activity
     * @param cursor cursor dari query
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView nameV = view.findViewById(R.id.mhs_name);
        TextView nimV = view.findViewById(R.id.mhs_nim);

        nameV.setText(cursor.getString(cursor.getColumnIndexOrThrow("NAME")));
        nimV.setText(cursor.getString(cursor.getColumnIndexOrThrow("NIM")));
    }
}
