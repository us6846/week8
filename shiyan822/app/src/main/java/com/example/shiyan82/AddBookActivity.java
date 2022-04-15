package com.example.shiyan82;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import com.example.shiyan82.MyDatabaseHelper;
import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        dbHelper=new MyDatabaseHelper(this,"library.db",null,2);
        EditText name=(EditText)findViewById(R.id.addbName);
        EditText author=(EditText)findViewById(R.id.addbAuthor);
        EditText price=(EditText)findViewById(R.id.addbPrice);
        EditText pages=(EditText) findViewById(R.id.addbPages);
        EditText Idcategory=(EditText)findViewById(R.id.addCategory_id);
        Button addData=(Button) findViewById(R.id.addbook);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String author1=author.getText().toString();
                Double price1=Double.parseDouble(price.getText().toString());
                Integer pages1=Integer.parseInt(pages.getText().toString());
                Integer Idcategory1=Integer.parseInt(Idcategory.getText().toString());
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("author",author1);
                values.put("price",price1);
                values.put("pages",pages1);
                values.put("name",name1);
                values.put("categoryid",Idcategory1);
                db.insert("Book",null,values);
                values.clear();
                author.setText(author1);
                price.setText(""+price1);
                pages.setText(""+pages1);
                name.setText(name1);
                Idcategory.setText(""+Idcategory1);
                Toast.makeText(AddBookActivity.this,"添加数据成功!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
