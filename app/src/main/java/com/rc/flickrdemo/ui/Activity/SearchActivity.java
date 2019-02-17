package com.rc.flickrdemo.ui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rc.flickrdemo.R;
import com.rc.flickrdemo.common.Constants;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText searchTagText = (EditText)findViewById(R.id.SearchTagTxt);
        Button searchButton =  (Button) findViewById(R.id.SearchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String flickrSearchTag = searchTagText.getText().toString();

                Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                Bundle searchBundle = new Bundle();
                searchBundle.putString(Constants.SEARCH_TAG, flickrSearchTag);
                intent.putExtras(searchBundle);

                startActivity(intent);
            }
        });
    }
}
