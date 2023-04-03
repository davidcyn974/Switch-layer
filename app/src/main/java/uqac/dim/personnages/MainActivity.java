package uqac.dim.personnages;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private Mage mage;
    private Guerrier guerrier;
    private Personnage personnageCourant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de l'interface
        mage = new Mage();
        guerrier = new Guerrier();
        personnageCourant = mage;
        chargerPersonnage();



        /*
            INITIALISATION DES LISTENERS ICI
        */


        RadioButton butonGuerrier = (RadioButton)findViewById(R.id.radio_guerrier);
        butonGuerrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personnageCourant = guerrier;
                chargerPersonnage();
            }
        });
        RadioButton butonMage = (RadioButton)findViewById(R.id.radio_mage);
        butonMage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personnageCourant = mage;
                chargerPersonnage();
            }
        });
        /*Button buttonSave =(Button) findViewById(R.id.saveButton);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSpecs();
            }
        });*/
        Button buttonNew = (Button) findViewById(R.id.buttonNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reinitialiserProfil(view);
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canModify();
            }
        });

        Switch myS = (Switch)findViewById(R.id.monSwitchmaterial);
        myS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swi();
            }
        });

        Button reinitiaB = (Button) findViewById(R.id.reinitialiserButton);
        reinitiaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reinitialiserProfil(view);
            }
        });

        Button boubouton = (Button) findViewById(R.id.buttonNew);
        boubouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCharacter();
            }
        });


    }



    private void chargerPersonnage(){

        Log.i("DIM", "chargerProfil");

        if (personnageCourant instanceof Mage){

            ((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.mage);
            ((EditText)findViewById(R.id.PointsMagie)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.textPointsdeMagie)).setVisibility(View.VISIBLE);
            ((EditText)findViewById(R.id.Nom)).setText(mage.getNom());
            ((EditText)findViewById(R.id.Classe)).setText(mage.getClasse());
            ((EditText)findViewById(R.id.Classe)).setEnabled(false);
            ((EditText)findViewById(R.id.PV)).setText(Integer.toString(mage.getPV()));
           ((EditText)findViewById(R.id.CA)).setText(Integer.toString(mage.getCA()));
            ((EditText)findViewById(R.id.DMG)).setText(Integer.toString(mage.getDMG()));
            ((EditText)findViewById(R.id.PointsMagie)).setText(Integer.toString(mage.getPM()));
        }
        if (personnageCourant instanceof Guerrier){
            ((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.guerrier);
            ((TextView)findViewById(R.id.textPointsdeMagie)).setVisibility(View.INVISIBLE);
            ((EditText)findViewById(R.id.PointsMagie)).setVisibility(View.INVISIBLE);
            ((EditText)findViewById(R.id.Nom)).setText(guerrier.getNom());
            ((EditText)findViewById(R.id.Classe)).setText(guerrier.getClasse());
            ((EditText)findViewById(R.id.Classe)).setEnabled(false);
            ((EditText)findViewById(R.id.PV)).setText(Integer.toString(guerrier.getPV()));
            ((EditText)findViewById(R.id.CA)).setText(Integer.toString(guerrier.getCA()));
            ((EditText)findViewById(R.id.DMG)).setText(Integer.toString(guerrier.getDMG()));
        }


    }



    public void reinitialiserProfil(View v){

        Log.i("DIM", "reinitialiserProfil");

        if (personnageCourant instanceof Mage){
            mage = new Mage();
            personnageCourant = mage;
        }
        else{
            guerrier = new Guerrier();
            personnageCourant = guerrier;
        }
        chargerPersonnage();
    }

    public void canModify(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        if(!checkBox.isChecked()){
            ((EditText)findViewById(R.id.Nom)).setEnabled(false);
            ((EditText)findViewById(R.id.PointsMagie)).setEnabled(false);
            ((EditText)findViewById(R.id.PV)).setEnabled(false);
            ((EditText)findViewById(R.id.DMG)).setEnabled(false);
            ((EditText)findViewById(R.id.CA)).setEnabled(false);
        }
        else
        {
            ((EditText)findViewById(R.id.Nom)).setEnabled(true);
            ((EditText)findViewById(R.id.PointsMagie)).setEnabled(true);
            ((EditText)findViewById(R.id.PV)).setEnabled(true);
            ((EditText)findViewById(R.id.DMG)).setEnabled(true);
            ((EditText)findViewById(R.id.CA)).setEnabled(true);
        }
    }
    //Doesn't work
    /*public void saveSpecs(){
        Log.i("DIM", "Saave");
        EditText name = (EditText)findViewById(R.id.Nom);
        EditText pv = (EditText)findViewById(R.id.PV);
        EditText PM = ((EditText)findViewById(R.id.PointsMagie));
        EditText Dmg = ((EditText)findViewById(R.id.DMG));
        EditText Ca = ((EditText)findViewById(R.id.CA));
        if (personnageCourant instanceof Guerrier){
            guerrier.setPV(Integer.parseInt(pv.toString()));
            guerrier.setNom(name.toString());
            guerrier.setDMG(Integer.parseInt(Dmg.toString()));
            guerrier.setCA(Integer.parseInt(Ca.toString()));
        }
        if (personnageCourant instanceof Mage){
            mage.setPV(Integer.parseInt(pv.toString()));
            mage.setNom(name.toString());
            mage.setDMG(Integer.parseInt(Dmg.toString()));
            mage.setCA(Integer.parseInt(Ca.toString()));
            mage.setPM(Integer.parseInt(PM.toString()));
        }
    }*/
    //could do gettext.clear
    public void newCharacter() {
        if (personnageCourant instanceof Mage){
            ((EditText)findViewById(R.id.Nom)).setText("");
            ((EditText)findViewById(R.id.PV)).setText("1");

            // don't know which method is better
            ((EditText)findViewById(R.id.CA)).setText(Integer.toString(22));
            ((EditText)findViewById(R.id.DMG)).setText(Integer.toString(333));
            ((EditText)findViewById(R.id.PointsMagie)).setText(Integer.toString(999));
        }
        if (personnageCourant instanceof Guerrier){

            ((EditText)findViewById(R.id.Nom)).setText("NADA RIEN VIDE");
            ((EditText)findViewById(R.id.PV)).setText("123");
            ((EditText)findViewById(R.id.CA)).setText("456");
            ((EditText)findViewById(R.id.DMG)).setText("789");
        }
    }

    public void swi(){
        Switch switch2 = (Switch)findViewById(R.id.monSwitchmaterial);
        switch2.setText("Le personnage est "+personnageCourant.getAlignement());

    }
}