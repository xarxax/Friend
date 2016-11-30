package com.example.guillemgili.friendly;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AfegirLlibre extends AppCompatActivity {
    EditText name,author,year,editorial,category,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_llibre);
        name=(EditText) findViewById(R.id.name);
        author=(EditText)findViewById(R.id.author);
        year=(EditText)findViewById(R.id.year);
        editorial=(EditText) findViewById(R.id.editorial);
        category=(EditText) findViewById(R.id.editorial);
        score=(EditText)findViewById(R.id.score);
    }
    public void afegir(View view){
        String sname=new String(String.valueOf(name.getText()));
        String sauthor=new String(String.valueOf(author.getText()));
        String syear=new String(String.valueOf(year.getText()));
        String seditorial=new String(String.valueOf(editorial.getText()));
        String scategory=new String(String.valueOf(category.getText()));
        String sscore=new String(String.valueOf(score.getText()));
        if(sname.equals("")){
            Snackbar.make(view, "El llibre ha de tenir nom", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if(sauthor.equals("")){
            Snackbar.make(view, "El llibre ha de tenir autor", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if (syear.equals("")){
            Snackbar.make(view, "El llibre ha de tenir nom", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if(seditorial.equals("")){
            Snackbar.make(view, "El llibre ha de tenir editorial", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if (scategory.equals("")){
            Snackbar.make(view, "El llibre ha de tenir categoria", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if(sscore.equals("")){
            Snackbar.make(view, "El llibre ha de tenir valoracio", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else {
            Snackbar.make(view, "Afegeixo el llibre " + sname, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Llibre a = new Llibre(sname, sauthor, syear,
                    seditorial, scategory, sscore);
            //falta afegir el llibre a la BBDD

            this.finish();
        }
    }
    public void snack(View view){
        Snackbar.make(view, "El llibre es caca", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
