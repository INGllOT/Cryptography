package com.example.sku7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {
EditText text1, text2, text3, haslo, haslo2;
Button szyfruj, odszyfruj;
String outputString;
int klucz1, klucz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haslo = findViewById(R.id.haslo);
        haslo2 = findViewById(R.id.haslo2);
        text1 = findViewById(R.id.edit1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        szyfruj = findViewById(R.id.textSzyfruj);
        odszyfruj = findViewById(R.id.textODSZYFRUJ);

        szyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int klucz = Integer.parseInt(haslo.getText().toString());
                String text = text1.getText().toString();
                int klucz2 = Integer.parseInt(haslo2.getText().toString());
                char[] charSzyfr = szyfruj(klucz, text);
                text2.setText(new String(charSzyfr));
                String byteSzyfr = szyfrujBinarnie(klucz2, charSzyfr);
                text3.setText(byteSzyfr);

            }
        });
    }

    public static char[] szyfruj(int klucz1, String text){

        int a =0;
        char[] chars = text.toCharArray();
        for (char e : chars) {

            e += klucz1;
            chars[a] = e;
            a ++;
        }
        return chars;
    }

    public static String szyfrujBinarnie(int klucz2, char[] chars){

        int b = 0;
        byte[] bytes =  new String(chars).getBytes(StandardCharsets.UTF_8);
        String[] strings = new String[bytes.length];
        for (byte e : bytes)
        {
            e += klucz2;
            System.out.print(e + " ");
            strings[b] = String.valueOf(e);
            b ++;
        }

        String str = TextUtils.join(" ", strings);
        return str;
    }

    }


