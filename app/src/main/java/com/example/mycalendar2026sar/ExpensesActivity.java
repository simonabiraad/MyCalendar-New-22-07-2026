package com.example.mycalendar2026sar;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expenses);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.expenses_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.dailyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, DailyExpensesActivity.class));
        });

        findViewById(R.id.weeklyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, WeeklyExpensesActivity.class));
        });

        findViewById(R.id.monthlyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, MonthlyExpensesActivity.class));
        });
    }
}