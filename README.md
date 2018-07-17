http://exercism.io/exercises/java/bowling/readme

#Bowling
Score a bowling game.

Bowling is a game where players roll a heavy ball to knock down pins arranged in a triangle. Write code to keep track of the score of a game of bowling.

##Scoring Bowling
The game consists of 10 frames. A frame is composed of one or two ball throws with 10 pins standing at frame initialization. There are three cases for the tabulation of a frame.

- An open frame is where a score of less than 10 is recorded for the frame. In this case the score for the frame is the number of pins knocked down.

- A spare is where all ten pins are knocked down by the second throw. The total value of a spare is 10 plus the number of pins knocked down in their next throw.

- A strike is where all ten pins are knocked down by the first throw. The total value of a strike is 10 plus the number of pins knocked down in the next two throws. If a strike is immediately followed by a second strike, then the value of the first strike cannot be determined until the ball is thrown one more time.

Here is a three frame example:

Frame 1	Frame 2	Frame 3
X (strike)	5/ (spare)	9 0 (open frame)
Frame 1 is (10 + 5 + 5) = 20

Frame 2 is (5 + 5 + 9) = 19

Frame 3 is (9 + 0) = 9

This means the current running total is 48.

The tenth frame in the game is a special case. If someone throws a strike or a spare then they get a fill ball. Fill balls exist to calculate the total of the 10th frame. Scoring a strike or spare on the fill ball does not give the player more fill balls. The total value of the 10th frame is the total number of pins knocked down.

For a tenth frame of X1/ (strike and a spare), the total value is 20.

For a tenth frame of XXX (three strikes), the total value is 30.

##Suggested Test Cases
  (When scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)
  - X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
  - 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
  - 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150

###Requirements
Write code to keep track of the score of a game of bowling. It should support two operations:

- roll(pins : int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
- score() : int is called only at the very end of the game. It returns the total score for that game.