package com.crispereira.contatofragmentapp.views;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.crispereira.contatofragmentapp.R;
import com.crispereira.contatofragmentapp.model.Contact;

public class HomeFragment extends Fragment {
    Contact contact;

    public HomeFragment(Contact c){
        super(R.layout.activity_home);
        this.contact = c;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputNome = getActivity().findViewById(R.id.nome);
        EditText inputSobrenome = getActivity().findViewById(R.id.sobrenome);
        inputNome.setText(contact.getNome());
        inputSobrenome.setText(contact.getSobrenome());
    }


    @Override
    public void onPause() {
        super.onPause();
        EditText inputNome = getActivity().findViewById(R.id.nome);
        EditText inputSobrenome = getActivity().findViewById(R.id.sobrenome);
        contact.setNome(inputNome.getText().toString());
        contact.setSobrenome(inputSobrenome.getText().toString());
    }
}



