# Implementation Plan: Install Search Bar in Expenses

The goal is to add a search bar at the top of the Expenses screen, positioned above the "Daily", "Weekly", and "Monthly" navigation buttons.

## User Review Required

> [!NOTE]
> The search bar will be added as a UI component. Since the app currently has no expense data or search logic, it will initially serve as a placeholder for future search functionality.

## Proposed Changes

### Expenses UI

#### [MODIFY] [strings.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-23-07-2026/app/src/main/res/values/strings.xml)
- Add a new string resource for the search bar hint: `search_expenses_hint` -> "Search expenses...".

#### [MODIFY] [activity_expenses.xml](file:///C:/Users/simon/StudioProjects/MyCalendar-New-23-07-2026/app/src/main/res/layout/activity_expenses.xml)
- Add `androidx.appcompat.widget.SearchView` at the top of the layout.
- Constrain it to the top of the parent.
- Add some padding and a background (perhaps a dark gray) to make it visible on the black background.
- Update `expensesButtonContainer` to be constrained below the `SearchView`.

### Expenses Logic

#### [MODIFY] [ExpensesActivity.java](file:///C:/Users/simon/StudioProjects/MyCalendar-New-23-07-2026/app/src/main/java/com/example/mycalendar2026sar/ExpensesActivity.java)
- Initialize the `SearchView` in `onCreate`.
- Add a placeholder `OnQueryTextListener` to handle search inputs in the future.

## Verification Plan

### Automated Tests
- Build the project to ensure no layout or compilation errors.

### Manual Verification
- Open the Expenses screen.
- Verify that the search bar appears above the Daily/Weekly/Monthly buttons.
- Verify that the search bar is legible (white text on dark background).
- Verify that you can type into the search bar.
