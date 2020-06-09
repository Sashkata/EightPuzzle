#EightPuzzle
A solver for the eight puzzle using a few different algorithms
―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――

##Description 

**This project is to attempt to make a 
solver for a variant of the Eight Puzzle
using: **
- *Breadth-First Search*
- *Depth-First Search*
- *Uniform-Cost Search*
- *Best-First Search (h = # of tiles in the wrong position)*
- *A\* (h = # of tiles in the wrong position)*
- *A\* (h = sum of manhattan distances of all tiles)*


##Rules/Info About Game  

 * The [0] is the hole/reference so when making a left move
   [ 7, 0, 5] -> [ 0, 7, 5]

 * Each move has a cost associated to it of 1
 
 * There is repeated state checking
 
 * The ends are bounded 
   (making a left move when [0] is on the left wont do anything)

 * Winning State
   [ 1, 2, 3 ]
   [ 8, 0, 4 ]
   [ 7, 6, 5 ]


## base difficulties

―――Easy―――
[ 1, 3, 4 ]
[ 8, 6, 2 ]
[ 7, 0, 5 ]

―――Medium―――
[ 2, 8, 1 ]
[ 0, 4, 3 ]
[ 7, 6, 5 ]

―――Hard―――
[ 5, 6, 7 ]
[ 4, 0, 8 ]
[ 3, 2, 1 ]

