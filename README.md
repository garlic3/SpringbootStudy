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

세션 동기화
  - WAS 메모리에 저장
  - 내장 톰캣 사용시 실행될때마다 초기화
  - (1) 톰캣 세션 사용 : 2개 이상 WAS 사용시 세션 공유 설정 필요
  - (2) 데이터베이스 세션 저장소로 사용: DB IO 발생 가능성, 백오피스, 사내 시스템 용도에 적합
  - (3) Redis, Memcached 메모리 DB 세션 저장소로 사용: 실제 서비스시 외부 메모리 서버 필요

클라우드
  - 클라우드를 통해 서버, 스토리지, 데이터베이스, 네트웨크, 소프트웨어, 모니터링 등의 서비스를 제공받는다
  - (1) Infrastructure as a Service(IaaS) : 물리장비들과 미들웨어를 묶어둔 추상화 서비스
  - 가상머신, 스토리지, 네트워크, 운영체제 등의 IT 인프라 대여 서비스. AWS EC2, S3 등
  - (2) Platform as a Service(PaaS) : IaaS를 한번더 추상화 한 서비스
  - AWS Beanstalk(빈스톡), Heroku(헤로쿠) 등
  - (3) Software as a Service(SaaS) : 소프웨어 서비스
  - 구글 드라이브, 드랍박스, 와탭 등

AWS EC2
  - t2.micro 사용 가능(vCPU 1 Core. 가상 CPU, 메모리 1GB) -> vCPU는 물리 CPU 사양의 절반정도의 성능을 가진다
  - 월 750시간 제한
  - AMI(Amazon Machine Image) : 인스턴스 가상 머신에 운영체제 등을 설치할수 있게 생성된 이미지
  - Amazon Linux AMI : 레드햇 베이스, AWS 서비스와의 상성이 좋음, Amazon의 독자적인 개발 레포지토리를 사용하고 있어 yum이 빠름
  - 인스턴스 유형: t2-> 요금 타입 micro -> 사양 

  - 인스턴스 설정 및 시작 -> 탄력적 IP 부여, 보안그룹 체크 -> pem 키 저장 및 복사 -> JDK 설치
  - JDK 11 설치 : yum list java* -> sudo yum install java-11-amazon-corretto-devel.x86_64
    -> 인스턴스 JAVA 버전 목록 확인 sudo /usr/sbin/alternatives --config java
  - 타임존 변경 : sudo rm /etc/localtime -> sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
  - HostName 변경 : sudo vim /etc/sysconfig/network -> sudo vim /etc/hosts 
  - Mysql CLI 설치 : wget https://dev.mysql.com/get/mysql80-community-release-el9-1.noarch.rpm
  -> ls -rlt -> sudo yum install  mysql80-community-release-el9-1.noarch.rpm

CI & CD
  - CI(Continuous Integration 지속적 통합): VCS 시스템(Git, SVN)에 Push가 되면 자동으로 테스트와 빌드를 수행하여 안정적인 배포 파일을 만드는 과정
  - CD(Continuous Deployment 지속적인 배포): 빌드 결과를 자동으로 운영 서버에 무중단 배포까지 진행하는 과정
  - 

