preparation

- sound
- two window console
- boot dev
- run-packager
- run-ios
- open logging console

plan

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
- move fn: operates on state
  - only move if field is empty
- add "try again" button
  - just reset to nil
- color fields red
- did one of the players win?
  - a "position" is a set of pairs
  - copy over set of winning positions
  - (position board player) -- returns set of all pairs of that player
  - (winning board player) -- returns a winning position or nil otherwise (intersection)
