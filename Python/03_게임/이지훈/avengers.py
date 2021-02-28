import turtle as t
import random
import time 

s = t.Screen()
s.setup(800 ,600) #배경사이즈
s.bgpic('end.gif')
s.update()
score = 0

cap = "cap0.gif"
tanos = "tan0.gif"
gun = "Yumin.gif"
spi = "spi0.gif"
hulk = "hulk0.gif"
black = "black0.gif"
thor = "thor0.gif"
doctor = "doctor.gif"
vision = "vis.gif"

s.addshape(cap)
s.addshape(tanos)
s.addshape(gun)
s.addshape(spi)
s.addshape(hulk)
s.addshape(black)
s.addshape(thor)
s.addshape(doctor)
s.addshape(vision)



def r(): t.setheading(0)
def u(): t.setheading(90)
def l(): t.setheading(180)
def d(): t.setheading(270)

def play():
    global score
    global text
    t.forward(20)
    ca.forward(7)
    sp.forward(7)
    hu.forward(7)
    bl.forward(7)
    th.forward(7)
    dc.forward(7)
    vi.forward(7)

    angle = ca.towards(t.pos())
    angle2 = sp.towards(t.pos())
    angle3 = hu.towards(t.pos())
    angle4 = bl.towards(t.pos())
    angle5 = th.towards(t.pos())
    angle6 = dc.towards(t.pos())
    angle7 = vi.towards(t.pos())
    ca.setheading(angle)
    sp.setheading(angle2)
    hu.setheading(angle3) 
    bl.setheading(angle4)
    th.setheading(angle5)
    dc.setheading(angle6)
    vi.setheading(angle7)


    if t.distance(gu) < 12:
        gux = random.randint(-230, 230)
        guy = random.randint(-230, 230)
        gu.goto(gux, guy)
        score = score + 1
        t.color("white")
        t.write(str(score)+"개!",False,font=("Arials ",10, "bold"))
        
    if (t.distance(ca) < 12) | (t.distance(sp) < 12) | (t.distance(hu) < 12) | (t.distance(bl) < 12) | (t.distance(th) < 12) | (t.distance(dc) < 12) | (t.distance(vi) < 12):
        text = '점수: '+ str(score)+'점'
        message('Game Over',text)
        score = 0
    else:
        t.ontimer(play, 100)

    
    speed = score + 5 # 점수에 5를 더해서 속도 올림
    if speed > 15: # 속도가 15 넘지 않게
        speed = 15
        ca.forward(speed)
        sp.forward(speed)
        hu.forward(speed)
        bl.forward(speed)
        th.forward(speed)
        dc.forward(speed)

def message(m1,m2):
    t.clear()
    t.goto(0,130)
    t.write(m1,False,'center',('',20))
    t.goto(0,-150)
    t.write(m2,False,'center',('',15))
    t.home()

ca = t.Turtle() # 캡틴
ca.shape(cap)
ca.speed(0)
ca.up()
ca.goto(0, 200)

gu = t.Turtle() # 건틀렛
gu.shape(gun)
gu.speed(0)
gu.up()
gu.goto(0, -200)

sp = t.Turtle() # 스파이더맨 
sp.shape(spi)
sp.speed(10)
sp.up()
sp.goto(150, 200)

hu = t.Turtle() # 헐크
hu.shape(hulk)
hu.speed(0)
hu.up()
hu.goto(-150, 200)

bl = t.Turtle() # 블랙
bl.shape(black)
bl.speed(0)
bl.up()
bl.goto(300, 200)

th = t.Turtle() # 토르
th.shape(thor)
th.speed(0)
th.up()
th.goto(-300, 200)

dc = t.Turtle() # 닥터
dc.shape(doctor)
dc.speed(0)
dc.up()
dc.goto(100, 100)

vi = t.Turtle() # 비전
vi.shape(vision)
vi.speed(0)
vi.up()
vi.goto(-100, 100)

t.shape(tanos) # 타노스
t.speed(0)
t.up()
t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")
t.listen()

t.onkeypress(play, "space")

message('게임 시작 ! ','[Spacebar]')
time.sleep(1)
t.clear()
t.mainloop()
