package com.example.semana7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView (
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.register_fragment,container,false);
        final TextInputLayout nameTextInput = view.findViewById(R.id.name_text_input);
        final TextInputEditText nameTextEditText = view.findViewById(R.id.name_edit_text);
        final TextInputLayout lastName1TextInput = view.findViewById(R.id.last_name_1_text_input);
        final TextInputEditText lastName1TextEditText = view.findViewById(R.id.last_name_1_edit_text);
        final TextInputLayout lastName2TextInput = view.findViewById(R.id.last_name_2_text_input);
        final TextInputEditText lastName2TextEditText = view.findViewById(R.id.last_name_2_edit_text);
        final TextInputLayout emailTextInput = view.findViewById(R.id.email_text_input);
        final TextInputEditText emailTextEditText = view.findViewById(R.id.email_edit_text);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_register_text_input);
        final TextInputEditText passwordTextEditText = view.findViewById(R.id.password_register_edit_text);
        final TextInputLayout confirmPasswordTextInput = view.findViewById(R.id.confirm_password_register_text_input);
        final TextInputEditText confirmPasswordTextEditText = view.findViewById(R.id.confirm_password_register_edit_text);

        nameTextEditText.setText("");
        lastName1TextEditText.setText("");
        lastName2TextEditText.setText("");
        emailTextEditText.setText("");
        passwordTextEditText.setText("");
        confirmPasswordTextEditText.setText("");

        MaterialButton loginButton = view.findViewById(R.id.button_return_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new LoginFragment(),false);
            }
        });

        return view;
    }

}
