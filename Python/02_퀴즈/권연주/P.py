import random
import os
fname = "original.txt"
f = open(fname, "r")
s= set()
ql = list() #형변환
score = 0
i=0
filtered = "Filtered.txt"

# 오리지날 > set > filtered.txt
def readOri():
    while True:
        line = f.readline()
        if not line: break
        line = line.strip()
        s.add(line)
    saveStartFile()
    f.close()
    os.rename("original.txt","original.bak")


def saveStartFile():
    fw=open("Filtered.txt","wt")
    for x in s:
        fw.write(x+"\n")
    fw.close()


def inputTeamNum():
    global tn
    tns=input("팀 넘버:",)
    tn=int(tns)
    print(tn)

#set - list 인덱스 뽑아서 문제 뽑기    >>>>if문 채우기 1.정답을 맞추면 리무브 / 2.스코어올리기 / 
def showQ():
    global score
    fw=open("Filtered.txt","rt")
    fwl= fw.readlines()
    for x in fwl:
        ql.append(x)
    fw.close()
    while True:
        for q in ql:
            q=random.choice(ql)
            print(q)
            a=input()
            if a=="o":
                ql.remove(q)
                score += 1
                if score == 10:
                    print("점수:" + str(score))
                    if not os.path.exists("score"):
                        os.mkdir("score")
                    else:
                        pass
                    fs=open("score\\"+str(tn)+"team.txt","at")
                    fs.write(str(score)+"\n")
                    fs.close()
                    return


#info.txt파일 만들기 -> 리스트를 다시 




readOri()
inputTeamNum()
showQ()

