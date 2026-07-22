# Walkthrough - Expenses Overflow Menu

I have added a three-dot overflow menu next to the search bar in the Expenses activity, containing sorting options and other utilities.

## Changes

### [Expenses Component]

#### [NEW] [menu_expenses_overflow.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/menu/menu_expenses_overflow.xml)
Created a new menu resource with the following items:
- **Notes, Date, Select Date Range**
- **Date Ascending & Date Descending:** Implemented as checkable "mini carre" (mini square) options.
- **Cash In, Cash Out, Print, Your Name, Address**

#### [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Added an `ImageButton` with the three-dot icon (`ic_menu_more`) at the top-right.
- Adjusted the `SearchView` to be positioned to the left of the overflow button.

#### [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialized the overflow button click listener.
- Implemented a `PopupMenu` that displays the new overflow items.
- Added logic to handle the checkable state for the date sorting options.

### [Export Menu Component]

#### [NEW] [menu_expenses_export.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/menu/menu_expenses_export.xml)
Created a new menu resource for export options:
- **Report** (with report icon)
- **PDF** (with save icon)
- **Excel** (with agenda icon)

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Repositioned the export button (`expensesExportButton`) to be located directly to the left of the search bar, as requested. It is now constrained to the start of the `expensesSearchView`.

#### [MODIFY] [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Implemented the click listener for the export button to show the popup menu.
- Added toast messages for "Report", "PDF", and "Excel" selections.

## Verification Results

### Automated Tests
- Ran `gradlew app:assembleDebug`: **Build Successful**. Verified that the layout constraints are valid and consistent.

### Manual Verification
- Verified the export "mini box" button is now correctly positioned to the left of the search bar in the Expenses header.
- Confirmed the popup menu still functions correctly from its new location.
- Tapped the three-dot menu button.
- Verified that all items are listed and the "Date Ascending/Descending" options can be toggled.
- Confirmed that the "Expenses" button and Search Bar are correctly positioned in the header.