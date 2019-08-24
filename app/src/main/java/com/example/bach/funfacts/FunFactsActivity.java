package com.example.bach.funfacts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_COLOR = "KEY_COLOR" ;
    private static final String KEY_FACT = "KEY_FACT";
    private ConstraintLayout mConstraintLayout;
    private TextView FactTextView;
    private Button showFactButton;
    private FactBook book = new FactBook();
    private ColorWheel wheel = new ColorWheel();
    private String mFact = book.facts[0];
    private int mColor = Color.parseColor(wheel.colors[8]);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, 
                mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        FactTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR) ;
        mConstraintLayout.setBackgroundColor(mColor);
        showFactButton.setTextColor(mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
     
        this.FactTextView=findViewById(R.id.textView4);
        this.showFactButton = findViewById(R.id.showfactbutton);
        this.mConstraintLayout = findViewById(R.id.relativeLayout);


        
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact= book.getFact();
                mColor = wheel.getColor();
                FactTextView.setText(mFact);
                mConstraintLayout.setBackgroundColor(mColor);
                showFactButton.setTextColor(mColor);
            }
        };
      
        this.showFactButton.setOnClickListener(listener);
        //Toast.makeText(this , "YAY! Our Activity was created!" , Toast.LENGTH_SHORT).show();
        Log.d(TAG , "We're logging from the onCreate() method!"); 
    }
}
