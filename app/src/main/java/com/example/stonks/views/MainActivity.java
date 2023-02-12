package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.stonks.R;
import com.example.stonks.database.AppDatabase;
import com.example.stonks.database.daos.MovementDao;
import com.example.stonks.database.daos.UserDao;
import com.example.stonks.database.entities.User;
import com.example.stonks.database.repository.interfaces.IUserRepository;
import com.example.stonks.database.repository.room.UserRepositoryRoom;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<User> usersList;
    TextView tvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsers = (TextView) findViewById(R.id.tvUsers);

        InitializeButtons();

        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        UserDao userDao = db.userDao();
        IUserRepository repo = new UserRepositoryRoom(userDao);


        User user = new User();
        user.setUsername("GastonMastra");
        user.setPassword("1234");
        repo.insertUser(user);

        usersList = repo.getAllUsers();
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < usersList.size(); i++){
            txt.append(usersList.get(i).getUserId()).append(": ").append(usersList.get(i).getUsername()).append("\n");
        }
        tvUsers.setText(txt.toString());
    }

    private void InitializeButtons(){
        findViewById(R.id.btnRegisterExpense).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btnRegisterExpense) {
            Intent intent = new Intent(this, RegisterExpense.class);
            startActivity(intent);
        }
    }
}