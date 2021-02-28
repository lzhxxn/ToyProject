import random as ran
import os
import threading
from time import sleep

# 기본 셋팅
def Setting():
    f = open("original.txt", "r")
    s = set()
    while True: ## txt > Set (중복제거)
        line = f.readline()
        if not line: break
        line = line.strip()
        s.add(line)
    f.close()
    li = [] ## Set > List (필터링))
    for x in s:
        li.append(x)
    f = open("QuizList.txt", 'w') ## List > txt (필터링 된 파일 저장)
    for item in li:
        f.write(item+'\n')
    f.close()

# 게임 시작 
def StartGame():
    print("* 팀 번호를 입력하세요.")
    fname = input() 
    print("퀴즈 게임을 시작합니다.")
    revivalGame(fname)

# 게임 반복 (왜 안되는가)
def revivalGame(fname):
    f = open("QuizList.txt", 'r')
    line = []
    Rightnum = 0
    QuizNum = 1
    while True: ## txt > List (문제리스트)
        li = f.readline()
        if not li: break
        li = li.strip()
        line.append(li+'\n')
    f.close()
    #start() thread 필요?

    for x in range(10):
        quiz(QuizNum,line,Rightnum)

    record = open(fname + ".txt","xt")
    record.write(str(Rightnum))
    print(fname+"팀, 맞은 개수 : "+str(Rightnum))

def quiz(QuizNum,line,Rightnum):
    ranQuizNum = ran.randint(0,len(line))
    print(str(QuizNum)+"번째 문제 : "+line[ranQuizNum])
    ox = input()
    if ox == ("o"or"O"): 
        Rightnum += 1
        QuizNum += 1
        line.pop(ranQuizNum)
#ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡmain
Setting()
if os.path.isfile("QuizList.txt"):
    StartGame()