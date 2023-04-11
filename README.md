# SpringbootStudy
Springboot Study

참고자료: 스프링 부트와 AWS로 혼자 구현하는 웹서비스

TDD
  - 테스트 기반 개발
  - Read, Green, Refactor

Web Layer
  - 컨트롤러, JSP 등의 뷰 템플릿 영역
  - 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 영역

Service Layer
  - 서비스 영역
  - Controller와 Dao의 중간 영역
  - @Service, @Transacational
  - 트랜잭션과 도메인간의 순서 보장 

Repository Layer
  - 데이터베이스와 같은 데이터 저장소 접근 영역
  - Dao(Data Access Object) 영역

DTOs
  - Dto(Data transfer object) 계층간의 데이터 교환을 위한 객체들의 영역
  - 뷰 템플릿 엔진에서 사용될 객체, Repository Layer에서 결과로 넘겨준 객체

Domain Model
  - @Entity, VO
  - 개발 대상을 사람들이 이해할 수 있도록 단순화 시킨것

템플릿 엔진
  - 지정된 템플릿 양식 + 데이터 하여 HTML 문서를 출력하는 소프트웨어
  - 서버 템플릿 엔진(JSP, Freemarker), 클라이언트 템플릿 엔진(Vue.js, React.js)

HTML, CSS
  - 페이지 로딩속도를 높이기 위해 css는 header에 js는 footer에 작성한다

QueryDSL
  - 타입의 안정성이 보장
  - 래퍼런스가 많음

스프링 시큐리티(Spring Security)
  - 인증(Authentication)과 인가(Authorization) 기능을 가진 프레임워크
  






