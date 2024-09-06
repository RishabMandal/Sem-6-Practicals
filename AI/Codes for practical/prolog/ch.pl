male(rishab).
male(omkar).
male(harry).
male(bob).
male(mahesh).
female(alice).
female(angel).
female(kavya).

parent(rishab,harry).
parent(rishab,alice).
parent(angel,harry).
parent(angel ,alice).
parent(omkar, bob).
parent(kavya, bob).
parent(alice,mahesh).
parent(bob, mahesh).

% rules
father(X,Y):-male(X),parent(X,Y).
