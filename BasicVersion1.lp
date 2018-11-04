
#const width=100.
#const height=5.
#const minSpecial=20.
#const maxSpecial=25.
#const minBrickCoin=4.
#const maxBrickCoin=8.
#const minPowerup=0.
#const maxPowerup=2.
#const minRandomCoin=15.
#const maxRandomCoin=20.
#const maxBricks=15.
#const minBricks=10.

dimY(0..height-1).
dimX(0..width-1).

tile(0).
tile(1).
tile(2).
tile(3).
tile(4).
tile(5).
tile(6).

at(X,Y,T) : tile(T) :-  dimX(X), dimY(Y).	

getType(X,Y,T):- at(X,Y,T).

type(T) :- at(_,_,T).

result(T, S) :- S = #count{X,Y :getType(X,Y,T)}, type(T).

:- result(0,S), S>360.

:- result(2,S), S>minBricks.

:- result(2,S), S>maxBricks.

:- result(3,S), S<minBrickCoin.

:- result(3,S), S>maxBrickCoin.

:- result(4,S), S<minPowerup.

:- result(4,S), S>maxPowerup.

:- result(5,S), S<minRandomCoin.

:- result(5,S), S>maxRandomCoin.


:- at(_, 0, 0).  
:- at(_, 0, 2).
:- at(_, 0, 3).
:- at(_, 0, 4).	
:- at(_, 0, 5).
:- at(_, 0, 6).

:- at(_, 1, 1).
:- at(_, 2, 1).
:- at(_, 3, 1).
:- at(_, 4, 1).

:- at(_, 1, 6).
:- at(_, 2, 6).
:- at(_, 3, 6).
:- at(_, 4, 6).

#show at/3.