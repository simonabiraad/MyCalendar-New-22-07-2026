# Implementation Plan - Add Cash In and Cash Out Buttons

The user wants to add two buttons, "Cash In" and "Cash Out", at the bottom ("last page") of the Expenses screen.

## User Review Required

> [!IMPORTANT]
> I will place these two buttons side-by-side at the bottom of the `ExpensesActivity` layout, just above or below the "Expenses" title.
> I will use colors that typically represent these actions (e.g., Green for Cash In, Red for Cash Out) and make them rounded to match the existing button style.

## Proposed Changes

### [Expenses Component]

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Add a new `LinearLayout` at the bottom of the `ConstraintLayout`.
- Add "Cash In" and "Cash Out" buttons inside this layout.
- Use `app:cornerRadius` to make them rounded, matching the navigation buttons.
- Adjust the constraints of `expensesTitle` if necessary to ensure it remains visible.

#### [MODIFY] [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialize the two new buttons.
- Implement click listeners for "Cash In" and "Cash Out" (e.g., showing a Toast or placeholder message).

## Verification Plan

### Manual Verification
- Deploy the app and navigate to the Expenses screen.
- Scroll to the bottom and verify that the "Cash In" and "Cash Out" buttons are visible.
- Verify that they have the requested rounded appearance and are placed side-by-side.
- Click each button to verify the expected interaction.