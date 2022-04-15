package com.example.shiyan82;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<Book> {
    private  int  resourceId;
    private LayoutInflater inflater;
   public BookAdapter(Context context, int textViewResourceId, List<Book> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Book book=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView bookname=(TextView) view.findViewById(R.id.lbookname);
        TextView categoryid=(TextView) view.findViewById(R.id.lcategoryid);
        TextView price=(TextView) view.findViewById(R.id.lprice);
        bookname.setText(book.getName());
        categoryid.setText(book.getCategoryid()+"");
        price.setText(book.getPrice()+"");
        return  view;
   }
}
