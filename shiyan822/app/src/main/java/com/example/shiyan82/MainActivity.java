package com.example.shiyan82;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public MyDatabaseHelper dbHelper;
    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookAdapter adapter = new BookAdapter(MainActivity.this, R.layout.book_item, bookList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        Button addDataButton = (Button) findViewById(R.id.add_category);
        Button addBookButton = (Button) findViewById(R.id.add_book);
        Button queryButton = (Button) findViewById(R.id.select_book);
        Button deleteButton=(Button)findViewById(R.id.delete_book) ;
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
                Toast.makeText(MainActivity.this, "创建成功", Toast.LENGTH_SHORT).show();
            }
        });

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("category_name", "哲学类");
                values.put("category_code", 1);
                db.insert("Category", null, values);
                values.clear();

                values.put("category_name", "自然科学类");
                values.put("category_code", 2);
                db.insert("Category", null, values);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                while(cursor.moveToNext()){
                    String name=cursor.getString(1);
                    double price=cursor.getDouble(2);
                    int categoryid=cursor.getInt(3);
                    Book book = new Book(name, price, categoryid);
                    bookList.add(book);
                }
                
                listView.setAdapter(adapter);
            //    cursor.close();
        }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("Book","pages>?",new String[]{"400"});
                Toast.makeText(MainActivity.this, "删除成功！！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


