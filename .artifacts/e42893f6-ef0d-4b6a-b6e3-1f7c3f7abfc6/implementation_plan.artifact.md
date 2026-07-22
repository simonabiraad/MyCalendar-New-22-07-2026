# Implementation Plan - Add Navigation Menu to Expenses

The user wants to add a hamburger menu ("three line") to the Expenses screen with a list of 15 items, each with a mini logo (icon).

## User Review Required

> [!IMPORTANT]
> The menu will be implemented using a standard `DrawerLayout` with a `NavigationView`. This will allow for the requested items and icons to be displayed in a clean, scrollable side menu.
> I will use standard Android icons for the "mini logos" for now.

## Proposed Changes

### [Expenses Component]

#### [NEW] [menu_expenses_drawer.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/menu/menu_expenses_drawer.xml)
- Create a new menu resource containing all 15 items with their respective icons and titles.

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Wrap the existing `ConstraintLayout` in a `DrawerLayout`.
- Add a `NavigationView` inside the `DrawerLayout` referencing the new menu.
- Add an `ImageButton` (hamburger icon) at the top-left to trigger the menu.
- Move the `SearchView` slightly if necessary to accommodate the menu button.

#### [MODIFY] [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialize the `DrawerLayout` and `NavigationView`.
- Implement a click listener for the hamburger button to open the drawer.
- Implement a listener for `NavigationView` item selections (e.g., navigating to existing activities or showing Toasts).

#### [MODIFY] [strings.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/values/strings.xml)
- Add string resources for all the new menu items. (Already partially done in preliminary step).

## Verification Plan

### Manual Verification
- Deploy the app and navigate to the Expenses screen.
- Verify the hamburger icon is visible at the top-left.
- Click the icon to verify the navigation drawer opens.
- Verify that all 15 items are listed with their respective icons.
- Click on several items to verify they trigger the expected actions (e.g., opening the Calendar or showing a Toast).