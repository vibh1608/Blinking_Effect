package com.example.rohitgiri.blinking_effect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//MainActivity inherited from the AppCompatActivity class and implementing the interface Animation.AnimationListener.
public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView textMessage;              //Creating object of TextView.
    Button buttonStart;            //Creating object of Button.
    Animation animBlink;          //Creating the object of Animation class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMessage=(TextView)findViewById(R.id.textview);       //creating objects of earlier declared object.
        buttonStart=(Button)findViewById(R.id.button);
        animBlink= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        animBlink.setAnimationListener(this);

        //Onclick event.
        //Creating anonymas class.
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMessage.setVisibility(View.VISIBLE);      //Setting the Visibility.
                textMessage.startAnimation(animBlink);       //Setting the animation.
            }
        });
    }


    //Overriding the methods already declared in interface.
    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(getApplicationContext(),"App Started",Toast.LENGTH_LONG);    //Nitifying by toast.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getApplicationContext(),"App Stopped",Toast.LENGTH_LONG);    //Nitifying by toast.
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
