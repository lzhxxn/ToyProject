import turtle as t
import time
import random as r
import threading as th
# 다시 내려오게 하기

# t.setup(500,700)
# pic3=r"winter.gif"
# t.bgpic(pic3)
def r(): t.setheading(0)
def l(): t.setheading(180)
def s(): t.clear(); t.goto(0,-200); play()

def message(m1):
    t.clear()
    t.goto(0,130)
    t.write(m1,move=False, align='center', font=("Arial",25,"bold","underline"))
    t.home()

def showLogo1():
    bp = t.Screen()
    bp.setup(500, 700)
    bp.bgpic("winter.gif")

def game_over_text():
    x = (t.window_width() / 2) - 300
    y = (t.window_height() / 2) - 150
    t.setpos((x+50), y)
    t.write("Game Over", move=False, align='center', font=("Arial",30,"bold","underline"))
    t.hideturtle()
    te1.hideturtle()
    te2.hideturtle()
    te3.hideturtle()
    te4.hideturtle()
    te5.hideturtle()
    te6.hideturtle()

def play():
    t.forward(30)
    te1.setheading(270)
    te1.forward(30)
    te2.setheading(270)
    te2.forward(40)
    te3.setheading(270)
    te3.forward(50)
    te4.setheading(270)
    te4.forward(20)
    te5.setheading(270)
    te5.forward(40)
    te6.setheading(270)
    te6.forward(30)
    if te1.ycor()==(-300):
        te1.sety(400)
    if te2.ycor()==(-400):
        te2.sety(400)
    if te3.ycor()==(-300):
        te3.sety(400)
    if te4.ycor()==(-300):
        te4.sety(400)
    if te5.ycor()==(-400):
        te5.sety(400)
    if te6.ycor()==(-300):
        te6.sety()(400)

    if t.distance(te1) >= 50 and t.distance(te2) >= 50 and t.distance(te3) >= 50 and t.distance(te4) >= 50 and t.distance(te5) >= 50 and t.distance(te6) >= 50:
        t.ontimer(play, 100)
    else:
        game_over_text()


pic2 = r"gift.gif"
t.addshape(pic2)
te1 = t.Turtle() 
te1.turtlesize(4,4,4)
te1.shape(pic2)
te1.speed(0)
te1.up()
te1.goto(-230, 400)

te2 = t.Turtle() #적 
te2.turtlesize(4,4,4)
te2.shape(pic2)
te2.speed(0)
te2.up()
te2.goto(-150, 400)

te3 = t.Turtle()
te3.turtlesize(4,4,4)
te3.shape(pic2)
te3.speed(0)
te3.up()
te3.goto(-70, 400)

te4 = t.Turtle() 
te4.turtlesize(4,4,4)
te4.shape(pic2)
te4.speed(0)
te4.up()
te4.goto(55, 400)

te5 = t.Turtle() 
te5.turtlesize(4,4,4)
te5.shape(pic2)
te5.speed(0)
te5.up()
te5.goto(130, 400)

te6 = t.Turtle() 
te6.turtlesize(4,4,4)
te6.shape(pic2)
te6.speed(0)
te6.up()
te6.goto(200, 400)

pic1 = r"rudolf1.gif"
t.addshape(pic1)
t.bgcolor("darkgreen")
t.shape(pic1)
t.turtlesize(4,4,4)
t.color("white")
t.up()
t.goto(0,-200)
t.speed(0)
t.onkeypress(r, "Right")
t.onkeypress(l, "Left")
t.onkeypress(s, "space")
t.listen()

showLogo1()
message('Space Bar to Start')


t.mainloop()

