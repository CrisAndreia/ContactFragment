package com.crispereira.contatofragmentapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.crispereira.contatofragmentapp.model.Contact;
import com.crispereira.contatofragmentapp.views.EmailFragment;
import com.crispereira.contatofragmentapp.views.HomeFragment;
import com.crispereira.contatofragmentapp.views.TelefoneFragment;

public class MainActivity extends AppCompatActivity {
    int indice = 0;
    Contact contact = new Contact();

    Button proximo;
    Button voltar;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proximo = findViewById(R.id.btProximo);
        voltar = findViewById(R.id.btVoltar);
        salvar = findViewById(R.id.btSalvar);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximoFragment();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarFragment();
            }
        });
        navegarParaOutroFragmento(indice);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact(contact);
            }
        });
    }
    public void proximoFragment() {
        indice++;
        if (indice > 2) {
            indice = 2;
        }
        navegarParaOutroFragmento(indice);
    }

    public void voltarFragment() {
        indice--;
        if (indice < 0) {
            indice = 0;
        }
        navegarParaOutroFragmento(indice);
    }

    private void navegarParaOutroFragmento(int indice) {
        Fragment fragment = null;
        switch (indice) {
            case 0:
                Log.d("MAIN", "INDICE 0");
                fragment = new HomeFragment(contact);
                break;
            case 1:
                fragment = new TelefoneFragment(contact);
                Log.d("MAIN", "INDICE UM");
                break;
            case 2:
                fragment = new EmailFragment(contact);
                Log.d("MAIN", "INDICE DOIS");
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }

    public void saveContact(Contact contact) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION)
                .putExtra(ContactsContract.Intents.Insert.NAME, contact.getNome().concat(" " + contact.getSobrenome()))
                .putExtra(ContactsContract.Intents.Insert.PHONE, contact.getTelefone())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_HOME)
                .putExtra(ContactsContract.Intents.Insert.PHONE, contact.getCelular())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                .putExtra(ContactsContract.Intents.Insert.EMAIL, contact.getEmail());
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        startActivity(intent);
    }
}