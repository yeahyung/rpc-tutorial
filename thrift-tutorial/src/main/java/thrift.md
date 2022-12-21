## thrift

 - RPC(Remote Procedure Call) 프레임워크, 원격 Method 호출
 - tutorial.thrift 파일을 기준으로 java 코드가 생성된다.
   - namespace 기준으로 package 생성되며, maven 내에 build plugin 설정을 통해 `maven clean install` 실행 시 thrift 파일 기준으로 java 코드가 생성된다.
   - 단순, 서비스 인터페이스 코드만 생성됨
     - Server Side: 구현체를 구현 필요
     - Client Side: 단순 원격 메소드를(인터페이스) 호출