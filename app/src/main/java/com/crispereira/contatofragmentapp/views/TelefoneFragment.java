package com.crispereira.contatofragmentapp.views;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.crispereira.contatofragmentapp.R;
import com.crispereira.contatofragmentapp.model.Contact;

public class TelefoneFragment extends Fragment{
    Contact contact;

    public TelefoneFragment(Contact c) {
        super(R.layout.activity_telefone);
        this.contact = c;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputCelular = getActivity().findViewById(R.id.celular);
        EditText inputTelefone = getActivity().findViewById(R.id.telefone);
        inputCelular.setText(contact.getCelular());
        inputTelefone.setText(contact.getTelefone());
    }


    @Override
    public void onPause() {
        super.onPause();
        EditText inputCelular = getActivity().findViewById(R.id.celular);
        EditText inputTelefone = getActivity().findViewById(R.id.telefone);
        contact.setCelular(inputCelular.getText().toString());
        contact.setTelefone(inputTelefone.getText().toString());
    }
}
