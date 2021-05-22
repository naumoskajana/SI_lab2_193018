# SI_lab2_193018
Јана Наумоска -193018 <br><br>
<b>Control Flow Graph</b><br>
![](https://github.com/naumoskajana/SI_lab2_193018/blob/master/ControlFlowGraph.PNG) <br>
<b>Цикломатска комплексност - V(G)=8</b> <br>
Control Flow графот содржи 30 рабови и 24 јазли. <br>
Преку бројот на рабови (Е) и бројот на јазли (N) во графот имаме V(G)=30-24+2=8 <br>
Преку бројот на предикатни јазли (P) во графот имаме V(G)=7+1=8 <br><br>
<b>Multiple Condition тест случаи</b><br>
1. if (hr < 0 || hr > 24) <br>
| Combination | Test case |
| ----------- | --------- |
| T||X | (-3, 30, 30) |
| F||T | (25, 30, 50) |
| F||F | (5, 10, 12) |
<br>
2. if (min < 0 || min > 59) <br>
| Combination | Test case |
| ----------- | --------- |
| T||X | (10, 60, 12) |
| F||T | (20, 65, 30) |
| F||F | (5, 10, 12)* |
