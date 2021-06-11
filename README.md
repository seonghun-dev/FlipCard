# FLIP CARD
<div align="center">
  <br/>
  <img src="https://github.com/seonghun-dev/seonghun-dev.github.io/raw/main/images/FlipCard.png?raw=true"/>
  <img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/006.png?raw=true"/>
  <br/>
  <br/>
  <p>
    FLIP CARD <br>
  </p>
  </p>
</div>


## :mega: FLIP CARD란?

Flip Card는 4인용 카드 뒤집기 게임입니다. 주어진 시간 내에 더 많은 카드를 자신의 색으로 바꾸는 사용자가 승리합니다. 실시간으로 4명이 클라이언트가 서버에 접속하면 게임이 시작됩니다. 사용자가 들어오고 나갈경우 사용자 목록 창에 나타납니다. 추가적으로 채팅을 통해 게임 참여자 간 자유로운 의사소통이 가능하며, 서버와의 통신을 통해서 실시간 게임을 진행할 수 있습니다. 




## :mega: 영상보기

<div align="center">
  <br/>
  <a href="https://youtu.be/NTP5FgsMYXg"target="_blank"><img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/Flip%20Card%20youtube.png?raw=true" height="400" >
  <br/>
  <br/>
    <p>
    <a href="https://youtu.be/NTP5FgsMYXg"> FLIP CARD Youtube<br>
  </p>
  </p>
</div>



## :mega: 게임 시나리오
<div align="center">
  <br/>
  <img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/Flip%20Card%20in%20game.png?raw=true" height="400">
  <br/>
  <br/>
  </p>
</div>


1.사용자는 ID를 입력하여 서버에 로그인한다. 


2.로그인이 성공적으로 완료되었으면 ‘로그인이 완료되었습니다’ 창이 나타난다. 로그인이 실패된 경우(참가자가 이미 4명인 경우)에는 ‘로그인 실패’ 창이 나타난다.


3.로그인 후에는 게임 화면 창이 나타난다. 왼쪽에는 게임 시작 시 클릭해야 하는 카드들, 오른쪽에서는 참가자들의 명단, 타이머, 채팅창이 있다.명단에서는 로그인한 유저들의 아이디와 배정된 카드 색상들을 확인할 수 있다. 새로운 유저가 로그인하면 명단이 갱신되어 새로운 유저의 정보도 확인할 수 있다.채팅창에서는 다른 유저들과 채팅을 하거나, 서버로부터 메시지를 전달받을 수 있다.타이머는 계속 READY 상태이며, 게임이 시작되지 않은 이 상태에서는 카드를 클릭해도 아무런 변화가 없다.


4.참가자가 4명이 되면 채팅창에 ‘게임이 곧 시작합니다’라는 메시지가 보이고, 곧이어 타이머가 10초간 작동되며 게임이 시작한다. 이때부터 카드를 클릭하면 자신이 배정받은 색상으로 카드의 색이 바뀌고, 다른 유저들이 클릭하여 바꾼 카드들 또한 확인할 수 있다. 재빨리 카드를 클릭하여 더 많은 카드를 자신의 색상으로 바꿔야 한다.


5.제한 시간 10초가 지나 타이머가 0이 되면 서버로부터 온 결과 메시지 ‘(user) WIN!’를 채팅창에서 확인할 수 있고, 창이 하나 새로 나타난다. 새로운 창에서 게임을 이어할지, 나갈지를 선택할 수 있다.


6.나가기를 선택하면 게임 화면 창이 모두 닫히고, 이어하기를 선택하면 게임 화면 창으로 돌아간다. 명단에서 남아있는 유저들을 확인할 수 있다.


## :mega: 게임 흐름도


<div align="center">
  <br/>
  <img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/FlipCard%20flowchart.jpeg?raw=true/" height="500">
  <br/>
  <br/>
  <p>
    FLIP CARD 게임 흐름도 <br>
  </p>
  </p>
</div>



## :mega: 클래스 다이어그램


<div align="center">
  <br/>
  <img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/FlipCard%20class%20diagram.jpeg?raw=true">
  <br/>
  <br/>
  <p>
    FLIP CARD 클래스 다이어그램 <br>
  </p>
  </p>
</div>


## :mega: 전송 프로토콜


### 클라이언트 전송


#### FLIP;CARDNUM;COLOR


•	게임을 진행하는 동안, 클라이언트가 카드를 클릭할 경우 서버에게 전송하는 메세지다. 


•	이 메시지는 송신 클라이언트가 선택한 카드의 번호, 그리고 해당 클라이언트의 카드 색 정보를 포함한다. 


•	예를 들어, 카드 색이 초록색인 사용자가 9번 카드를 클릭했다면 “FLIP;9;GREEN” 메시지가 서버로 전달된다.  


•	서버가 이 메시지를 받으면, 서버는 게임 결과 계산을 위해 관리하고 있는 카드별 색상 정보를 갱신하고 해당 메시지를 전체 클라이언트를 대상으로 전달한다. 





#### RESTART


•	한 게임이 끝난 후, 게임 이어하기를 선택할 경우 서버에게 전송하는 메시지다.


•	사용자가 게임에 남아있다는 것을 알린다.







### 서버 전송


#### LOGIN;USERID;COLOR


•	새로운 사용자가 로그인했을 때 서버가 각 클라이언트에게 보내는 메시지다.


•	사용자 ID와 서버가 그 사용자에게 배정한 카드 색 정보를 보낸다. 


•	예를 들어, ID가 ‘a’인 사용자가 로그인을 했고 그 사용자에게 배정된 색상이 파란색이라면 “LOGIN;a;BLUE” 메시지가 기존 클라이언트들에게 전달된다. 


•	각 클라이언트들은 이 메시지를 받아 자신이 관리하는 사용자 정보 Userinfo를 갱신한다. 




#### READY


•	새로운 사용자가 로그인했을 때 서버가 각 클라이언트에게 보내는 메시지다.


•	사용자 ID와 서버가 그 사용자에게 배정한 카드 색 정보를 보낸다. 


•	예를 들어, ID가 ‘a’인 사용자가 로그인을 했고 그 사용자에게 배정된 색상이 파란색이라면 “LOGIN;a;BLUE” 메시지가 기존 클라이언트들에게 전달된다. 


•	각 클라이언트들은 이 메시지를 받아 자신이 관리하는 사용자 정보 Userinfo를 갱신한다. 


#### START


•	게임 시작을 알리는 메시지다.


•	서버가 전체 클라이언트에게 전송한다. 


•	클라이언트가 이 메시지를 받으면, 타이머를 “START”로 바꾸고 게임 화면을 초기화한다. 





#### TIMER;TIME


•	게임 진행 시간을 알려주는 메시지다. 


•	START 메시지 전송 후 서버는 10초 타이머를 작동한다. 그리고 1초가 지날 때마다 현재 시간을 전체 사용자에게 알려준다. 


•	따라서 게임 진행 동안, 서버는 “TIMER;10” ~ “TIMER;1” 총 열 개의 메시지를 전체 클라이언트에게 전달한다. 


•	클라이언트가 이 메시지를 받으면, 타이머 시간을 현재 시간으로 바꾼다.





#### FLIP;CARDNUM;COLOR


•	게임이 진행되는 동안, 카드 색상 변경에 관한 정보를 전달하는 메시지다. 


•	서버가 각 클라이언트로부터 이 메시지를 받으면, 다른 사용자에게 알리기 위해서 같은 메시지를 전체 클라이언트 대상으로 다시 전송한다.  


•	각 클라이언트가 이 메시지를 받으면, 메시지 정보를 확인하고 카드 색을 변경한다. 


•	실제 게임이 진행되는 동안 서버와 클라이언트가 가장 많이 주고 받는 메시지이다. 





#### STOP


•	게임 종료를 알리는 메시지다.


•	타이머가 0초가 되면 이 메시지를 전체 클라이언트 대상으로 전달한다. 


•	클라이언트가 이 메시지를 받으면 게임 화면을 초기화하고 더 이상 카드를 클릭할 수 없도록 설정을 변경한다. 




#### WIN;USERID;COLOR


•	게임 결과를 전달하는 메시지이다. 


•	게임 종료 시 서버는 게임 결과 계산을 위해 관리하고 있던 카드 별 색상 정보를 순차적으로 확인하고, 결과를 취합하여 우승한 사용자가 누구인지 계산한다. 그 후 이 정보를 모든 클라이언트에게 전달한다. 


•	공동 우승자가 있을 경우 메시지를 여러 번 전송한다. 


•	클라이언트가 이 메시지를 받으면 채팅창에 우승자를 알려준다. 







