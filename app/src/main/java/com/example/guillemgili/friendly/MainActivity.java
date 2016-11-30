package com.example.guillemgili.friendly;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity implements MyListener{

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayout;
    public MyAdapter myAdapter;
    ArrayList<Llibre> biblio;
    FloatingActionButton fab2,fab;


    public void change(){
        if(num_llibres_select()== 0){
            fab2.setVisibility(View.INVISIBLE);
        }
        else{
            fab2.setVisibility(View.VISIBLE);
        }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //dono valors a biblio
        inicialitzar_alt();
        myAdapter = new MyAdapter(biblio,this);
        fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AfegirLlibre.class);
                startActivity(intent);
                myAdapter.notifyDataSetChanged();
            }
        });
        fab2 = (FloatingActionButton) findViewById(R.id.del);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Esborrar llibres");
                builder.setMessage("Estas segur que vols esborrar els llibres seleccionats?");

                String positiveText = "Si";
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                                for (int i = 0; i < biblio.size(); i++) {
                                    if (biblio.get(i).isSelected()) {
                                        biblio.remove(i);
                                        myAdapter.notifyDataSetChanged();
                                        i--;
                                    }
                                }
                                fab2.setVisibility(View.INVISIBLE);
                            }
                        });

                String negativeText = "No";
                builder.setNegativeButton(negativeText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // negative button logic
                            }
                        });

                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();
/**
                for (int i = 0; i < biblio.size(); i++) {
                    if (biblio.get(i).isSelected()) {
                        biblio.remove(i);
                        myAdapter.notifyDataSetChanged();
                        i--;
                    }
                }
                fab2.setVisibility(View.INVISIBLE);*/
            }
        });
        fab2.setVisibility(View.INVISIBLE);
        //findViewById del layout activity_main
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        //LinearLayoutManager necesita el contexto de la Activity.
        //El LayoutManager se encarga de posicionar los items dentro del recyclerview
        //Y de definir la politica de reciclaje de los items no visibles.
        mLinearLayout = new LinearLayoutManager(this);

        //Asignamos el LinearLayoutManager al recycler:
        mRecyclerView.setLayoutManager(mLinearLayout);


        //El adapter se encarga de  adaptar un objeto definido en el c�digo a una vista en xml
        //seg�n la estructura definida.
        //Asignamos nuestro custom Adapter
        mRecyclerView.setAdapter(myAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }
    
    void inicialitzar_alt(){

        biblio= new ArrayList<>();
        biblio.add(new Llibre("Mein Kampf","Adolf Hitler", "1925","UberEditorial", "Ideologic", "molt bo"));
        biblio.add(new Llibre("Mein Kampf2","Adolf Hitler", "1925","UberEditorial", "Ideologic", "molt bo"));
        biblio.add(new Llibre("Mein Kampf3","Adolf Hitler", "1925","UberEditorial", "Ideologic", "molt bo"));
        biblio.add(new Llibre("Mein Kampf4","Adolf Hitler", "1925","UberEditorial", "Ideologic", "molt bo"));
        biblio.add(new Llibre());
        biblio.add(new Llibre());

    }
    void inicialitzar() {
        biblio = new ArrayList<>();
        biblio.add(new Llibre(false, "Benito Camela"));
        biblio.add(new Llibre(false, "Alberto Carlos Huevos"));
        biblio.add(new Llibre(true, "Lola Mento"));
        biblio.add(new Llibre(false, "Aitor Tilla"));
        biblio.add(new Llibre(false, "Elvis Teck"));
        biblio.add(new Llibre(true, "Débora Dora"));
        biblio.add(new Llibre(false, "Borja Món de York"));
        biblio.add(new Llibre(true, "Encarna Vales"));
        biblio.add(new Llibre(false, "Enrique Cido"));
        biblio.add(new Llibre(false, "Francisco Jones"));
        biblio.add(new Llibre(true, "Estela Gartija"));
        biblio.add(new Llibre(false, "Andrés Trozado"));
        biblio.add(new Llibre(false, "Carmelo Cotón"));
        biblio.add(new Llibre(false, "Alberto Mate"));
        biblio.add(new Llibre(false, "Chema Pamundi"));
        biblio.add(new Llibre(false, "Armando Adistancia"));
        biblio.add(new Llibre(true, "Helena Nito Del Bosque"));
        biblio.add(new Llibre(false, "Unai Nomás"));
        biblio.add(new Llibre(true, "Ester Colero"));
        biblio.add(new Llibre(false, "Marcos Corrón"));
        biblio.add(new Llibre(false, "aa"));
        biblio.add(new Llibre(false, "aaa"));
    }

    public Integer num_llibres_select() {
        Integer num = 0;
        for (Llibre c : biblio) {
            if (c.isSelected()) num=num+1;
        }
        return num;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }



/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterViewHolder> {

        ArrayList<Llibre> biblio;
        MyListener myListener;
        MyAdapter(ArrayList<Llibre> a,MyListener myListener) {
            biblio = a;
            this.myListener=myListener;
        }




        @Override
        public MyAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            //Instancia un layout XML en la correspondiente vista.
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            //Inflamos en la vista el layout para cada elemento
            View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
            return new AdapterViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final MyAdapter.AdapterViewHolder adapterViewholder, int position) {
            if (position == biblio.size() - 1 || position == biblio.size() - 2) {
                //faig que els dos ultims siguin invisibles per deixar espai pel botó d'afegir
                adapterViewholder.exodia.setVisibility(View.INVISIBLE);
            } else {
                adapterViewholder.exodia.setVisibility(View.VISIBLE);
                adapterViewholder.info.setText(biblio.get(position).getName());
                //adapterViewholder.frame.setBackgroundResource(R.drawable.button);
                adapterViewholder.item = biblio.get(position);
                adapterViewholder.descripcio.setText(buildDescription(adapterViewholder.item));
                ///per cada cop que els hagi de recarregar
                if (biblio.get(position).isSelected()) {
                    //red
                    adapterViewholder.colorea.setBackgroundColor(0x77EF9A9A);
                    adapterViewholder.frame.setVisibility(View.VISIBLE);
                    adapterViewholder.frame.setBackgroundResource(R.drawable.no);
                } else {
                    //green
                    adapterViewholder.colorea.setBackgroundColor(0x77C5E1A5);
                    //adapterViewholder.frame.setVisibility(View.VISIBLE);
                    adapterViewholder.frame.setBackgroundResource(R.drawable.button);

                }
                if(biblio.get(position).isVisible()){
                    //muestra descripcion
                    adapterViewholder.cartadescripcio.setVisibility(View.VISIBLE);
                }
                else{
                    //no la muestra
                    adapterViewholder.cartadescripcio.setVisibility(View.GONE);
                }

            }
        }

        @Override
        public int getItemCount() {
            //Debemos retornar el tamaño de todos los elementos contenidos en el viewholder
            //Por defecto es return 0 --> No se mostrará nada.
            return biblio.size();
        }

        String buildDescription(Llibre llibre){
            String a=new String();
            a="Name: "+ llibre.getName()+ '\n' + "Author: "+ llibre.getAuthor() + '\n' +"Year: "+
            llibre.getYear() + '\n' + "Editorial: " + llibre.getEditorial() + '\n'+"Categoria: " + llibre.getCategoria()+
            '\n'+ "Valoracio: " + llibre.getValoracio() ;
            return a;
        }

        //Definimos una clase viewholder que funciona como adapter para
        public class AdapterViewHolder extends RecyclerView.ViewHolder {
            /*
            *  Mantener una referencia a los elementos de nuestro ListView mientras el usuario realiza
            *  scrolling en nuestra aplicación. Así que cada vez que obtenemos la vista de un item,
            *  evitamos las frecuentes llamadas a findViewById, la cuál se realizaría únicamente la primera vez y el resto
            *  llamaríamos a la referencia en el ViewHolder, ahorrándonos procesamiento.
            */
            public CardView exodia,cartadescripcio;
            public Llibre item;
            public ImageView frame,more;
            public TextView info;
            public View v;
            public LinearLayout colorea;
            public TextView descripcio;
            public AdapterViewHolder(final View itemView) {
                super(itemView);
                this.v = itemView;
                this.descripcio=(TextView) itemView.findViewById(R.id.descripcio);
                this.exodia = (CardView) itemView.findViewById(R.id.card_view);
                this.colorea = (LinearLayout) itemView.findViewById(R.id.colorea);
                this.info = (TextView) itemView.findViewById(R.id.info_text);
                this.frame = (ImageView) itemView.findViewById(R.id.frame);
                this.more=(ImageView) itemView.findViewById(R.id.more);
                this.cartadescripcio=(CardView) itemView.findViewById(R.id.card_descripcio);
                frame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item.isSelected()) {
                            //if it was red
                            item.unselect();
                            myListener.change();
                            //View paperera = ((ViewGroup) view).getChildAt(2);
                            //paperera.setVisibility(View.VISIBLE);
                            //view.setBackgroundColor(0x77C5E1A5);
                            //view.setBackgroundResource(R.drawable.button);
                        } else {
                            //if it was green
                            item.select();
                            myListener.change();
                            //View paperera = ((ViewGroup) view).getChildAt(2);
                            //paperera.setVisibility(View.INVISIBLE);
                            //view.setBackgroundColor(0x77EF9A9A);
                            //view.setBackgroundResource(R.drawable.no);
                        }

                    }
                });
                more.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        item.setVisible(! item.isVisible());
                        myListener.change();
                    }
                });
                
            }
        }
    }
}
