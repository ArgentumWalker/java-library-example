package ru.spbau.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class BookSearchActivity extends Activity {
    //define here some search please and then call returnResult()
    ArrayList<String> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_search);
        Intent intent = getIntent();
        books = intent.getStringArrayListExtra("books");
        if (books == null) {
            //initialize it yourself
        }
    }

    protected void returnResult(String pathToBook) {
        Intent intent = new Intent();
        intent.putExtra("result", pathToBook);
        setResult(RESULT_OK, intent);
        finish();
    }
}
