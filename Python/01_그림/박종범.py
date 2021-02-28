import turtle as t
    
t.shape("turtle")

n =100
t.bgcolor("black")
t.color("hotpink")
t.speed(0.5)
t.color("grey")
for x in range(n):
    t.circle(90)
    t.left(360/n)
for x in range(n):
    t.circle(100)
    t.left(360/n)
t.color("red")
for x in range(n):
    t.circle(95)
    t.left(360/n)
t.color("blue")
for x in range(n):
    t.circle(90)
    t.left(360/n)
t.color("white")
for x in range(n):
    t.circle(85)
    t.left(360/n)
t.color("pink")
for x in range(n):
    t.circle(85)
    t.left(360/n)
t.color("skyblue")
for x in range(n):
    t.circle(85)
    t.left(360/n)
t.exitonclick()
