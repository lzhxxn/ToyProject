import turtle as t 
t.bgcolor('gray')
t.pensize(10)

def curve():
    for i in range(200):
        t.right(1)
        t.forward(1)

t.speed(0)
t.color('lightpink','pink')

t.begin_fill()
t.left(140)
t.forward(111.65)
curve()

t.left(120)
curve()
t.forward(111.65)
t.end_fill()
t.hideturtle()
t.exitonclick()
