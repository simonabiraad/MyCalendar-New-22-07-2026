package com.example.mycalendar2026sar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button expenseToggle, incomeToggle;
    private boolean isExpenseView = true;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.categoryRecyclerView);
        expenseToggle = findViewById(R.id.categoryExpenseToggle);
        incomeToggle = findViewById(R.id.categoryIncomeToggle);

        findViewById(R.id.categoryBackButton).setOnClickListener(v -> finish());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateList();

        expenseToggle.setOnClickListener(v -> {
            if (!isExpenseView) {
                isExpenseView = true;
                updateToggleStyles();
                updateList();
            }
        });

        incomeToggle.setOnClickListener(v -> {
            if (isExpenseView) {
                isExpenseView = false;
                updateToggleStyles();
                updateList();
            }
        });
    }

    private void updateToggleStyles() {
        if (isExpenseView) {
            expenseToggle.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.light_green));
            incomeToggle.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.gray));
        } else {
            expenseToggle.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.gray));
            incomeToggle.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.light_green));
        }
    }

    private void updateList() {
        List<CategoryItem> items = new ArrayList<>();
        if (isExpenseView) {
            items.add(new CategoryItem(getString(R.string.cat_air_tickets), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_auto_rickshaw), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_bike), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_bills), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_cable_tv), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_car), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_car_insurance), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_card_fee), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_cigarette), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_clothes), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_drinks), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_driver), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_durables), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_education), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_electricity), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_emi), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_entertainment), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_fast_food), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_festivals), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_fitness), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_food), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_fruits_vegetables), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_fuel), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_furniture), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_gas), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_gifts), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_groceries), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_health), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_health_insurance), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_hobby), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_home_insurance), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_house_hold_expenses), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_insurance), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_internet), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_investment_expense), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_kids), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_laundry), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_maid_servant), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_medicine), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_milk), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_mobile), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_other_expense), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_parking), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_party), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_personal_grooming), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_pet), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_rent), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_repair_maintenance), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_restaurant_hotel), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_savings), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_shopping), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_social), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_stationery), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_taxes), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_taxi), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_toiletries), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_toll), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_toys), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_transportation), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_vacation), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_water), android.R.drawable.ic_menu_agenda));
        } else {
            items.add(new CategoryItem(getString(R.string.cat_salary), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_bonus), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_business), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_investment_income), android.R.drawable.ic_menu_agenda));
            items.add(new CategoryItem(getString(R.string.cat_other_income), android.R.drawable.ic_menu_agenda));
        }
        adapter = new CategoryAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private static class CategoryItem {
        String name;
        int iconRes;

        CategoryItem(String name, int iconRes) {
            this.name = name;
            this.iconRes = iconRes;
        }
    }

    private static class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
        private final List<CategoryItem> items;

        CategoryAdapter(List<CategoryItem> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            CategoryItem item = items.get(position);
            holder.nameText.setText(item.name);
            holder.iconImage.setImageResource(item.iconRes);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameText;
            ImageView iconImage;

            ViewHolder(View view) {
                super(view);
                nameText = view.findViewById(R.id.categoryName);
                iconImage = view.findViewById(R.id.categoryIcon);
            }
        }
    }
}