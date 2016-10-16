package ru.spbau.library;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int errorCode, Intent resultContainer) {
        switch (requestCode) {
            case 42:
                if (errorCode == RESULT_OK) {
                    Uri bookPath = resultContainer.getData();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(bookPath);
                    startActivity(intent);
                }
                break;
        }
    }

    public void onSearchClick(View v) {
        Intent intent = new Intent("Library_SEARCH");
        //intent.putExtra("books", null);
        Bundle extras = new Bundle();
        extras.putStringArrayList("books", null);
        intent.putExtras(extras);
        startActivityForResult(intent, 42);
    }

    public void onRecentBooksClick(View v) {
        Intent intent = new Intent(this, RecentBooksActivity.class);
        startActivity(intent);
    }

    public void onOpenFromLocalClick(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        startActivityForResult(intent, 42);
    }
}
