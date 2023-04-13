# 간단 board crud 설계 프로젝트입니다.

## 개요

간단 게시판 ERD 설계 후 JDBC를 통한 DAO 구성을 통해 간단한 CRUD를 해볼 예정입니다.
thymeleaf를 이용하여 view 단을 구성할 예정이며 spring의 controller, service ,DAO 단 구성을 학습할 예정입니다.


## ERD

![게시판 프로젝트](https://user-images.githubusercontent.com/46413809/185789863-c8f73e4b-2a26-455d-a74a-2d7a754f9a1b.PNG)


## 기획

1. 회원은 생성하면 정보 삭제는 일단 X
2. 콘텐츠는 생성후 제목은 변경되어질 수 없다.(내용은 변경 가능!)
3. 댓글은 삭제만 가능하게 -> 일단 수정 X 


## 사진

### 처음 / index page
![image](https://user-images.githubusercontent.com/46413809/190952241-96f26b89-1ce6-4583-8db3-1978ec1b38cb.png)
![image](https://user-images.githubusercontent.com/46413809/190952271-544a5fc5-1988-4394-a669-ca1680908684.png)
![image](https://user-images.githubusercontent.com/46413809/190952303-6494840d-ccf3-4d54-a2a4-846ba23278fd.png)
![image](https://user-images.githubusercontent.com/46413809/190952316-8bf9340a-3727-4142-9e9e-31dd0ec35074.png)
![image](https://user-images.githubusercontent.com/46413809/190952335-4d009093-59f0-4e96-901b-bc365d01e992.png)
![image](https://user-images.githubusercontent.com/46413809/190952362-f36671c0-4cd3-4429-8229-5db6d89b6f9b.png)
