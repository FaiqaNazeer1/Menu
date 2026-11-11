## 1. Serialization

- Serialization is a process of converting an object into a format that can be stored or transferred.
- It is used to pass object data between activities or save data.
- In Android, Java provides the `Serializable` interface.
- Example: Passing a Student object from one Activity to another.

## 2. Parcelable

- Parcelable is an Android-specific interface used to pass objects between activities.
- It converts objects into a format that Android can transfer efficiently.
- It is generally faster than Serializable in Android.
- Example: Passing student details from MainActivity to SecondActivity.

## 3. Floating Menu

- A Floating Menu is a menu that appears as a floating button or panel on the screen.
- It provides quick access to important actions.
- It can be opened by clicking a floating action button (FAB).
- Example: A floating button used to add a new contact or create a message.

## 4. Popup Menu

- A Popup Menu displays a small menu attached to a particular view.
- It appears when the user clicks a button or another view.
- It provides a list of actions related to that view.
- Example: Edit, Delete, and Share options.

## 5. Context Menu

- A Context Menu appears when the user performs a long press on a view.
- It displays actions related to the selected item.
- It helps users perform specific operations quickly.
- Example: Long-pressing a message to see Copy, Delete, and Forward options.

## Quick Comparison

| Type          | Main Purpose                                                 |
| ------------- | ------------------------------------------------------------ |
| Serialization | Converts objects into a transferable or storable format.     |
| Parcelable    | Transfers objects efficiently in Android.                    |
| Floating Menu | Provides quick access to actions through a floating control. |
| Popup Menu    | Shows a small menu attached to a view.                       |
| Context Menu  | Shows options after long-pressing a view.                    |

Important exam points:

- Serializable = Java interface.
- Parcelable = Android interface.
- Popup Menu = Usually opened by clicking.
- Context Menu = Usually opened by long-pressing.
- Floating Menu = Quick access to frequently used actions.
