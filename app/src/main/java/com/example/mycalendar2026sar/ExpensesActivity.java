package com.example.mycalendar2026sar;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

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

        findViewById(R.id.incomeButton).setOnClickListener(v -> {
            startActivity(new Intent(this, IncomeActivity.class));
        });

        findViewById(R.id.expenseButton).setOnClickListener(v -> {
            startActivity(new Intent(this, ExpenseTypeActivity.class));
        });

        findViewById(R.id.transferButton).setOnClickListener(v -> {
            startActivity(new Intent(this, TransferActivity.class));
        });

        SearchView searchView = findViewById(R.id.expensesSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Future implementation for search
                Toast.makeText(ExpensesActivity.this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Future implementation for real-time filtering
                return true;
            }
        });
    }
}