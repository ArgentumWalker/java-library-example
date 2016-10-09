package ru.spbau.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RecentBooksActivity extends Activity {
    ArrayList<String> books; //Load here list of books pls. Something you need in search
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_books);
    }

    @Override
    public void onActivityResult(int requestCode, int errorCode, Intent resultContainer) {
        switch (requestCode) {
            case 42:
                Uri bookPath = Uri.parse(resultContainer.getStringExtra("result"));
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(bookPath);
                startActivity(intent);
                break;
        }
    }

    public void onSearchClick(View v) {
        Intent intent = new Intent("Library_SEARCH");
        Bundle extras = new Bundle();
        extras.putStringArrayList("books", books);
        intent.putExtras(extras);
        startActivityForResult(intent, 42);
    }
}
