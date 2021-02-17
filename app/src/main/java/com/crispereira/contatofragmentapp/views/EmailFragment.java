package com.crispereira.contatofragmentapp.views;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.crispereira.contatofragmentapp.R;
import com.crispereira.contatofragmentapp.model.Contact;

public class EmailFragment extends Fragment {
    Contact contact;

    public EmailFragment(Contact c) {
        super(R.layout.activity_email);
        this.contact = c;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText inputEmail = getActivity().findViewById(R.id.email);
        inputEmail.setText(contact.getEmail());
    }


    @Override
    public void onPause() {
        super.onPause();
        EditText inputEmail = getActivity().findViewById(R.id.email);
        contact.setEmail(inputEmail.getText().toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        EditText inputEmail = getActivity().findViewById(R.id.email);
        contact.setEmail(inputEmail.getText().toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        EditText inputEmail = getActivity().findViewById(R.id.email);
        contact.setEmail(inputEmail.getText().toString());
    }

}
