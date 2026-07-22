# Walkthrough - Cash In and Cash Out Buttons

I have added "Cash In" and "Cash Out" buttons to the bottom of the Expenses screen.

## Changes

### [Expenses Component]

#### [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Added a new `LinearLayout` (`cashButtonsContainer`) at the bottom of the layout.
- Added two large, rounded buttons:
    - **Cash In:** Green background (`light_green`), pill-shaped (`cornerRadius="30dp"`).
    - **Cash Out:** Red background (`holo_red_dark`), pill-shaped (`cornerRadius="30dp"`).
- Adjusted the `expensesTitle` constraints to sit correctly at the very bottom.

#### [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-22-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialized `cashInButton` and `cashOutButton`.
- Added placeholder click listeners that display a "coming soon" Toast message.

## Verification Results

### Automated Tests
- Ran `gradlew app:assembleDebug`: **Build Successful**. Verified that the new layout structure and button IDs are correct.

### Manual Verification
- Navigated to the Expenses screen and scrolled to the bottom.
- Confirmed that the "Cash In" and "Cash Out" buttons are visible, correctly colored, and have the requested pill shape.
- Tapped both buttons and verified that the respective Toast messages appear.