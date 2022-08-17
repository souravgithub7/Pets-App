package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView summary=(TextView)view.findViewById(R.id.summary);
        String name_val=cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME));
        String summary_val=cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED));
        name.setText(name_val);
        if(TextUtils.isEmpty(summary_val))
            summary.setText("Unknown Breed");
        else
        summary.setText(summary_val);
    }
}
