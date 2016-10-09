package ru.spbau.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BookAnotherSearchActivity extends Activity {
    //define here some search please and then call returnResult()
    ArrayList<String> books;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_another_search);
        Intent intent = getIntent();
        books = intent.getStringArrayListExtra("books");
        if (books == null) {
            //initialize it yourself
        }
    }

    public void returnResult(String pathToBook) {
        Intent intent = new Intent();
        intent.putExtra("result", pathToBook);
        setResult(RESULT_OK, intent);
        finish();
    }
}
