package com.example.semana7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements NavigationHost{

    LoginFragment loginFragment = new LoginFragment();
    ProductFragment productFragment = new ProductFragment();
    CategoryFragment categoryFragment = new CategoryFragment();
    ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container,
                            new ProductFragment()).commit();
        }

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedLsitener);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedLsitener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.home:
                    loadFragment(productFragment);
                    return true;
                case R.id.category:
                    loadFragment(categoryFragment);
                    return true;
                case R.id.shopping_cart:
                    loadFragment(shoppingCartFragment);
                    return true;
                case R.id.account:
                    loadFragment(loginFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    /**
        *Aquí va el fragmento de navegación
        *@param fragment Fragmento a donde vamos a navegar
        *@param addToBackstack Si podemos ir hacia atrás o no
     */
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack){
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);

        if(addToBackstack){
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}