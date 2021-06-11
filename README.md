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
  <a href="https://youtu.be/NTP5FgsMYXg"><img src="https://github.com/seonghun-dev/seonghun-dev.github.io/blob/main/images/Flip%20Card%20youtube.png?raw=true" height="400">
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



