preparation

- sound
- Emacs left, Simulator right
- boot dev
- run-packager
- run-ios
- open logging console

DEMO

PART 1: styling

- board
- cell
- 1 row
  - don't forget keys
- 3 rows
  - don't forget keys
- deref state (must be a ratom!)
  - don't forget doall
- add touchable opacity to cell (no view necessary)
  - add on-press handler

PART 2: state

- state inspector widget
- refactor: move fn: operates on state
  - only move if field is empty
- add "try again" button
  - just reset to nil
  - explain how styles work

PART 3: logic

- color cell red
- did one of the players win?
  - a "position" is a set of pairs
  - copy over set of wins
  - (position board player) -- returns set of all pairs of that player
  - (winning board player) -- returns a winning position or nil otherwise (intersection)
  - for both players
- if cell coordinates are member of winning position, show them red

BONUS FEATURE

- NOT SO FAST... increase size to 4!

LESSONS


todo

- checklist 
- 
