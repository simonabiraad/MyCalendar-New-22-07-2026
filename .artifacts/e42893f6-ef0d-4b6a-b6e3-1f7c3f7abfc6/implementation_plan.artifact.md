# Implementation Plan - Update Icons for Income and Expense Buttons

Update the icons for "Add Income" and "Add Expense" to show "+" and "-" inside circles, respectively.

## Proposed Changes

### [Resources Component]

#### [NEW] [ic_add_circle.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/drawable/ic_add_circle.xml)
- Create a new vector drawable for a "+" inside a circle.

#### [NEW] [ic_remove_circle.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/drawable/ic_remove_circle.xml)
- Create a new vector drawable for a "-" inside a circle.

### [Expenses Component]

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Update `addIncomeButton` to use `@drawable/ic_add_circle`.
- Update `addExpenseButton` to use `@drawable/ic_remove_circle`.

## Verification Plan

### Manual Verification
- Deploy the app and navigate to the Expenses screen.
- Verify that the **Add Income** button now has a circled plus icon.
- Verify that the **Add Expense** button now has a circled minus icon.
- Confirm the icons are correctly colored (white) and sized within the buttons.