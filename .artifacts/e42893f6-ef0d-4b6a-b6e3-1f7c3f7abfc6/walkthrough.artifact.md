# Walkthrough - Expenses Navigation Drawer

I have added a hamburger menu (three line menu) to the Expenses screen with all the requested items and icons.

## Changes

### [Expenses Component]

#### [NEW] [menu_expenses_drawer.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/menu/menu_expenses_drawer.xml)
Created a new menu resource containing all 15 requested items with their respective icons:
- Remove Ads, Summary, Account Summary, Transaction-All Accounts, Accounts, Transfer, Report-All Accounts, Transaction Names, Notebook, Calendar, Cash Calculator, Backup and Restore, Setting, Deleted Transactions, Recommend.

#### [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Wrapped the layout in a `DrawerLayout`.
- Added a `NavigationView` to hold the menu items.
- Added a hamburger `ImageButton` in the top-left to open the menu.

#### [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialized the `DrawerLayout` and `NavigationView`.
- Implemented logic for the hamburger button to open the side menu.
- Added a `NavigationItemSelectedListener` to handle clicks on each menu item (e.g., navigating back to the Calendar or showing placeholder Toasts for new features).

### [Menu Header Component]

#### [NEW] [nav_header_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/nav_header_expenses.xml)
Created a new header layout for the navigation drawer:
- Displays the title "Expenses" in green (`@color/light_green`).
- Styled with a dark background to match the app theme.

#### [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Updated `NavigationView` to use the new `app:headerLayout="@layout/nav_header_expenses"`.

## Verification Results

### Automated Tests
- Ran `gradlew app:assembleDebug`: **Build Successful**. Verified that the new layout resource is correctly linked.

### Manual Verification
- Opened the navigation drawer in the Expenses activity.
- Confirmed the "Expenses" title appears at the top in green.