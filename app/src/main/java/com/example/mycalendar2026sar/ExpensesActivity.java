package com.example.mycalendar2026sar;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ExpensesActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expenses);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.expensesNavigationView);

        findViewById(R.id.expensesMenuButton).setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        findViewById(R.id.topExpensesButton).setOnClickListener(v -> {
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle(R.string.add_accounts_title)
                    .setMessage("Manage your accounts here.")
                    .setPositiveButton("OK", null)
                    .show();
        });

        findViewById(R.id.expensesOverflowButton).setOnClickListener(v -> {
            androidx.appcompat.widget.PopupMenu popup = new androidx.appcompat.widget.PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.menu_expenses_overflow, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                String title = String.valueOf(item.getTitle());
                if (id == R.id.action_date_asc || id == R.id.action_date_desc) {
                    item.setChecked(true);
                }
                Toast.makeText(this, title + " selected", Toast.LENGTH_SHORT).show();
                return true;
            });
            popup.show();
        });

        findViewById(R.id.expensesExportButton).setOnClickListener(v -> {
            androidx.appcompat.widget.PopupMenu popup = new androidx.appcompat.widget.PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.menu_expenses_export, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                String title = String.valueOf(item.getTitle());
                Toast.makeText(this, "Exporting to " + title + "...", Toast.LENGTH_SHORT).show();
                return true;
            });
            popup.show();
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_remove_ads) {
                Toast.makeText(this, "Remove Ads feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_summary) {
                Toast.makeText(this, "Summary feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_account_summary) {
                Toast.makeText(this, "Account Summary feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_transaction_all) {
                Toast.makeText(this, "Transaction - All Accounts feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_accounts) {
                Toast.makeText(this, "Accounts management coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_transfer) {
                startActivity(new Intent(this, TransferActivity.class));
            } else if (id == R.id.nav_report_all) {
                Toast.makeText(this, "Reports feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_transaction_names) {
                Toast.makeText(this, "Transaction Names management coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_notebook) {
                Toast.makeText(this, "Notebook feature coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_calendar) {
                finish(); // Go back to MainActivity
            } else if (id == R.id.nav_cash_calculator) {
                Toast.makeText(this, "Cash Calculator coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_backup_restore) {
                Toast.makeText(this, "Backup & Restore coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_setting) {
                Toast.makeText(this, "Settings coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_deleted_transactions) {
                Toast.makeText(this, "Deleted Transactions folder coming soon", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_rate_us) {
                Toast.makeText(this, "Thank you for wanting to rate us!", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_recommend) {
                Toast.makeText(this, "Recommendations feature coming soon", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.expenses_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.dailyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, IncomeActivity.class));
        });

        findViewById(R.id.weeklyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, ExpenseTypeActivity.class));
        });

        findViewById(R.id.monthlyButton).setOnClickListener(v -> {
            startActivity(new Intent(this, TransferActivity.class));
        });

        findViewById(R.id.yearlyButton).setOnClickListener(v -> {
            Toast.makeText(this, "Yearly Expenses feature coming soon", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.allButton).setOnClickListener(v -> {
            Toast.makeText(this, "All Expenses view coming soon", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.cashInButton).setOnClickListener(v -> {
            Toast.makeText(this, "Cash In functionality coming soon", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.cashOutButton).setOnClickListener(v -> {
            Toast.makeText(this, "Cash Out functionality coming soon", Toast.LENGTH_SHORT).show();
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