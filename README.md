# 간단 API 설계 프로젝트입니다.

## 개요

간단 게시판 ERD 설계 후 JDBC를 통한 DAO 부터 JPA로의 전환을 연습해보고자 합니다.
먼저 thymeleaf등을 이용하여 API가 아닌 형태로 제작 후

RestController을 이용 API 프로젝트를 완성할 예정입니다.

## ERD

![게시판 프로젝트](https://user-images.githubusercontent.com/46413809/185789863-c8f73e4b-2a26-455d-a74a-2d7a754f9a1b.PNG)


## 기획

1. 회원은 생성하면 정보 삭제는 일단 X
2. 콘텐츠는 생성후 제목은 변경되어질 수 없다.(내용은 변경 가능!)
3. 댓글은 삭제만 가능하게 -> 일단 수정 X 
