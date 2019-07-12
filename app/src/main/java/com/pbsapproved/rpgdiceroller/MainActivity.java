package com.pbsapproved.rpgdiceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setText(int roll, boolean max) {
        TextView textRolls = findViewById(R.id.textRolls);
        TextView currentRoll = findViewById(R.id.currentRoll);
        TextView textTotal = findViewById(R.id.textTotal);

        String stringTotal = textTotal.getText().toString();
        int intTotal = 0;

        if (!stringTotal.equals(""))
            intTotal = Integer.parseInt(stringTotal.substring(2));

        if(currentRoll.getText().toString().equals("Roll the dice!"))
            currentRoll.setText("");
        else if (!currentRoll.getText().toString().equals(""))
            textRolls.append(TextUtils.concat(currentRoll.getText(), " + "));

        Spannable sausageRoll = new SpannableString(Integer.toString(roll));

        if (roll == 1)
            sausageRoll.setSpan(new ForegroundColorSpan(Color.RED),
                    0, sausageRoll.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        else if (max)
            sausageRoll.setSpan(new ForegroundColorSpan(Color.GREEN),
                    0, sausageRoll.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        intTotal += roll;

        currentRoll.setText(sausageRoll);
        textTotal.setText("= " + Integer.toString(intTotal));

        if(textRolls.getText().length() > 68)
        {
            int i = textRolls.getText().toString().indexOf("+");
            CharSequence text = TextUtils.concat("\u2026", textRolls.getText().subSequence(
                    i + 2, textRolls.getText().length()));
            textRolls.setText(text);
        }
    }

    public void clear(View v)
    {
        TextView textRolls = findViewById(R.id.textRolls);
        TextView textTotal = findViewById(R.id.textTotal);
        TextView currentRoll = findViewById(R.id.currentRoll);
        currentRoll.setText("Roll the dice!");
        textRolls.setText("");
        textTotal.setText("");
    }

    public void rollD100(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        boolean max = false;
        if(n == 100)
            max = true;
        setText(n, max);
    }

    public void rollD20(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(20) + 1;
        boolean max = false;
        if(n == 20)
            max = true;
        setText(n, max);
    }

    public void rollD12(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(12) + 1;
        boolean max = false;
        if(n == 12)
            max = true;
        setText(n, max);
    }

    public void rollD8(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(8) + 1;
        boolean max = false;
        if(n == 8)
            max = true;
        setText(n, max);
    }

    public void rollD6(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        boolean max = false;
        if(n == 6)
            max = true;
        setText(n, max);
    }

    public void rollD4(View v)
    {
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        boolean max = false;
        if(n == 4)
            max = true;
        setText(n, max);
    }
}