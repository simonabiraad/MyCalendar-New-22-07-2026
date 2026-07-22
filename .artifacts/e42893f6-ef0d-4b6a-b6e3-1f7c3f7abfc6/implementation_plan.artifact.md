# Implementation Plan - Add Export Menu to Expenses

The user wants to add a "mini box" button to the Expenses screen header that opens a menu with "Report", "PDF", and "Excel" options, each with a mini logo.

## User Review Required

> [!IMPORTANT]
> The new button will be placed in the header, next to the "Expenses" button. It will use a box-like icon (`@android:drawable/ic_menu_archive`) to distinguish it from the other controls.

## Proposed Changes

### [Expenses Component]

#### [MODIFY] [strings.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/values/strings.xml)
- Add string resources for "Report", "PDF", and "Excel".
- Add content description for the new export button.

#### [NEW] [menu_expenses_export.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/menu/menu_expenses_export.xml)
- Create a new menu resource containing:
    - **Report** (icon: `@android:drawable/ic_menu_report_image`)
    - **PDF** (icon: `@android:drawable/ic_menu_save`)
    - **Excel** (icon: `@android:drawable/ic_menu_agenda`)

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Add an `ImageButton` for the export menu (`@android:drawable/ic_menu_archive`).
- Position it to the right of the `topExpensesButton`.

#### [MODIFY] [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialize the export button.
- Implement a click listener that shows a `PopupMenu` using `menu_expenses_export.xml`.
- Add placeholder logic for handling clicks on "Report", "PDF", and "Excel".

## Verification Plan

### Manual Verification
- Deploy the app and navigate to the Expenses screen.
- Verify the new "mini box" button is visible next to the "Expenses" button.
- Click the button to verify the menu opens.
- Verify that "Report", "PDF", and "Excel" are listed with their respective icons.
- Click on an item to verify it shows a confirmation message.