import turtle as t
import random as r

t.shape("turtle")
t.pensize(5)
t.bgcolor("skyblue")
t.speed(20)
t.color('yellow', 'yellow')

t.begin_fill()

for x in range(100):
    t.forward(100 + x * 7)
    t.left(360 / 5 * 2)

t.end_fill()
t.exitonclick()
