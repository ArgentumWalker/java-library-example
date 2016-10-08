package ru.spbau.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int errorCode, Intent resultContainer) {
        switch (requestCode) {
            case 42:
                if (errorCode == RESULT_OK) {
                    Uri bookPath = Uri.parse(resultContainer.getDataString());
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(bookPath);
                    startActivity(intent);
                }
                break;
        }
    }

    protected void onSearchClick() {
        Intent intent = new Intent("Library_SEARCH");
        //intent.putExtra("books", null);
        Bundle extras = new Bundle();
        extras.putStringArrayList("books", null);
        intent.putExtras(extras);
        startActivityForResult(intent, 42);
    }

    protected void onRecentBooksClick() {
        Intent intent = new Intent(this, RecentBooksActivity.class);
        startActivity(intent);
    }

    protected void onOpenFromLocalClick() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        startActivityForResult(intent, 42);
    }
}
