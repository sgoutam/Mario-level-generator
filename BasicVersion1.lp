
#const width=100.
#const height=4.

#const minBrickCoin=1.
#const maxBrickCoin=3.
#const minPowerup=1.
#const maxPowerup=2.
#const minRandomCoin=1.
#const maxRandomCoin=2.
#const minBricks=1.
#const maxBricks=2.
#const minGoomba=2.
#const maxGoomba=6.
#const minKoopa=1.
#const maxKoopa=3.
#const minJump=1.
#const maxJump=2.
#const minPipe=3.
#const maxPipe=6.

#const ending1=97.
#const ending2=96.
#const ending3=94.

#const beginning=5.

dimY(0..height-1).
dimX(0..width-1).

tile(0). %air
tile(1). %ground
tile(2). %coin block pattern 1
tile(4). %coin block pattern 3
tile(5). %coin pattern 1
tile(6). %coin pattern 2
tile(7). %coin pattern 3
tile(8). %block pattern 1
tile(9). %block pattern 2
tile(10). %block pattern 3
tile(11). %block pattern 4
tile(12). %pipe
tile(13). %goomba
tile(14). %koopa
tile(15). %jump size 2
tile(16). %jump size 3
tile(17). %jump size 5
tile(20). %powerup


1{at(X,Y,T) : tile(T)}1 :-  dimX(X), dimY(Y).	

type(T) :- at(_,_,T).

result(T, S) :- S = #count{X,Y :at(X,Y,T)}, type(T).


:- result(0,S), S>280. 

:- result(1,S), S>97.

:- result(20,S), S<minPowerup.

:- result(20,S), S>maxPowerup.

:- result(2,A), A< minBrickCoin.

:- result(4,A), A< minBrickCoin.

:- result(2,A), A> maxBrickCoin.

:- result(4,A), A> maxBrickCoin.

:- result(5,A), A< minRandomCoin.

:- result(6,A), A< minRandomCoin.

:- result(7,A), A< minRandomCoin.

:- result(5,A), A> maxRandomCoin.

:- result(6,A), A> maxRandomCoin.

:- result(7,A), A> maxRandomCoin.

:- result(8,A), A< minBricks.

:- result(9,A), A< minBricks.

:- result(10,A), A< minBricks.

:- result(11,A), A< minBricks.

:- result(8,A), A> maxBricks.

:- result(9,A), A> maxBricks.

:- result(10,A), A> maxBricks.

:- result(11,A), A> maxBricks.

:- result(12,A), A< minPipe.

:- result(12,A), A> maxPipe.

:- result(13,A), A< minGoomba.

:- result(13,A), A> maxGoomba.

:- result(14,A), A< minKoopa.

:- result(14,A), A> maxKoopa.

:- result(15,A), A< minJump.

:- result(16,A), A< minJump.

:- result(17,A), A< minJump.

:- result(15,A), A> maxJump.

:- result(16,A), A> maxJump.

:- result(17,A), A> maxJump.


:- at(_, 0, 0).  
:- at(_, 0, 2).
:- at(_, 0, 3).
:- at(_, 0, 4).	
:- at(_, 0, 5).
:- at(_, 0, 6).  
:- at(_, 0, 7).
:- at(_, 0, 8).
:- at(_, 0, 9).	
:- at(_, 0, 10).
:- at(_, 0, 11).
:- at(_, 0, 12).
:- at(_, 0, 13).
:- at(_, 0, 14).
:- at(_, 0, 20).


:- at(_, 1, 1).
:- at(_, 2, 1).
:- at(_, 3, 1).


:- at(_, 1, 15).
:- at(_, 2, 15).
:- at(_, 3, 15).

:- at(_, 1, 16).
:- at(_, 2, 16).
:- at(_, 3, 16).

:- at(_, 1, 17).
:- at(_, 2, 17).
:- at(_, 3, 17).

:- at(_, 3, 12).

:- at(X, _, 12), at(X, 0, 15).
:- at(X, _, 12), at(X-1, 0, 15).

:- at(X, _, 12), at(X, 0, 16).
:- at(X, _, 12), at(X-1, 0, 16).
:- at(X, _, 12), at(X-2, 0, 16).
:- at(X, _, 12), at(X+1, 0, 16).
:- at(X, _, 12), at(X+2, 0, 16).

:- at(X, _, 12), at(X, 0, 17).
:- at(X, _, 12), at(X-1, 0, 17).
:- at(X, _, 12), at(X-2, 0, 17).
:- at(X, _, 12), at(X-3, 0, 17).
:- at(X, _, 12), at(X-4, 0, 17).
:- at(X, _, 12), at(X-5, 0, 17).
:- at(X, _, 12), at(X+1, 0, 17).
:- at(X, _, 12), at(X+2, 0, 17).
:- at(X, _, 12), at(X+3, 0, 17).
:- at(X, _, 12), at(X+4, 0, 17).
:- at(X, _, 12), at(X+5, 0, 17).

:- at(X, 0, 15), at(X+1, 0, 15).
:- at(X, 0, 15), at(X+1, 0, 16).
:- at(X, 0, 15), at(X+1, 0, 17).

:- at(X, 0, 15), at(X+2, 0, 15).
:- at(X, 0, 15), at(X+2, 0, 16).
:- at(X, 0, 15), at(X+2, 0, 17).

:- at(X, 0, 16), at(X+1, 0, 15).
:- at(X, 0, 16), at(X+1, 0, 16).
:- at(X, 0, 16), at(X+1, 0, 17).

:- at(X, 0, 16), at(X+2, 0, 15).
:- at(X, 0, 16), at(X+2, 0, 16).
:- at(X, 0, 16), at(X+2, 0, 17).

:- at(X, 0, 16), at(X+3, 0, 15).
:- at(X, 0, 16), at(X+3, 0, 16).
:- at(X, 0, 16), at(X+3, 0, 17).

:- at(X, 0, 17), at(X+1, 0, 15).
:- at(X, 0, 17), at(X+1, 0, 16).
:- at(X, 0, 17), at(X+1, 0, 17).

:- at(X, 0, 17), at(X+2, 0, 15).
:- at(X, 0, 17), at(X+2, 0, 16).
:- at(X, 0, 17), at(X+2, 0, 17).

:- at(X, 0, 17), at(X+3, 0, 15).
:- at(X, 0, 17), at(X+3, 0, 16).
:- at(X, 0, 17), at(X+3, 0, 17).

:- at(X, 0, 17), at(X+4, 0, 15).
:- at(X, 0, 17), at(X+4, 0, 16).
:- at(X, 0, 17), at(X+4, 0, 17).

:- at(X, 0, 17), at(X+5, 0, 15).
:- at(X, 0, 17), at(X+5, 0, 16).
:- at(X, 0, 17), at(X+5, 0, 17).

:- at(X, 0, 15), X<beginning.
:- at(X, 0, 16), X<beginning.
:- at(X, 0, 17), X<beginning.

:- at(X, 0, 15), X>ending1.
:- at(X, 0, 16), X>ending2.
:- at(X, 0, 17), X>ending3.

#show at/3.
