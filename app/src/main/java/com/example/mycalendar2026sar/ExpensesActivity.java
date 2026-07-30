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

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ExpensesActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private List<Account> accountList = new ArrayList<>();
    private AccountAdapter adapter;
    private Button topExpensesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expenses);

        loadAccounts();
        if (accountList.isEmpty()) {
            accountList.add(new Account("Expenses", 0.00));
            accountList.add(new Account("Cash", 500.00));
            accountList.add(new Account("Bank", 1500.00));
            saveAccounts();
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        topExpensesButton = findViewById(R.id.topExpensesButton);
        NavigationView navigationView = findViewById(R.id.expensesNavigationView);

        findViewById(R.id.expensesMenuButton).setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        topExpensesButton.setOnClickListener(v -> showAccountsDialog());

        findViewById(R.id.expensesOverflowButton).setOnClickListener(v -> {
            androidx.appcompat.widget.PopupMenu popup = new androidx.appcompat.widget.PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.menu_expenses_overflow, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                String title = String.valueOf(item.getTitle());
                if (id == R.id.action_date_asc || id == R.id.action_date_desc) {
                    item.setChecked(true);
                } else if (id == R.id.action_category) {
                    startActivity(new Intent(this, CategoryActivity.class));
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
            View subDaily = findViewById(R.id.subDailyContainer);
            View subAll = findViewById(R.id.subExpensesContainer);
            View subWeekly = findViewById(R.id.subWeeklyContainer);
            View subMonthly = findViewById(R.id.subMonthlyContainer);
            View subYearly = findViewById(R.id.subYearlyContainer);
            subAll.setVisibility(View.GONE);
            subWeekly.setVisibility(View.GONE);
            subMonthly.setVisibility(View.GONE);
            subYearly.setVisibility(View.GONE);
            if (subDaily.getVisibility() == View.VISIBLE) {
                subDaily.setVisibility(View.GONE);
            } else {
                subDaily.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.subTodayButton).setOnClickListener(v -> startActivity(new Intent(this, DailyExpensesActivity.class)));

        findViewById(R.id.weeklyButton).setOnClickListener(v -> {
            View subWeekly = findViewById(R.id.subWeeklyContainer);
            View subAll = findViewById(R.id.subExpensesContainer);
            View subDaily = findViewById(R.id.subDailyContainer);
            View subMonthly = findViewById(R.id.subMonthlyContainer);
            View subYearly = findViewById(R.id.subYearlyContainer);
            subAll.setVisibility(View.GONE);
            subDaily.setVisibility(View.GONE);
            subMonthly.setVisibility(View.GONE);
            subYearly.setVisibility(View.GONE);
            if (subWeekly.getVisibility() == View.VISIBLE) {
                subWeekly.setVisibility(View.GONE);
            } else {
                subWeekly.setVisibility(View.VISIBLE);
            }
        });

        Button subWeeklyRangeButton = findViewById(R.id.subWeeklyRangeButton);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String startWeekly = sdf.format(calendar.getTime());
        calendar.add(Calendar.DATE, 6);
        String endWeekly = sdf.format(calendar.getTime());
        subWeeklyRangeButton.setText(startWeekly + " to " + endWeekly);
        subWeeklyRangeButton.setOnClickListener(v -> startActivity(new Intent(this, WeeklyExpensesActivity.class)));

        findViewById(R.id.monthlyButton).setOnClickListener(v -> {
            View subMonthly = findViewById(R.id.subMonthlyContainer);
            View subAll = findViewById(R.id.subExpensesContainer);
            View subDaily = findViewById(R.id.subDailyContainer);
            View subWeekly = findViewById(R.id.subWeeklyContainer);
            View subYearly = findViewById(R.id.subYearlyContainer);
            subAll.setVisibility(View.GONE);
            subDaily.setVisibility(View.GONE);
            subWeekly.setVisibility(View.GONE);
            subYearly.setVisibility(View.GONE);
            if (subMonthly.getVisibility() == View.VISIBLE) {
                subMonthly.setVisibility(View.GONE);
            } else {
                subMonthly.setVisibility(View.VISIBLE);
            }
        });

        Button subMonthlyRangeButton = findViewById(R.id.subMonthlyRangeButton);
        Calendar monthCal = Calendar.getInstance();
        monthCal.set(Calendar.DAY_OF_MONTH, 1);
        String startMonth = sdf.format(monthCal.getTime());
        monthCal.set(Calendar.DAY_OF_MONTH, monthCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String endMonth = sdf.format(monthCal.getTime());
        subMonthlyRangeButton.setText(startMonth + " to " + endMonth);
        subMonthlyRangeButton.setOnClickListener(v -> startActivity(new Intent(this, MonthlyExpensesActivity.class)));

        findViewById(R.id.yearlyButton).setOnClickListener(v -> {
            View subYearly = findViewById(R.id.subYearlyContainer);
            View subAll = findViewById(R.id.subExpensesContainer);
            View subDaily = findViewById(R.id.subDailyContainer);
            View subWeekly = findViewById(R.id.subWeeklyContainer);
            View subMonthly = findViewById(R.id.subMonthlyContainer);
            subAll.setVisibility(View.GONE);
            subDaily.setVisibility(View.GONE);
            subWeekly.setVisibility(View.GONE);
            subMonthly.setVisibility(View.GONE);
            if (subYearly.getVisibility() == View.VISIBLE) {
                subYearly.setVisibility(View.GONE);
            } else {
                subYearly.setVisibility(View.VISIBLE);
            }
        });

        Button subYearlyRangeButton = findViewById(R.id.subYearlyRangeButton);
        Calendar yearCal = Calendar.getInstance();
        yearCal.set(Calendar.DAY_OF_YEAR, 1);
        String startYear = sdf.format(yearCal.getTime());
        yearCal.set(Calendar.DAY_OF_YEAR, yearCal.getActualMaximum(Calendar.DAY_OF_YEAR));
        String endYear = sdf.format(yearCal.getTime());
        subYearlyRangeButton.setText(startYear + " to " + endYear);
        subYearlyRangeButton.setOnClickListener(v -> Toast.makeText(this, "Yearly Expenses view coming soon", Toast.LENGTH_SHORT).show());

        findViewById(R.id.allButton).setOnClickListener(v -> {
            View subAll = findViewById(R.id.subExpensesContainer);
            View subDaily = findViewById(R.id.subDailyContainer);
            View subWeekly = findViewById(R.id.subWeeklyContainer);
            View subMonthly = findViewById(R.id.subMonthlyContainer);
            View subYearly = findViewById(R.id.subYearlyContainer);
            subDaily.setVisibility(View.GONE);
            subWeekly.setVisibility(View.GONE);
            subMonthly.setVisibility(View.GONE);
            subYearly.setVisibility(View.GONE);
            if (subAll.getVisibility() == View.VISIBLE) {
                subAll.setVisibility(View.GONE);
            } else {
                subAll.setVisibility(View.VISIBLE);
            }
            Toast.makeText(this, "All Expenses view coming soon", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.subAllButton).setOnClickListener(v -> {
            Toast.makeText(this, "Full-width All clicked", Toast.LENGTH_SHORT).show();
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

    private void showAccountsDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_accounts, null);
        androidx.appcompat.app.AlertDialog dialog = new androidx.appcompat.app.AlertDialog.Builder(this)
                .setView(dialogView)
                .create();

        androidx.recyclerview.widget.RecyclerView recyclerView = dialogView.findViewById(R.id.accountsRecyclerView);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        
        adapter = new AccountAdapter(accountList, new AccountAdapter.OnAccountClickListener() {
            @Override
            public void onAccountClick(Account account) {
                topExpensesButton.setText(account.getName());
                dialog.dismiss();
            }

            @Override
            public void onDeleteClick(Account account, int position) {
                new androidx.appcompat.app.AlertDialog.Builder(ExpensesActivity.this)
                        .setTitle("Delete Account")
                        .setMessage("Are you sure you want to delete " + account.getName() + "?")
                        .setPositiveButton("Delete", (d, w) -> {
                            accountList.remove(account);
                            adapter.updateList(accountList);
                            saveAccounts();
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }

            @Override
            public void onRenameClick(Account account, int position) {
                android.widget.EditText input = new android.widget.EditText(ExpensesActivity.this);
                input.setText(account.getName());
                new androidx.appcompat.app.AlertDialog.Builder(ExpensesActivity.this)
                        .setTitle("Rename Account")
                        .setView(input)
                        .setPositiveButton("Rename", (d, w) -> {
                            String newName = input.getText().toString();
                            if (!newName.isEmpty()) {
                                account.setName(newName);
                                adapter.notifyItemChanged(position);
                                if (topExpensesButton.getText().toString().equals(account.getName())) {
                                    topExpensesButton.setText(newName);
                                }
                                saveAccounts();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }

            @Override
            public void onListChanged() {
                saveAccounts();
            }
        });
        recyclerView.setAdapter(adapter);

        dialogView.findViewById(R.id.editAccountsButton).setOnClickListener(v -> {
            adapter.setEditMode(!adapter.isEditMode());
        });

        androidx.appcompat.widget.SearchView searchView = dialogView.findViewById(R.id.accountsSearchView);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });

        dialogView.findViewById(R.id.addAccountButton).setOnClickListener(v -> {
            android.widget.EditText input = new android.widget.EditText(this);
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Add New Account")
                    .setView(input)
                    .setPositiveButton("Add", (d, w) -> {
                        String name = input.getText().toString();
                        if (!name.isEmpty()) {
                            accountList.add(new Account(name, 0.00));
                            adapter.updateList(accountList);
                            saveAccounts();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        dialog.show();
    }

    private void saveAccounts() {
        try {
            JSONArray array = new JSONArray();
            for (Account account : accountList) {
                JSONObject obj = new JSONObject();
                obj.put("name", account.getName());
                obj.put("balance", account.getBalance());
                array.put(obj);
            }
            getSharedPreferences("ExpensesPrefs", MODE_PRIVATE)
                    .edit()
                    .putString("AccountList", array.toString())
                    .apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAccounts() {
        try {
            String json = getSharedPreferences("ExpensesPrefs", MODE_PRIVATE)
                    .getString("AccountList", null);
            if (json != null) {
                JSONArray array = new JSONArray(json);
                accountList.clear();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    accountList.add(new Account(obj.getString("name"), obj.getDouble("balance")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
