import os
import random
import time
def m1():
    #print(s) 1.1 set에 저장(중복제거)
    fname = "original.txt"
    f = open(fname, "r")
    s = set()
    while True:
        line = f.readline()
        if not line: break
        s.add(line)
    f.close()

    # original.bak 생성, f>>fb, os.remove
    fbname = "original.bak"
    if os.path.exists(fbname):
        pass
    else:
        fb = open(fbname, "xt");fb.close()

    fb = open(fbname, "w")
    f = open(fname, "r")
    fb.write(f.read())
    f.close(); fb.close()
    os.remove(fname)

    # 중복제거 내용을 filtered.txt에 저장
    ffname = "filtered.txt"
    ff = open(ffname, "xt"); ff.close()
    ff = open(ffname, "w")
    for x in s:
        ff.write(x) # 띄어쓰기없이 입력된다 >> 처음에 set에 저장할 때, strip()을 하면 \n까지 없어져서 한 줄로 입력된다!!!
        
    ff.close()
    #######################

li = list()
def m2():
    # filtered.txt 에서 읽어서 list에 저장한다.
    fname = "filtered.txt"
    f = open(fname, "r")
    

    while True:
        line = f.readline()
        if not line: break
        line = line.strip()
        li.append(line)
    f.close()  #print(li) >> 여기서는 파일에 저장할것이 아니므로, strip()해줌
    
def m3():
    score = 0
    #랜덤 숫자 뽑기>> 그 인덱스에 해당하는 문제 제거
    start = time.time()
    while True:
        end = time.time()
        timer = end - start
        
        if timer > 5:
            print("시간종료"); break   # 이게 마지막문제는 버저비터가 되버림
        
        if len(li) == 0: print("문제가 떨어짐");break
        q = random.randint(0,len(li)-1) #print(len(li))
        print(li[q])                  #; print(q)+
        
        if timer > 4.9 and timer < 5:
            print("버저비터")
        
        #맞추면 o 입력, 아무키는 패스, 한게임의 스코어 기록 >> 제한시간동안 반복
        line = input("맞추면 \"o\" 를 입력하세요(pass==anykey): ")
        line = line.strip()
        
        if line == "o" or line == "O":
            del li[q]
            score += 1
            
    ## 맞춘 문제가 제거된 list를 저장 >> filtered.txt
    fname = "filtered.txt"
    ff = open(fname, "w")
    for x in li:
        ff.write(x+"\n")
    ff.close()
    if not os.path.exists("score"):
        os.mkdir("score")

    ftname = str(teamNum)
    if not os.path.exists("score\\"+ftname+".txt"):
        fscore = open("score\\"+ftname+".txt","xt"); fscore.close()

    fscore = open("score\\"+ftname+".txt","a")
    fscore.write(str(1)+"\n")
    fscore.close()

m1()
m2()
teamNum = input("#팀번호: ")
m3()



