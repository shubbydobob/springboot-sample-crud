### 🌱 수정 및 테스트를 하기 위한 Branch 'fix-issue' 입니다.
- '상품 가격'을 VARCHAR(255) 타입에서 INT로 수정하였습니다.

- '상품 등록일'에서 '최종 수정일'로 수정하였습니다.
  
<img src="https://github.com/user-attachments/assets/0485130c-00e1-4de8-b381-79068194290d" alt="fix-issue #2"
width="500" height="400">

- DATABASE DDL에서도 수정하였습니다.
  
<img src="https://github.com/user-attachments/assets/43d8ca18-0f11-4cb6-b852-fd57e1204ee0" alt="Edit-database-ddl"
width="500" height="400">

#### 'BaseEntity' 클래스를 생성하여 모든 엔티티 클래스에서 공통으로 사용할 기본 속성을 정의합니다.
- 이 클래스는 데이터베이스에 직접 매핑되지 않고 상속을 통해 공동 필드를 재사용합니다.
  
<img src="https://github.com/user-attachments/assets/14554ce1-18bf-4256-91ba-21ab1728c114" alt="Create-BaseEntity"
width="500" height="400">

#### 'Product' 클래스를 생성하여 엔티티로 지정하고 빌더 패턴을 이용해 객체 생성과 업데이트 시 사용합니다. 

 
<img src="https://github.com/user-attachments/assets/ee3f565a-ef23-445d-b33e-6c0c157df20d" alt="Create-Product"
width="500" height="400">
