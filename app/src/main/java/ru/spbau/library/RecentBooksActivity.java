package ru.spbau.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class RecentBooksActivity extends Activity {
    ArrayList<String> books; //Load here list of books pls. Something you need in search
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_books);
    }

    @Override
    protected void onActivityResult(int requestCode, int errorCode, Intent resultContainer) {
        switch (requestCode) {
            case 42:
                Uri bookPath = Uri.parse(resultContainer.getDataString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(bookPath);
                startActivity(intent);
                break;
        }
    }

    protected void onSearchClick() {
        Intent intent = new Intent("Library_SEARCH");
        Bundle extras = new Bundle();
        extras.putStringArrayList("books", books);
        intent.putExtras(extras);
        startActivityForResult(intent, 42);
    }
}
