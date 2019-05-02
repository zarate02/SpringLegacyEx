# 스프링 Legacy 로 서버 만들기

## 1. 왜 Legacy를 사용하는가?

스프링 부트가 나온지 5년이 지난 지금에도 아직도 전자정부프레임워크는 Legacy형태를 취하고있다.<br>
그 이유는 무엇일까?<br>
스프링 부트는 MSA의 형태로 기존의 스프링과는 완전히 다른 방식으로 구축해야한다.<br>
이 방법에는 아직까지 많은 의문부호가 붙고 실제로 문제도 존재한다, 고로 시스템의 규모나 업무의 정도에따라 여전히 Legacy가 필요한 영역이 존재한다<br>
또한 기존에 짜여진 프로그램들은 Legacy형태이기때문에 유지보수를 위해서라도 사용법을 익혀야한다<br>

## 2. 스프링 Legacy의 문제점

일차적을로 스프링 공식툴에서 지원이 끊겼다.<br>
신규 프로젝트를 만들수 조차없기때문에 STS 3.X 버전을 사용해야 새로운 프로젝트 작성이 가능하다.<br>
스프링 공식 레퍼런스들이 모두 boot형태로 나오는것 또한 문제이다, 새로운 기술적용이 쉽지않다.<br>

## 3. 빠르게 스프링 Legacy 시작하기

### 1) 사전준비물
개발툴 : SpringToolSuite 이클립스 STS 3.x (https://spring.io/tools3)<br>
자바 : Version 8이상 (https://jdk.java.net/java-se-ri/8)<br>

### 2) 프로젝트 git에서 내려받기
신규 프로젝트 생성이 가능하지만 일단은 빠르게 스프링 Legacy를 시작하기위해 Git에서 소스를 내려받는다.<br>
1. File>import 을 선택한다
2. project from git 을 선택하고 Next를 누른다
3. Clone url을 선택하고 Next를 누른다
4. 아래와 같이 입력하고 Next를 누른다.
- URI : https://github.com/zarate02/SpringLegacyEx
- Host : github.com
- Repository path : /zarate02/SpringLegacyEx
- protocol : https
5. branch Select를 master로 택하고 Next를 누른다
6. 경로를 선택하고 프로젝트 생성을 완료한다

## 4. 각종 설정 설명

1. WEB.xml : https://github.com/zarate02/SpringLegacyEx/blob/master/src/main/webapp/WEB-INF/web.xml
2. Context : https://github.com/zarate02/SpringLegacyEx/tree/master/src/main/webapp/WEB-INF/spring
3. 기본 Controller : https://github.com/zarate02/SpringLegacyEx/blob/master/src/main/java/com/winitech/test/TestJsonContorller.java
4. SQL Mapper : https://github.com/zarate02/SpringLegacyEx/tree/master/src/main/resources/SQL
5. Log : https://github.com/zarate02/SpringLegacyEx/blob/master/src/main/resources/logback.xml
