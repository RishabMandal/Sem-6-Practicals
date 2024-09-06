male(rishab).
female(angel).
male(omkar).
female(alice).
male(bob).

parent(omkar, bob).
parent(alice, bob).

father(X, Y):- male(X),parent(X,Y).
mother(X,Y) :- female(X), parent(X,Y).
spouse(X,Y) :- parent(X,Z),parent(Y,Z),X\=Y.
