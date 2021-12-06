package com.example.semana7;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView (
        @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        final TextInputLayout usernameTextInput = view.findViewById(R.id.username_text_input);
        final TextInputEditText usernameTextEditText = view.findViewById(R.id.username_edit_text);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordTextEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.button_login);
        MaterialButton registerButton = view.findViewById(R.id.button_new_account);

        usernameTextEditText.setText("");
        passwordTextEditText.setText("");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPasswordValid(passwordTextEditText.getText()) && !isUsernameValid(usernameTextEditText.getText())){
                    passwordTextInput.setError(getString(R.string.error_password));
                    usernameTextInput.setError(getString(R.string.error_username));
                } else {
                    if (!isPasswordValid(passwordTextEditText.getText())) {
                        passwordTextInput.setError(getString(R.string.error_password));
                    } else {
                        passwordTextInput.setError(null);
                        if (!isUsernameValid(usernameTextEditText.getText())) {
                            usernameTextInput.setError(getString(R.string.error_username));
                        } else {
                            usernameTextInput.setError(null);
                            Snackbar.make(view,"Bienvenido. Sesión iniciada correctamente.",Snackbar.LENGTH_SHORT).show();
                            ((NavigationHost) getActivity()).navigateTo(new AccountFragment(), false);
                        }
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ((NavigationHost) getActivity()).navigateTo(new RegisterFragment(),false);
            }
        });

        passwordTextEditText.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent){
                if(!isPasswordValid(passwordTextEditText.getText())){
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });

        usernameTextEditText.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent){
                if(!isUsernameValid(usernameTextEditText.getText())){
                    usernameTextEditText.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    private boolean isUsernameValid (@Nullable Editable text){
        return text != null && text.length() >= 1;
    }

    private boolean isPasswordValid (@Nullable Editable text){
        return text != null && text.length() >= 6;
    }
}
